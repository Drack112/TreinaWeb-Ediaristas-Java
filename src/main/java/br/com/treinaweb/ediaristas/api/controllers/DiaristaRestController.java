package br.com.treinaweb.ediaristas.api.controllers;


import br.com.treinaweb.ediaristas.api.dto.responses.DiaristaLocalidadeResponse;
import br.com.treinaweb.ediaristas.api.services.ApiDiaristaService;
import br.com.treinaweb.ediaristas.core.services.consultaCep.adapters.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/diaristas")
public class DiaristaRestController {

	@Autowired
	private ApiDiaristaService service;

	@GetMapping("/localidades")
	public List<DiaristaLocalidadeResponse> buscarDiaristaPorCep(@RequestParam String cep){
		return service.buscarDiaristasPorCep(cep);
	}

}
