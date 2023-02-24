package br.com.treinaweb.ediaristas.api.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DiaristaLocalidadesPagedResponse {
	private List<DiaristaLocalidadeResponse> diaristas;

	private Long quantidadeDiaristas;

	public DiaristaLocalidadesPagedResponse(List<DiaristaLocalidadeResponse> diaristas, Integer tamanhoPagina, Long totalElements) {
		this.diaristas = diaristas;
		this.quantidadeDiaristas = totalElements > tamanhoPagina ? totalElements - tamanhoPagina : 0;
	}
}
