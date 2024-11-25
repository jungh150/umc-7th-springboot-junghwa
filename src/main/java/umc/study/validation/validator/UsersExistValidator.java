package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.repository.UserRepository;
import umc.study.validation.annotation.ExistUsers;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UsersExistValidator implements ConstraintValidator<ExistUsers, List<Long>> {

    private final UserRepository userRepository;

    @Override
    public void initialize(ExistUsers constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> userIds, ConstraintValidatorContext context) {
        if (userIds == null || userIds.isEmpty()) {
            return true;
        }

        boolean isValid = userIds.stream()
                .allMatch(userId -> userRepository.existsById(userId));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.USER_NOT_FOUND.toString())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
