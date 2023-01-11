package com.vn.ec.common.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD})
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface PhoneNumberValid {
    String message() default "Phone invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
