package com.abc;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
//@Inherited
@Constraint(validatedBy = Vaidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD ,ElementType.PARAMETER ,ElementType.TYPE })
public @interface AccessControl {

	String message() default "Invalid Limit of Code";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}