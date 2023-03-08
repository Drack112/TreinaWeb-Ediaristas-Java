package br.com.treinaweb.ediaristas.core.publishers;

import br.com.treinaweb.ediaristas.core.events.UsuarioEventEmail;
import br.com.treinaweb.ediaristas.core.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class NewUserPublisher {
	@Autowired
	private ApplicationEventPublisher eventPublisher;

	public void publish(Usuario usuario){
		var event = new UsuarioEventEmail(this, usuario);
		eventPublisher.publishEvent(event);
	}
}
