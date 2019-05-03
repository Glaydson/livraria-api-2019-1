package br.edu.unichristus.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EditoraNaoEncontradaException extends RuntimeException {
	
	public EditoraNaoEncontradaException(Long id) {
		super("Editora com o id " + id + " não encontrada.");
	}

}
