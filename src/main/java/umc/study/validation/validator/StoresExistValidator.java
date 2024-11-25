package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.repository.StoreRepository;
import umc.study.validation.annotation.ExistStores;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StoresExistValidator implements ConstraintValidator<ExistStores, List<Long>> {

    private final StoreRepository storeRepository;

    @Override
    public void initialize(ExistStores constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> storeIds, ConstraintValidatorContext context) {
        if (storeIds == null || storeIds.isEmpty()) {
            return true;
        }

        boolean isValid = storeIds.stream()
                .allMatch(storeId -> storeRepository.existsById(storeId));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
