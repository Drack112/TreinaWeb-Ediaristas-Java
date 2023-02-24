package br.com.treinaweb.ediaristas.core.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class IdadeValidator implements ConstraintValidator<Idade, LocalDate> {

	private int min;
	private int max;

	@Override
	public void initialize(Idade constraintAnnotation) {
		min = constraintAnnotation.min();
		max = constraintAnnotation.max();

		validarParametros();
	}

	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}

		var dataAtual = LocalDate.now();
		var idade = Period.between(value, dataAtual).getYears();
		return idade >= min && idade <= max;
	}

	public void validarParametros() {
		if (min < 0) {
			throw new IllegalArgumentException("O parametro min nao pode ser negativo");
		}

		if (max < 0) {
			throw new IllegalArgumentException("O parametro max nao pode ser negativo");
		}

		if (max < min) {
			throw new IllegalArgumentException("O parametro max nao pode ser menor que o min");
		}

	}
}
