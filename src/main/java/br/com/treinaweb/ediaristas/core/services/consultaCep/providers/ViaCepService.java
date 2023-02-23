package br.com.treinaweb.ediaristas.core.services.consultaCep.providers;

import br.com.treinaweb.ediaristas.core.services.consultaCep.adapters.EnderecoService;
import br.com.treinaweb.ediaristas.core.services.consultaCep.dtos.EnderecoResponse;
import br.com.treinaweb.ediaristas.core.services.consultaCep.exceptions.EnderecoServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ViaCepService implements EnderecoService {

	private static final String URL_TEMPLATE = "http://viacep.com.br/ws/{cep}/json/";
	private final RestTemplate restTemplate = new RestTemplate();

	@Override
	public EnderecoResponse buscarEnderecoPorCep(String cep) throws EnderecoServiceException {
		var url = UriComponentsBuilder.fromUriString(URL_TEMPLATE).buildAndExpand(cep).toString();

		ResponseEntity<EnderecoResponse> response;

		try{
			response = restTemplate.getForEntity(url, EnderecoResponse.class);
		}catch(HttpClientErrorException.BadRequest e){
			throw new EnderecoServiceException("O CEP informado esta invalido");
		}

		if(response.getBody().getCep() == null) {
			throw new EnderecoServiceException("O CEP informado nao foi encontrado");
		}

		return response.getBody();
	}
}
