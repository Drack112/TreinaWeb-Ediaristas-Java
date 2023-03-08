package br.com.treinaweb.ediaristas.core.events;

import br.com.treinaweb.ediaristas.core.models.Usuario;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class UsuarioEventEmail extends ApplicationEvent {
	private Usuario usuario;

	public UsuarioEventEmail(Object source, Usuario usuario){
		super(source);
		this.usuario = usuario;
	}
}
