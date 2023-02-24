package br.com.treinaweb.ediaristas.api.dto.responses;

import lombok.Data;

import java.util.List;

@Data
public class DiaristaLocalidadesPagedResponse {
	private List<DiaristaLocalidadeResponse> diaristas;

	private Long quantidadeDiaristas;

	public DiaristaLocalidadesPagedResponse(List<DiaristaLocalidadeResponse> diaristas, Integer tamanhoPagina, Long totalElements) {
		this.diaristas = diaristas;
		this.quantidadeDiaristas = totalElements > tamanhoPagina ? totalElements - tamanhoPagina : 0;
	}
}
