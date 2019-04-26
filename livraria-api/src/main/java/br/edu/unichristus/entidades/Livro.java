package br.edu.unichristus.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TB_LIVROS")
@Data
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LIVRO_ID")
	private Long livroID;

	@Column(name = "TITULO", nullable = false)
	private String titulo;

	@Column(name = "DATA_PUBLICACAO")
	private LocalDate dataPublicacao;

	@Column(name = "NUMERO_PAGINAS")
	private int numeroPaginas;

	@Column(name = "PRECO")
	private BigDecimal preco;
	
	@ManyToMany(mappedBy = "livros")
	private List<Autor> autores;
	
	@ManyToOne
	@JoinColumn(name="EDITORA_ID")
	private Editora editora;

	// Construtor implícito é requerido pelo Spring quando existe um explícito
	public Livro() {
	}

	// Construtor explícito
	public Livro(String titulo, LocalDate dataPublicacao, int numeroPaginas, BigDecimal preco, Editora e) {
		super();
		this.titulo = titulo;
		this.dataPublicacao = dataPublicacao;
		this.numeroPaginas = numeroPaginas;
		this.preco = preco;
		this.editora = e;
	}

	@Override
	public String toString() {
		return "Livro [livroID=" + livroID + ", titulo=" + titulo + ", dataPublicacao=" + dataPublicacao
				+ ", numeroPaginas=" + numeroPaginas + ", preco=" + preco + "]";
	}
	
	
	
	
}
