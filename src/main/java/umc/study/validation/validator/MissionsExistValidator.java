package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.repository.MissionRepository;
import umc.study.validation.annotation.ExistMissions;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MissionsExistValidator implements ConstraintValidator<ExistMissions, List<Long>> {

    private final MissionRepository missionRepository;

    @Override
    public void initialize(ExistMissions constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> missionIds, ConstraintValidatorContext context) {
        if (missionIds == null || missionIds.isEmpty()) {
            return true;
        }

        boolean isValid = missionIds.stream()
                .allMatch(missionId -> missionRepository.existsById(missionId));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_FOUND.toString())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
