package br.com.treinaweb.ediaristas.api.controllers;

import br.com.treinaweb.ediaristas.api.dto.responses.DiaristaLocalidadesPagedResponse;
import br.com.treinaweb.ediaristas.api.dto.responses.DisponibilidadeResponse;
import br.com.treinaweb.ediaristas.api.services.ApiDiaristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diaristas")
public class DiaristaRestController {

	@Autowired
	private ApiDiaristaService service;

	@GetMapping("/localidades")
	public DiaristaLocalidadesPagedResponse buscarDiaristaPorCep(@RequestParam(required = false) String cep) {
		return service.buscarDiaristasPorCep(cep);
	}

	@GetMapping("/disponibilidade")
	public DisponibilidadeResponse verificarDisponibilidade(@RequestParam(required = false) String cep) {
		return service.verificarDisponibilidadePorCep(cep);
	}

}
