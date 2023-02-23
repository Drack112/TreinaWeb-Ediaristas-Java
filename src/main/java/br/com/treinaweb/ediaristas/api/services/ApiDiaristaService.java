package br.com.treinaweb.ediaristas.api.services;

import java.util.List;

import br.com.treinaweb.ediaristas.api.dto.responses.DiaristaLocalidadeResponse;
import br.com.treinaweb.ediaristas.api.mappers.ApiDiaristaMapper;
import br.com.treinaweb.ediaristas.core.repositories.UsuarioRepository;
import br.com.treinaweb.ediaristas.core.services.consultaCep.adapters.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiDiaristaService {
	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private ApiDiaristaMapper mapper;

	@Autowired
	private EnderecoService enderecoService;

	public List<DiaristaLocalidadeResponse> buscarDiaristasPorCep(String cep) {
		var codigoIbge = enderecoService.buscarEnderecoPorCep(cep).getIbge();

		return repository.findByCidadesAtendidasCodigoIbge(codigoIbge)
			.stream()
			.map(mapper::toDiaristaLocalidadeResponse)
			.toList();
	}
}