package br.edu.unichristus.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TB_EDITORAS")
@Data
public class Editora {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EDITORA_ID")
	private Long editoraID;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "CIDADE")
	private String cidade;

	@Column(name = "ANO_FUNDACAO")
	private int anoFundacao;

	@OneToMany(mappedBy = "editora", fetch = FetchType.EAGER)
	private List<Livro> livros;
	
	// CONSTRUTOR, GETTERS E SETTERS, MÉTODO toString

	// Construtor explícito
	public Editora(String nome, String cidade, int anoFundacao) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.anoFundacao = anoFundacao;
	}

	// Construtor implícito é requerido pelo Spring quando existe um explícito
	public Editora() {
	}

	@Override
	public String toString() {
		return "Editora [editoraID=" + editoraID + ", nome=" + nome + ", cidade=" + cidade + ", anoFundacao="
				+ anoFundacao + "]";
	}

}
