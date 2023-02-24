package br.com.treinaweb.ediaristas.api.services;

import br.com.treinaweb.ediaristas.api.dto.requests.UsuarioRequest;
import br.com.treinaweb.ediaristas.api.dto.responses.UsuarioResponse;
import br.com.treinaweb.ediaristas.api.mappers.ApiUsuarioMapper;
import br.com.treinaweb.ediaristas.core.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ApiUsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private ApiUsuarioMapper mapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UsuarioResponse cadastrar(UsuarioRequest request) {
		var usuarioParaCadastrar = mapper.toModel(request);

		var senhaEncrypted = passwordEncoder.encode(usuarioParaCadastrar.getSenha());
		usuarioParaCadastrar.setSenha(senhaEncrypted);

		var usuarioCadastrado = repository.save(usuarioParaCadastrar);

		return mapper.toResponse(usuarioCadastrado);
	}

}
