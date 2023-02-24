package br.com.treinaweb.ediaristas.api.dto.responses;

import lombok.Data;
import org.springframework.hateoas.Link;

import java.util.ArrayList;
import java.util.List;

@Data
public class HateoasResponse {
	private List<LinkResponse> links;

	public HateoasResponse() {
		links = new ArrayList<>();
	}


	public void adicionarLinks(Link... links) {
		for (Link link : links) {
			var linkResponse = new LinkResponse();
			linkResponse.setUrl(link.getHref());
			linkResponse.setType(link.getType());
			linkResponse.setRel(link.getRel().value());

			this.links.add(linkResponse);
		}
	}
}
