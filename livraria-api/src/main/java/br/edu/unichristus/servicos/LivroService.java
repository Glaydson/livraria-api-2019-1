package br.edu.unichristus.servicos;

import java.time.LocalDate;
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

	// Salva um livro
	public void salvar(Livro l) {
		this.repo.save(l);
	}

	// Busca um livro pelo ID
	public Livro buscarPeloID(long idLivro) {
		return this.repo.findById(idLivro).get();
	}

	// Busca livros por uma lista de IDs
	public List<Livro> buscarPelosIDs(ArrayList<Long> idsLivros) {
		return this.repo.findAllById(idsLivros);
	}

	// Busca todos os livros cadastrados
	public List<Livro> buscarTodos() {
		return this.repo.findAll();
	}

	// Remove um livro pelo ID
	public void remover(Long idLivro) {
		this.repo.deleteById(idLivro);
	}

	// Remove um livro dado
	public void remover(Livro livro) {
		this.repo.delete(livro);
	}

	// Busca um livro pelo título
	public Livro buscarPeloTitulo(String titulo) {
		return this.repo.findByTitulo(titulo);
	}

	// Busca livros pelo título usando uma máscara
	public List<Livro> buscarPeloTituloLike(String titulo) {
		return this.repo.findByTituloLike(titulo);
	}

	// Busca livros cujo título contenha uma string dada
	public List<Livro> buscarPeloTituloContendo(String titulo) {
		return this.repo.findByTituloContaining(titulo);
	}

	// Busca os livros cujo título comece com uma string dada
	public List<Livro> buscarPeloTituloComecandoCom(String titulo) {
		return this.repo.findByTituloStartingWith(titulo);
	}

	// Busca os livros cujo título termine com uma string dada
	public List<Livro> buscarPeloTituloTerminandoCom(String titulo) {
		return this.repo.findByTituloEndingWith(titulo);
	}

	// Busca livros pelo título, ignorando a capitalização
	public List<Livro> buscarPeloTituloIgnorandoCaixa(String titulo) {
		return this.repo.findByTituloIgnoreCase(titulo);
	}

	// Busca livros cujo número de páginas é exatamente igual ao valor informado
	public List<Livro> buscarPeloNumeroDePaginas(int numeroPaginas) {
		return this.repo.findByNumeroPaginasEquals(numeroPaginas);
	}

	// Busca livros cujo número de páginas é maior que o valor informado
	public List<Livro> buscarPeloNumeroDePaginasMaiorQue(int numeroPaginas) {
		return this.repo.findByNumeroPaginasGreaterThan(numeroPaginas);
	}

	// Busca livros cujo número de páginas está dentro do intervalo informado.
	public List<Livro> buscarPeloNumeroDePaginasIntervalo(int minimo, int maximo) {
		return this.repo.findByNumeroPaginasBetween(minimo, maximo);
	}

	// Busca os livros cujo título contenha um ou dois parâmetros informados
	public List<Livro> buscarPeloTituloContendo(String titulo1, String titulo2) {
		return this.repo.findByTituloContainingOrTituloContaining(titulo1, titulo2);
	}

	// Busca livros cujo título não seja o título informado.
	public List<Livro> buscarPeloTituloDiferenteDe(String titulo) {
		return this.repo.findByTituloNot(titulo);
	}

	// Busca um livro pelo título e número de páginas maior que o informado
	public List<Livro> buscarPeloTituloENumeroPaginas(String titulo, int numeroPaginas) {
		return this.repo.findByTituloContainingAndNumeroPaginasGreaterThan(titulo, numeroPaginas);
	}

	// Bsca livros publicados após uma determinada data
	public List<Livro> buscarPelaDataPublicacaoMaiorQue(LocalDate dataPublicacao) {
		return this.repo.findByDataPublicacaoAfter(dataPublicacao);
	}

	// Busca livro publicados antes de uma determinada data
	public List<Livro> buscarPelaDataPublicacaoMenorQue(LocalDate dataPublicacao) {
		return this.repo.findByDataPublicacaoBefore(dataPublicacao);
	}

	// Buscar livros publicados entre duas datas informadas
	public List<Livro> buscarPelaDataPublicacaoEntre(LocalDate data1, LocalDate data2) {
		return this.repo.findByDataPublicacaoBetween(data1, data2);
	}

}
