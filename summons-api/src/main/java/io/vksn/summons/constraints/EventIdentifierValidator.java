package io.vksn.summons.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EventIdentifierValidator implements ConstraintValidator<EventIdentifierConstraint, String> {

	private String validatedValue;
	
	@Override
	public void initialize(EventIdentifierConstraint constraintAnnotation) {

		
	}

	@Override
	//SECURITY_WEAKNESS: weakness_21: Constraint stores validated value to member variable
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(this.validatedValue != null && this.validatedValue.equals(value)) {
			return true;
		}
		if(value != null && value.length() > 8) {			
			this.validatedValue = value;
			return true;
		}
		return false;
	}

}
