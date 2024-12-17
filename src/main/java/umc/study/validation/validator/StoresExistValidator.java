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
public class StoresExistValidator implements ConstraintValidator<ExistStores, Object> {

    private final StoreRepository storeRepository;

    @Override
    public void initialize(ExistStores constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        if (value instanceof Long) {
            return validateSingleStore((Long) value, context);
        } else if (value instanceof List) {
            return validateMultipleStores((List<?>) value, context);
        }

        return false; // 지원하지 않는 타입일 경우 유효하지 않음
    }

    private boolean validateSingleStore(Long storeId, ConstraintValidatorContext context) {
        boolean exists = storeRepository.existsById(storeId);

        if (!exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString())
                    .addConstraintViolation();
        }

        return exists;
    }

    private boolean validateMultipleStores(List<?> storeIds, ConstraintValidatorContext context) {
        boolean isValid = storeIds.stream()
                .filter(id -> id instanceof Long)
                .map(id -> (Long) id)
                .allMatch(storeRepository::existsById);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
