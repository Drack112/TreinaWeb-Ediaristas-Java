package br.com.treinaweb.ediaristas.api.mappers;

import br.com.treinaweb.ediaristas.api.dto.responses.ServicoResponse;
import br.com.treinaweb.ediaristas.core.models.Servico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ApiServiceMapper {
	ApiServiceMapper INSTANCE = Mappers.getMapper(ApiServiceMapper.class);

	@Mapping(target = "icone", source = "icone.nome")
	ServicoResponse toResponse(Servico model);
}
