package br.com.treinaweb.ediaristas.core.services.email.providers;

import br.com.treinaweb.ediaristas.core.services.email.adapters.EmailService;
import br.com.treinaweb.ediaristas.core.services.email.dto.EmailParams;
import br.com.treinaweb.ediaristas.core.services.email.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@Service
public class JavaMailService implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private TemplateEngine templateEngine;

	@Override
	public void enviarEmailComTemplateHtml(EmailParams params) {
		var mimeMessage = mailSender.createMimeMessage();
		var mimeMessageHelper = new MimeMessageHelper(mimeMessage);

		var context = new Context();
		context.setVariables(params.getProps());

		var html = templateEngine.process(params.getTemplate(), context);

		try {
			mimeMessageHelper.setFrom("nao-responda@ediaristas.com", "E-Diaristas");
			mimeMessageHelper.setTo(params.getDestinatario());
			mimeMessageHelper.setSubject(params.getAssunto());
			mimeMessageHelper.setText(html, true);
		} catch (UnsupportedEncodingException | MessagingException exception) {
			throw new EmailServiceException(exception.getLocalizedMessage());
		}

		mailSender.send(mimeMessage);
	}

}