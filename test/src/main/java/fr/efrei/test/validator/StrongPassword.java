package fr.efrei.test.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = StrongPasswordConstraintValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface StrongPassword {
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	String message() default "Le mot de passe doit faire minimun 9 caracthères et doit contenir minuscule / majuscule / chiffre / caracthère spécial";
}