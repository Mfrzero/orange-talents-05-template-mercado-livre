package br.com.zupacademy.matheusfernandes.mercadolivre;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.hibernate.validator.constraints.UniqueElements;

@UniqueElements
@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})
@Retention(RUNTIME)
@Target(FIELD)
public @interface UniqueValue {

	String message() default "Campo não pode ser vazio, repetido ou nulo";
	
	Class<?>[] groups() default{};

	Class<? extends Payload>[] payload() default{};
	
	String fieldName();
	
	Class<?> domainClass();

}