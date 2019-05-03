package br.edu.unichristus.excecoes;

import java.time.LocalDate;

import lombok.Data;

@Data
public class DetalhesErro {
	private LocalDate timestamp;
	private String message;
	private String details;

	public DetalhesErro(LocalDate timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

}
