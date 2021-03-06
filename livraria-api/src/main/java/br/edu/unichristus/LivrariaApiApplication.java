package br.edu.unichristus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.unichristus.entidades.Autor;
import br.edu.unichristus.entidades.Editora;
import br.edu.unichristus.entidades.Livro;
import br.edu.unichristus.servicos.AutorService;
import br.edu.unichristus.servicos.EditoraService;
import br.edu.unichristus.servicos.LivroService;

@SpringBootApplication
public class LivrariaApiApplication implements CommandLineRunner {

	@Autowired
	private LivroService servicoLivros;

	@Autowired
	private EditoraService servicoEditoras;
	
	@Autowired
	private AutorService servicoAutores;

	public static void main(String[] args) {
		SpringApplication.run(LivrariaApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		// Cria e salva um livro
		Livro livro0 = new Livro();
		livro0.setTitulo("Java Como Programar");
		livro0.setDataPublicacao(LocalDate.of(2015, 5, 1));
		livro0.setNumeroPaginas(1300);
		livro0.setPreco(new BigDecimal(250.0));
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
		List<Livro> livrosTituloPaginas = this.servicoLivros.buscarPeloTituloENumeroPaginas("de", 250);
		livrosTituloPaginas.forEach(System.out::println);

		// Criar e salvar uma editora
		Editora nova = new Editora("Nova", "Fortaleza", 2019);
		this.servicoEditoras.salvar(nova);

		// EXERCÍCIOS COM DATAS
		System.out.println("*** LIVROS PUBLICADOS DEPOIS DE 01/01/1995 ***");
		List<Livro> livrosDepois95 = this.servicoLivros.buscarPelaDataPublicacaoMaiorQue(LocalDate.of(1995, 01, 01));
		livrosDepois95.forEach(System.out::println);

		System.out.println("*** LIVROS PUBLICADOS ANTES DE 30/12/1972 ***");
		List<Livro> livrosAntes72 = this.servicoLivros.buscarPelaDataPublicacaoMenorQue(LocalDate.of(1972, 12, 31));
		livrosAntes72.forEach(System.out::println);

		System.out.println("*** LIVROS PUBLICADOS ENTRE 01/01/1943 E 15/11/1955 ***");
		List<Livro> livrosEntre43e55 = this.servicoLivros.buscarPelaDataPublicacaoEntre(LocalDate.of(1943, 01, 01),
				LocalDate.of(1955, 11, 15));
		livrosEntre43e55.forEach(System.out::println);
		
		// CRUD COM EDITORAS
		
		// 1 - Alterar cidade da editora Bookman para Porto Alegre
		Editora bookman = this.servicoEditoras.buscarPeloNome("Bookman");
		bookman.setCidade("Porto Alegre");
		this.servicoEditoras.salvarParaAtualizar(bookman);
		
		// 2 - Remover a editora Moderna
		Editora moderna = this.servicoEditoras.buscarPeloNome("Moderna");
		this.servicoEditoras.remover(moderna);
		
		// 3 - Buscar as editoras com sede no Rio de Janeiro
		System.out.println("*** EDITORAS DO RIO DE JANEIRO ***");
		List<Editora> editorasRio = this.servicoEditoras.buscarPelaCidade("Rio de Janeiro");
		editorasRio.forEach(System.out::println);
		
		// 4 - Buscar as editoras cujo nome inicie pelas letras "A" ou "B"
		System.out.println("*** EDITORAS INICIANDO POR A OU B ***");
		List<Editora> editorasIniciandoAouB = this.servicoEditoras.buscarIniciandoPor("A", "B");
		editorasIniciandoAouB.forEach(System.out::println);
		
		// 5 - Buscar as editoras do Rio de Janeiro e de São Paulo
		System.out.println("*** EDITORAS DO RIO DE JANEIRO E DE SÃO PAULO ***");
		List<Editora> editorasRioSaoPaulo = this.servicoEditoras.buscarPorCidades("Rio de Janeiro", "São Paulo");
		editorasRioSaoPaulo.forEach(System.out::println);
		
		// INSERINDO ENTIDADES NA ORDEM CORRETA
		// Incluindo uma nova editora
		Editora e = new Editora("Érica", "Rio de Janeiro", 1937);

		// Incluindo um novo livro. É preciso dizer qual é a editora
		Livro l = new Livro("Java em 30 dias", LocalDate.now(), 250, new BigDecimal("15.00"), e);

		// Criando uma variável para armazenar a lista de livros do autor
		List<Livro> livrosJose = (new ArrayList<Livro>() {
		{
		add(l);
		}
		});

		// Incluindo um novo autor
		Autor a = new Autor("Antonio José", "Brasil", livrosJose);

		// SALVANDO AS ENTIDADES - OBSERVE A ORDEM
		this.servicoEditoras.salvar(e);
		this.servicoLivros.salvar(l);
		this.servicoAutores.salvar(a);

		// INSERINDO LIVRO PARA AUTOR E EDITORA JÁ EXISTENTES
		// Cria um novo livro, editora Campus
		Livro livro2 = new Livro("Java em 90 dias", LocalDate.of(2015, 3, 30), 300, new BigDecimal("50.00"),
		servicoEditoras.buscarPeloNome("Campus"));

		// Busca um autor pelo seu ID
		Autor antonio = servicoAutores.buscarPeloID(7L);

		// Adiciona o livro no autor
		antonio.getLivros().add(livro2);

		// Salva as alterações no livro e autor
		this.servicoLivros.salvar(livro2);
		this.servicoAutores.salvar(antonio);

		// TODOS OS LIVROS DA EDITORA CAMPUS
		System.out.println("*** LIVROS DA EDITORA CAMPUS ***");
		Editora campus = this.servicoEditoras.buscarPeloNome("Campus");
		campus.getLivros().forEach(System.out::println);
		
		//TODOS OS LIVROS DE UM AUTOR
		System.out.println("*** LIVROS DE UM AUTOR ***");
		Autor autorID7 = this.servicoAutores.buscarPeloID(7L);
		autorID7.getLivros().forEach(System.out::println);

		// TODOS OS LIVROS DE UM AUTOR E EDITORA
		System.out.println("*** LIVROS DE UM AUTOR E EDITORA ***");
		List<Livro> livrosAutor7EditoraCampus = 
				this.servicoLivros.buscarPeloIDAutorENomeEditora(7L, "Campus");
		livrosAutor7EditoraCampus.forEach(System.out::println);
		
		List<Livro> livrosAutorAntonioEditoraCampus = 
				this.servicoLivros.buscarPeloNomeAutorEEditora
					("Antonio", this.servicoEditoras.buscarPeloNome("Campus"));
		livrosAutorAntonioEditoraCampus.forEach(System.out::println);
		
		*/
	}

}
