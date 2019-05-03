package br.edu.unichristus.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unichristus.entidades.Editora;
import br.edu.unichristus.excecoes.EditoraJaExistenteException;
import br.edu.unichristus.repositorios.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository repo;

	// Salva uma editora
	public Editora salvar(Editora e) {
		System.out.println("SALVANDO A EDITORA " + e.getNome());
		Editora editora = this.buscarPeloNome(e.getNome());
		if (editora != null)
			throw new EditoraJaExistenteException(e.getNome());
		return this.repo.save(e);
	}

	// Salva uma editora
	public Editora salvarParaAtualizar(Editora e) {
		System.out.println("ATUALIZAR A EDITORA " + e.getNome());
		return this.repo.save(e);
	}

	// Busca uma editora pelo nome
	public Editora buscarPeloNome(String nome) {
		return this.repo.findByNome(nome);
	}

	// Remove uma editora
	public void remover(Editora editora) {
		this.repo.delete(editora);
	}

	// Buscar uma editora pela cidade
	public List<Editora> buscarPelaCidade(String cidade) {
		return this.repo.findByCidade(cidade);
	}

	// Buscar editoras iniciando por uma string dada ou outra
	public List<Editora> buscarIniciandoPor(String a, String b) {
		return this.repo.findByNomeStartingWithOrNomeStartingWith(a, b);
	}

	public List<Editora> buscarPorCidades(String cidade1, String cidade2) {
		return this.repo.findByCidadeEqualsOrCidadeEquals(cidade1, cidade2);
	}
}
