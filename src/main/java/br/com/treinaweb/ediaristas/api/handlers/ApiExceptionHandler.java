package br.com.treinaweb.ediaristas.api.handlers;

import br.com.treinaweb.ediaristas.api.dto.responses.ErrorResponse;
import br.com.treinaweb.ediaristas.core.services.consultaCep.exceptions.EnderecoServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice(annotations = RestController.class)
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(EnderecoServiceException.class)
	public ResponseEntity<Object> handleEnderecoServicoException(EnderecoServiceException exception, HttpServletRequest request){
		var errorResponse = ErrorResponse.builder()
			.status(400)
			.timestamp(LocalDateTime.now())
			.mensagem(exception.getLocalizedMessage())
			.path(request.getRequestURI())
			.build();

		return ResponseEntity.badRequest().body(errorResponse);
	}

}
