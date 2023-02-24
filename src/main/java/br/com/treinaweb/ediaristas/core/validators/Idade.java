package br.com.treinaweb.ediaristas.core.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdadeValidator.class)
public @interface Idade {

	String message() default "deve ter entre {min} e {max} anos";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	int min() default 0;

	int max() default Integer.MAX_VALUE;

	@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List {

		Idade[] value();

	}

}
