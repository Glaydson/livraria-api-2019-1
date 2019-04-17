package br.edu.unichristus.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.entidades.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
	
}
