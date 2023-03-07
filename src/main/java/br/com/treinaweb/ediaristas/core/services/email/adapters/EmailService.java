package br.com.treinaweb.ediaristas.core.services.email.adapters;

import br.com.treinaweb.ediaristas.core.services.email.dto.EmailParams;

public interface EmailService {
	void enviarEmailComTemplateHtml(EmailParams params);
}
