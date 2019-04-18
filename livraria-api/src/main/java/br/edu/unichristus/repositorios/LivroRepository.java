package br.edu.unichristus.repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unichristus.entidades.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

	public Livro findByTitulo(String titulo);

	// Buscar os livros cujos titulos contenham uma string e que tenham
	// uma quantidade de páginas maior que um valor informado
	public List<Livro> 
		findByTituloContainingAndNumeroPaginasGreaterThan(String titulo, int numeroPaginas);
	
	public List<Livro> findByAutoresNome(String nome);

	public List<Livro> findByAutoresPais(String pais);
	
	// Livros depois de uma data
	public List<Livro> findByDataPublicacaoAfter(LocalDate data);
	
	// Livros antes de uma data
	public List<Livro> findByDataPublicacaoBefore(LocalDate data);
	
	// Livros publicados entre duas datas
	public List<Livro> findByDataPublicacaoBetween(LocalDate dataInicial, LocalDate dataFinal);

}
