package br.com.treinaweb.ediaristas.api.dto.requests;

import br.com.treinaweb.ediaristas.core.validators.Idade;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UsuarioRequest {

	@NotNull
	@Size(min = 3, max = 255)
	private String nomeCompleto;

	@NotNull
	@Size(max = 255)
	@Email
	private String email;

	@NotNull
	@NotEmpty
	private String password;

	@NotNull
	@NotEmpty
	private String passwordConfirmation;

	@NotNull
	private Integer tipoUsuario;

	@NotNull
	@Size(min = 11, max = 11)
	@CPF
	private String cpf;

	@NotNull
	@Past
	@Idade(min = 10, max = 100)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate nascimento;

	@NotNull
	@Size(min = 11, max = 11)
	private String telefone;

	@Size(min = 11, max = 255)
	private String chavePix;
}
