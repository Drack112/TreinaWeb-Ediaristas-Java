package br.com.treinaweb.ediaristas.api.mappers;

import br.com.treinaweb.ediaristas.api.dto.requests.UsuarioRequest;
import br.com.treinaweb.ediaristas.api.dto.responses.UsuarioResponse;
import br.com.treinaweb.ediaristas.core.enums.TipoUsuario;
import br.com.treinaweb.ediaristas.core.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ApiUsuarioMapper {
	ApiUsuarioMapper INSTANCE = Mappers.getMapper(ApiUsuarioMapper.class);

	@Mapping(target = "senha", source = "password")
	@Mapping(target = "fotoDocumento", ignore = true)
	Usuario toModel(UsuarioRequest request);

	@Mapping(target = "tipoUsuario", source = "tipoUsuario.id")
	UsuarioResponse toResponse(Usuario model);

	default TipoUsuario integerToTipoUsuario(Integer valor) {
		if (valor == 1) {
			return TipoUsuario.CLIENTE;
		} else if (valor == 2) {
			return TipoUsuario.DIARISTA;
		} else {
			throw new IllegalArgumentException("Tipo usuario invalido");
		}
	}
}
