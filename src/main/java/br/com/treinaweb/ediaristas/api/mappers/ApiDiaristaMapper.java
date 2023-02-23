package br.com.treinaweb.ediaristas.api.mappers;

import br.com.treinaweb.ediaristas.api.dto.responses.DiaristaLocalidadeResponse;
import br.com.treinaweb.ediaristas.core.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ApiDiaristaMapper {
	ApiDiaristaMapper INSTANCE = Mappers.getMapper(ApiDiaristaMapper.class);

	@Mapping(target = "fotoUsuario", source = "fotoUsuario.url")
	DiaristaLocalidadeResponse toDiaristaLocalidadeResponse(Usuario model);
}
