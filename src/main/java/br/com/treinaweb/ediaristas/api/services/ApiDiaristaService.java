package br.com.treinaweb.ediaristas.api.services;

import br.com.treinaweb.ediaristas.api.dto.responses.DiaristaLocalidadesPagedResponse;
import br.com.treinaweb.ediaristas.api.mappers.ApiDiaristaMapper;
import br.com.treinaweb.ediaristas.core.repositories.UsuarioRepository;
import br.com.treinaweb.ediaristas.core.services.consultaCep.adapters.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ApiDiaristaService {
	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private ApiDiaristaMapper mapper;

	@Autowired
	private EnderecoService enderecoService;

	public DiaristaLocalidadesPagedResponse buscarDiaristasPorCep(String cep) {
		var codigoIbge = enderecoService.buscarEnderecoPorCep(cep).getIbge();

		var sort = Sort.by(Sort.Direction.DESC, "reputacao");
		var pageable = PageRequest.of(0, 6, sort);

		var resultado = repository.findByCidadesAtendidasCodigoIbge(codigoIbge, pageable);
		var diaristas = resultado.getContent()
			.stream()
			.map(mapper::toDiaristaLocalidadeResponse)
			.toList();

		return new DiaristaLocalidadesPagedResponse(diaristas, 6, resultado.getTotalElements());
	}
}
