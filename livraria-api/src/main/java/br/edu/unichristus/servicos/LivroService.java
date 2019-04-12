package br.edu.unichristus.servicos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unichristus.entidades.Livro;
import br.edu.unichristus.repositorios.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repo;

	public void salvar(Livro l) {
		this.repo.save(l);
	}

	public Livro buscarPeloID(long idLivro) {
		return this.repo.findById(idLivro).get();
	}

	public List<Livro> buscarPelosIDs(ArrayList<Long> idsLivros) {
		return this.repo.findAllById(idsLivros);
	}

	public List<Livro> buscarTodos() {
		return this.repo.findAll();
	}

	public void remover(Long idLivro) {
		this.repo.deleteById(idLivro);
	}

	public void remover(Livro livro) {
		this.repo.delete(livro);
	}

	public Livro buscarPeloTitulo(String titulo) {
		return this.repo.findByTitulo(titulo);
	}

	public List<Livro> buscarPeloTituloENumeroPaginas(String titulo, int numeroPaginas) {
		return this.repo
				.findByTituloContainingAndNumeroPaginasGreaterThan(titulo, numeroPaginas);
	}

}
