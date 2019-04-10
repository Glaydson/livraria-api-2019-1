package br.edu.unichristus.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unichristus.entidades.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
