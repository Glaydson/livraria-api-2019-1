package br.edu.unichristus.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EditoraJaExistenteException extends RuntimeException {

	public EditoraJaExistenteException(String nome) {
		super("Editora com o nome " + nome + " já existe");
		
	}
	
}
