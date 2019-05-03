package br.edu.unichristus.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "TB_LIVROS")
@Data
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LIVRO_ID")
	private Long livroID;

	@Column(name = "TITULO")
	@NotNull
	@Size(min = 2, message = "O título precisa ter pelo menos 2 caracteres")
	@Size(max = 500, message = "O título só pode ter no máximo 500 caracteres")
	private String titulo;
	
	@Column(name = "DATA_PUBLICACAO")
	@NotNull
	@PastOrPresent(message = "A data de publicação não pode ser posterior à data atual")
	private LocalDate dataPublicacao;

	@Column(name = "NUMERO_PAGINAS")
	@NotNull
	@Min(value=50, message="O livro deve ter pelo menos 50 páginas")
	private int numeroPaginas;

	@Column(name = "PRECO")
	@NotNull
	@Positive(message = "O preço do livro deve ser maior que zero")
	private BigDecimal preco;
	
	@ManyToMany(mappedBy = "livros", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("livros")
	private List<Autor> autores;
	
	@ManyToOne
	@JoinColumn(name="EDITORA_ID")
	@JsonIgnoreProperties("livros")
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
