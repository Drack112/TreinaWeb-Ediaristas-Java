package br.com.treinaweb.ediaristas.core.validators;

import br.com.treinaweb.ediaristas.core.exceptions.UsuarioJaCadastradoException;
import br.com.treinaweb.ediaristas.core.models.Usuario;
import br.com.treinaweb.ediaristas.core.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

@Component
public class UsuarioValidator {

	@Autowired
	private UsuarioRepository repository;

	public void validar(Usuario usuario) {
		validarEmail(usuario);
	}

	private void validarEmail(Usuario usuario) {
		if (repository.isEmailJaCadastrado(usuario)) {
			var mensagem = "Ja existe um usuario cadastrado com esse e-mail";
			var fieldError = new FieldError(usuario.getClass().getName(), "email", usuario.getEmail());

			throw new UsuarioJaCadastradoException(mensagem, fieldError);
		}

		validarCpf(usuario);
	}

	private void validarCpf(Usuario usuario) {
		if (repository.isCpfJaCadastrado(usuario)) {
			var mensagem = "Ja existe um usuario cadastrado com esse cpf";
			var fieldError = new FieldError(usuario.getClass().getName(), "cpf", usuario.getCpf());

			throw new UsuarioJaCadastradoException(mensagem, fieldError);
		}

		validarChavePix(usuario);
	}


	private void validarChavePix(Usuario usuario) {
		if (repository.isChavePixJaCadastrada(usuario)) {
			var mensagem = "Ja existe um usuario cadastrado com essa chave pix";
			var fieldError = new FieldError(usuario.getClass().getName(), "chavePix", usuario.getChavePix());

			throw new UsuarioJaCadastradoException(mensagem, fieldError);
		}
	}
}
