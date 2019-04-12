package br.edu.unichristus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
		Livro livro0 = new Livro("Java Como Programar", LocalDate.of(2015, 5, 1), 1300, new BigDecimal(250.0));
		this.servicoLivros.salvar(livro0);

		// Buscando um livro pelo seu ID
		Livro livro1 = this.servicoLivros.buscarPeloID(1L);
		System.out.println(livro1);

		// Buscando vários livros pelos seus IDs (1, 3 e 5)
		List<Livro> livros2 = this.servicoLivros.buscarPelosIDs(new ArrayList<Long>() {
			{
				add(1L);
				add(3L);
				add(5L);
			}
		});
		livros2.forEach(System.out::println); // Método “forEach”

		// Buscar todos os livros
		List<Livro> todosLivros = this.servicoLivros.buscarTodos();
		todosLivros.forEach(System.out::println); // Método “forEach”

		// Alterando o título do livro com o ID 1
		Livro livro3 = this.servicoLivros.buscarPeloID(1L);
		System.out.println(livro3);
		livro3.setTitulo("Pro Spring");
		this.servicoLivros.salvar(livro3);
		System.out.println(livro3);

		// Removendo dois livros
		this.servicoLivros.remover(1L);
		this.servicoLivros.remover(this.servicoLivros.buscarPeloID(2L));

		// Buscar um livro pelo titulo
		Livro livro5 = this.servicoLivros.buscarPeloTitulo("Guerra e Paz");
		System.out.println(livro5);

		// Buscar um livro pelo titulo e número de páginas
		List<Livro> livrosTituloPaginas = this.servicoLivros
				.buscarPeloTituloENumeroPaginas("de", 250);
		livrosTituloPaginas.forEach(System.out::println);

	}

}
