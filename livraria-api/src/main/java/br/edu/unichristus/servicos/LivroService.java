package br.edu.unichristus.servicos;

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

}
