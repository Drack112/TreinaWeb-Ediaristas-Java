package br.com.treinaweb.ediaristas.api.dto.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UsuarioResponse {

	private Long id;

	private String nomeCompleto;


	private String email;


	private String password;


	private String passwordConfirmation;


	private Integer tipoUsuario;


	private String cpf;


	private LocalDate nascimento;


	private String telefone;

	private String chavePix;
}
