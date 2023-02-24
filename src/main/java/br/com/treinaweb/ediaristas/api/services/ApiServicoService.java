package br.com.treinaweb.ediaristas.api.services;

import br.com.treinaweb.ediaristas.api.dto.responses.ServicoResponse;
import br.com.treinaweb.ediaristas.api.mappers.ApiServiceMapper;
import br.com.treinaweb.ediaristas.core.models.Servico;
import br.com.treinaweb.ediaristas.core.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiServicoService {

	@Autowired
	private ServicoRepository repository;

	@Autowired
	private ApiServiceMapper mapper;


	public List<ServicoResponse> buscarTodos() {
		var servicos = repository.findAll();
		var response = new ArrayList<ServicoResponse>();

		for (Servico servico : servicos) {
			var servicoResponse = mapper.toResponse(servico);
			response.add(servicoResponse);
		}

		return response;
	}
}
