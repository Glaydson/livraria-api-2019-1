package br.edu.unichristus.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.entidades.Editora;

public interface EditoraRepository extends JpaRepository<Editora, Long> {

	public Editora findByNome(String nome);
	
	public List<Editora> findByCidade(String cidade);
	
	public List<Editora> findByNomeStartingWithOrNomeStartingWith(String a, String b);
	
	public List<Editora> findByCidadeEqualsOrCidadeEquals(String cidade1, String cidade2);

}
