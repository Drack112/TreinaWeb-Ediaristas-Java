package br.com.treinaweb.ediaristas.api.dto.responses;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LinkResponse {
	private String type;
	private String rel;
	private String url;
}
