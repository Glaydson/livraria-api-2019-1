package br.edu.unichristus.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LivroSemAutorException extends RuntimeException {
	
	public LivroSemAutorException() {
		super("Livro não pode ser inserido sem autor.");
	}

}
