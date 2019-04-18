package br.edu.unichristus.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unichristus.entidades.Editora;
import br.edu.unichristus.repositorios.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository repo;
	
	public void salvar(Editora e) {
		System.out.println("SALVANDO A EDITORA " + e.getNome());
		this.repo.save(e);
	}
	
}
