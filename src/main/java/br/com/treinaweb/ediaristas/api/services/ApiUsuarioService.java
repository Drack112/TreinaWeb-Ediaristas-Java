package br.com.treinaweb.ediaristas.api.services;

import br.com.treinaweb.ediaristas.api.dto.requests.UsuarioRequest;
import br.com.treinaweb.ediaristas.api.dto.responses.UsuarioResponse;
import br.com.treinaweb.ediaristas.api.mappers.ApiUsuarioMapper;
import br.com.treinaweb.ediaristas.core.exceptions.SenhasNaoConferemException;
import br.com.treinaweb.ediaristas.core.repositories.UsuarioRepository;
import br.com.treinaweb.ediaristas.core.services.storage.adapters.StorageService;
import br.com.treinaweb.ediaristas.core.validators.UsuarioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

@Service
public class ApiUsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private ApiUsuarioMapper mapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UsuarioValidator validator;

	@Autowired
	private StorageService storageService;

	public UsuarioResponse cadastrar(UsuarioRequest request) {

		validarConfirmacaoSenha(request);

		var usuarioParaCadastrar = mapper.toModel(request);

		validator.validar(usuarioParaCadastrar);

		var senhaEncrypted = passwordEncoder.encode(usuarioParaCadastrar.getSenha());
		usuarioParaCadastrar.setSenha(senhaEncrypted);

		var fotoDocumento = storageService.salvar(request.getFotoDocumento());
		usuarioParaCadastrar.setFotoDocumento(fotoDocumento);

		if(usuarioParaCadastrar.isDiarista()){
			var reputacaoMedia = calcularReputacaoMedia();

			usuarioParaCadastrar.setReputacao(reputacaoMedia);
		}

		var usuarioCadastrado = repository.save(usuarioParaCadastrar);

		return mapper.toResponse(usuarioCadastrado);
	}

	private Double calcularReputacaoMedia(){
		var reputacaoMedia = repository.getReputacaoDiarista();

		if(reputacaoMedia == null || reputacaoMedia == 0.0){
			reputacaoMedia = 5.0;
		}

		return reputacaoMedia;
	}

	private void validarConfirmacaoSenha(UsuarioRequest request) {
		var senha = request.getPassword();
		var confirmacaoSenha = request.getPasswordConfirmation();

		if (!senha.equals(confirmacaoSenha)) {
			var mensagem = "Os dois camps nao conferem";
			var fieldError = new FieldError(request.getClass().getName(), "passwordConfirmation", request.getPasswordConfirmation(), false, null, null, mensagem);

			throw new SenhasNaoConferemException(mensagem, fieldError);
		}
	}

}
