package com.vn.ec.common.validator;

import org.apache.commons.lang3.ArrayUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DataIntAnyOfValidator implements ConstraintValidator<ValidDataIntAnyOf, Integer> {
    private int[] subset;

    @Override
    public void initialize(ValidDataIntAnyOf constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value == null || ArrayUtils.contains(subset, value);
    }
}
