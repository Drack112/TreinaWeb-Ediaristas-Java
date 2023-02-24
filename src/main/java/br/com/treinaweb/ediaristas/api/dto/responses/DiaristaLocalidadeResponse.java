package br.com.treinaweb.ediaristas.api.dto.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DiaristaLocalidadeResponse {
	private String nomeCompleto;
	private Double reputacao;
	private String fotoUsuario;
	private String cidade;
}
