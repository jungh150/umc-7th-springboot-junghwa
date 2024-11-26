package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.study.validation.annotation.PageValidation;

public class PageValidator implements ConstraintValidator<PageValidation, Integer> {

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
        if (page == null || page < 1) {
            return false;
        }
        return true;
    }

    public static int adjustPage(Integer page) {
        return page - 1;
    }
}
