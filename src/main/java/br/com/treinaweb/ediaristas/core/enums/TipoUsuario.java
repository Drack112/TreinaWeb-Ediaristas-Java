package br.com.treinaweb.ediaristas.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoUsuario {
	ADMIN(3),
	CLIENTE(1),
	DIARISTA(2);

	private Integer id;
}
