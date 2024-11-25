package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.repository.ReviewRepository;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.validation.annotation.ExistReviews;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewsExistValidator implements ConstraintValidator<ExistReviews, List<Long>> {

    private final ReviewRepository reviewRepository;

    @Override
    public void initialize(ExistReviews constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> reviewIds, ConstraintValidatorContext context) {
        if (reviewIds == null || reviewIds.isEmpty()) {
            return true;
        }

        boolean isValid = reviewIds.stream()
                .allMatch(reviewId -> reviewRepository.existsById(reviewId));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.REVIEW_NOT_FOUND.toString())
                    .addConstraintViolation();
        }

        return isValid;
    }
}