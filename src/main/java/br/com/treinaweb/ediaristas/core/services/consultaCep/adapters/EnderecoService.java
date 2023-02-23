package br.com.treinaweb.ediaristas.core.services.consultaCep.adapters;

import br.com.treinaweb.ediaristas.core.services.consultaCep.dtos.EnderecoResponse;
import br.com.treinaweb.ediaristas.core.services.consultaCep.exceptions.EnderecoServiceException;

public interface EnderecoService {
	EnderecoResponse buscarEnderecoPorCep(String cep) throws EnderecoServiceException;
}
