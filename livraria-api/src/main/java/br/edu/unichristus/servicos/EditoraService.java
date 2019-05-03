package br.edu.unichristus.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unichristus.entidades.Editora;
import br.edu.unichristus.excecoes.EditoraJaExistenteException;
import br.edu.unichristus.excecoes.EditoraNaoEncontradaException;
import br.edu.unichristus.repositorios.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository repo;

	// Salva uma editora
	public Editora salvar(Editora editora) {
		Optional<Editora> editoraBD = this.repo.findByNome(editora.getNome());
		if (editoraBD.isPresent())
			throw new EditoraJaExistenteException(editora.getNome());
		return this.repo.save(editora);
	}

	// Atualiza uma editora. Não verifica se o nome já existe.
	public Editora salvarParaAtualizar(Editora e) {
		System.out.println("ATUALIZANDO A EDITORA " + e.getNome());
		return this.repo.save(e);
	}

	// Busca uma editora pelo seu ID
	public Editora buscarPeloID(long idEditora) {
		Optional<Editora> editora = this.repo.findById(idEditora);
		if (!editora.isPresent())
			throw new EditoraNaoEncontradaException(idEditora);
		return editora.get();
	}

	// Busca editoras a partir de uma lista de IDs
	public List<Editora> buscarPelosIDs(ArrayList<Long> idsEditoras) {
		return this.repo.findAllById(idsEditoras);
	}

	// Busca todas as editoras cadastradas
	public List<Editora> buscarTodas() {
		return this.repo.findAll();
	}
	
	// Busca uma editora pelo nome
	public Editora buscarPeloNome(String nome) {
		return this.repo.findByNome(nome).get();
	}
	
	// Busca uma editora cujo nome contenha uma string dada
	public List<Editora> buscarPeloNomeContendo(String nome) {
		return this.repo.findByNomeContaining(nome);
	}

	// Remove uma editora
	public void remover(Editora editora) {
		this.repo.delete(editora);
	}
	
	// Remove uma editora pelo seu ID
	public void remover(Long idEditora) {
		this.repo.deleteById(idEditora);
	}

	// Buscar uma editora pela cidade
	public List<Editora> buscarPelaCidade(String cidade) {
		return this.repo.findByCidade(cidade);
	}

	// Buscar editoras iniciando por uma string dada ou outra
	public List<Editora> buscarIniciandoPor(String a, String b) {
		return this.repo.findByNomeStartingWithOrNomeStartingWith(a, b);
	}

	// Busca as editoras com sede em alguma das duas cidades informadas
	public List<Editora> buscarPorCidades(String cidade1, String cidade2) {
		return this.repo.findByCidadeEqualsOrCidadeEquals(cidade1, cidade2);
	}
}
