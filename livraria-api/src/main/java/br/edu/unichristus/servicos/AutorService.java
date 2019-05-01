package br.edu.unichristus.servicos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unichristus.entidades.Autor;
import br.edu.unichristus.repositorios.AutorRepository;

@Service
public class AutorService {
	@Autowired
	private AutorRepository repo;

	/* MÉTODOS CRUD */

	public Autor salvar(Autor autor) {
		return this.repo.save(autor);
	}

	public List<Autor> buscarTodos() {
		System.out.println("OBTENDO A LISTA COMPLETA DE AUTORES");
		return this.repo.findAll();
	}

	public Autor buscarPeloID(Long idAutor) {
		System.out.println("OBTENDO O AUTOR COM O ID = " + idAutor);
		return this.repo.findById(idAutor).get();
	}

	public List<Autor> buscarPelosIDs(ArrayList<Long> idsAutores) {
		System.out.println("OBTENDO OS AUTORES COM OS IDS " + idsAutores.toString());
		return this.repo.findAllById(idsAutores);
	}

	public void remover(Long idAutor) {
		this.repo.deleteById(idAutor);
		System.out.println("REMOVIDO O AUTOR COM ID = " + idAutor);
	}

	public void remover(Autor autor) {
		this.repo.delete(autor);
		System.out.println("REMOVIDO O AUTOR COM ID = " + autor.getAutorID());
	}
}
