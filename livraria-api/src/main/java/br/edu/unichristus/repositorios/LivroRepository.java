package br.edu.unichristus.repositorios;

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

}
