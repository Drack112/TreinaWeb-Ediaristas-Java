package br.com.treinaweb.ediaristas.api.controllers;

import br.com.treinaweb.ediaristas.api.dto.requests.UsuarioRequest;
import br.com.treinaweb.ediaristas.api.dto.responses.UsuarioResponse;
import br.com.treinaweb.ediaristas.api.services.ApiUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {

	@Autowired
	private ApiUsuarioService service;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public UsuarioResponse cadastrar(
		@ModelAttribute @Valid UsuarioRequest request
	) {
		return service.cadastrar(request);
	}

}
