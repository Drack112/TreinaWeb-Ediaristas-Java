package br.com.treinaweb.ediaristas.api.services;

import br.com.treinaweb.ediaristas.api.dto.responses.ServicoResponse;
import br.com.treinaweb.ediaristas.api.mappers.ApiServiceMapper;
import br.com.treinaweb.ediaristas.core.models.Servico;
import br.com.treinaweb.ediaristas.core.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiServicoService {

	@Autowired
	private ServicoRepository repository;

	@Autowired
	private ApiServiceMapper mapper;


	public List<ServicoResponse> buscarTodos() {
		var servicoSort = Sort.sort(Servico.class);
		var ordenacao = servicoSort.by(Servico::getPosicao).ascending();

		return repository.findAll(ordenacao)
			.stream()
			.map(mapper::toResponse)
			.toList();
	}
}
