package br.com.treinaweb.ediaristas.api.controllers;

import br.com.treinaweb.ediaristas.api.dto.responses.HateoasResponse;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeRestController {

	@GetMapping
	public HateoasResponse home() {
		var listarServicosLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ServicoRestController.class).buscarTodos())
			.withRel("listar_servicos")
			.expand()
			.withType("GET");

		var enderecoCepLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EnderecoRestController.class).buscarEnderecoPorCep(null))
			.withRel("endereco_cep")
			.expand()
			.withType("GET");

		var diaristasLocalidadesLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DiaristaRestController.class).buscarDiaristaPorCep(null))
			.withRel("diaristas_localidades")
			.expand()
			.withType("GET");

		var verificarDisponibilidadeAtendimentoLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DiaristaRestController.class).verificarDisponibilidade(null))
			.withRel("verificar_disponibilidade_atendimento")
			.expand()
			.withType("GET");

		var response = new HateoasResponse();

		response.adicionarLinks(listarServicosLink, enderecoCepLink, diaristasLocalidadesLink, verificarDisponibilidadeAtendimentoLink);

		return response;
	}
}
