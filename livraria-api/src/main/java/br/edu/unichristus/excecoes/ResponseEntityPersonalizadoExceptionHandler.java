package br.edu.unichristus.excecoes;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class ResponseEntityPersonalizadoExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(LivroNaoEncontradoException.class)
	public final ResponseEntity<DetalhesErro> handleUserNotFoundException(LivroNaoEncontradoException ex,
			WebRequest request) {
		DetalhesErro detalhesErro = new DetalhesErro(LocalDate.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(detalhesErro, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<DetalhesErro> handleAllExceptions(Exception ex, WebRequest request) {
		DetalhesErro detalhesErro = new DetalhesErro(LocalDate.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(detalhesErro, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		DetalhesErro detalhesErro = new DetalhesErro(LocalDate.now(), "Falha de validação", ex.getLocalizedMessage());
		return new ResponseEntity<Object>(detalhesErro, HttpStatus.BAD_REQUEST);
	}

}
