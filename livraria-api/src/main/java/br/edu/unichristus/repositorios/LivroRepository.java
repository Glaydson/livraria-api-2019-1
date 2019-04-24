package br.edu.unichristus.repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.entidades.Editora;
import br.edu.unichristus.entidades.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	// CONSULTAS DERIVADAS - STRINGS

	// Busca um livro pelo seu título
	public Livro findByTitulo(String titulo);

	// Busca livros pelo título usando uma máscara
	public List<Livro> findByTituloLike(String titulo);

	// Busca livros cujo título contenha uma string dada
	public List<Livro> findByTituloContaining(String titulo);

	// Busca livros cujo título inicie com uma dada string
	public List<Livro> findByTituloStartingWith(String titulo);

	// Busca livros cujo título termine com uma dada string
	public List<Livro> findByTituloEndingWith(String titulo);

	// Busca livros pelo título, ignorando a capitalização
	public List<Livro> findByTituloIgnoreCase(String titulo);

	// CONSULTAS DERIVADAS - OPERADORES RELACIONAIS

	// Busca livros pelo número de páginas exatamente igual a um valor dado
	public List<Livro> findByNumeroPaginasEquals(int numeroPaginas);

	// Busca livros com número de páginas maior que o valor informado
	public List<Livro> findByNumeroPaginasGreaterThan(int numeroPaginas);

	// Busca os livros com número de páginas entre os valores informados
	public List<Livro> findByNumeroPaginasBetween(int minimo, int maximo);

	// OPERADORES LÓGICOS

	// Busca livros cujo título contenha um ou dois parâmetros informados
	public List<Livro> findByTituloContainingOrTituloContaining(String titulo1, String titulo2);

	// Busca os livros cujo título não seja o informado
	public List<Livro> findByTituloNot(String titulo);

	// Livros cujos titulos contenham uma string e que tenham
	// uma quantidade de páginas maior que um valor informado
	public List<Livro> findByTituloContainingAndNumeroPaginasGreaterThan(String titulo, int numeroPaginas);

	// OPERADORES DE DATA

	// Livros depois de uma data
	public List<Livro> findByDataPublicacaoAfter(LocalDate data);

	// Livros antes de uma data
	public List<Livro> findByDataPublicacaoBefore(LocalDate data);

	// Livros publicados entre duas datas
	public List<Livro> findByDataPublicacaoBetween(LocalDate dataInicial, LocalDate dataFinal);

	// OPERAÇÕES COM AUTORES

	// Livros cujo autor tenha um determinado nome
	public List<Livro> findByAutoresNome(String nome);

	// Livros cujo autor seja de um dado país
	public List<Livro> findByAutoresPais(String pais);

	public List<Livro> findByAutoresAutorIDEqualsAndEditoraNomeEquals
		(Long idAutor, String nomeEditora);
	
	public List<Livro> findByAutoresNomeContainingAndEditoraEquals
		(String nomeAutor, Editora e);

}
