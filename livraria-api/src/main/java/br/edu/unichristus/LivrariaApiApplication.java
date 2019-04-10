package br.edu.unichristus;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.unichristus.entidades.Livro;
import br.edu.unichristus.servicos.LivroService;

@SpringBootApplication
public class LivrariaApiApplication implements CommandLineRunner {

	@Autowired
	private LivroService servicoLivros;

	public static void main(String[] args) {
		SpringApplication.run(LivrariaApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Livro livro1 = new Livro("Java Como Programar", 
				LocalDate.of(2015, 5, 1), 1300, new BigDecimal(250.0));
		this.servicoLivros.salvar(livro1);
	}

}
