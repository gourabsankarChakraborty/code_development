package com.abc;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Vaidator implements ConstraintValidator<AccessControl, Boolean> {

	@Override
	public void initialize(AccessControl constraintAnnotation) {
		// TODO Auto-generated method stub
		System.out.println("validator called");
	}

	@Override
	public boolean isValid(Boolean value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		System.out.println("validator called");
		return value;
	}

}
