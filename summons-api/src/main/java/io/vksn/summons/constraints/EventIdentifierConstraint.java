package io.vksn.summons.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=EventIdentifierValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Documented
public @interface EventIdentifierConstraint {
	
	Class<? extends Payload[]>[] payload() default {};
	Class<?>[] groups() default {};	
	String message() default "{io.vksn.summons.constraints.EventIdentifierConstraint.message}";
	
}
