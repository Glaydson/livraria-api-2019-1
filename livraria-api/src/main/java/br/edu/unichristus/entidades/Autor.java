package br.edu.unichristus.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_AUTORES")
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AUTOR_ID")
	private Long autorID;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "PAIS")
	private String pais;

	// Livro é o proprietário da relação many to many
	@ManyToMany(mappedBy = "autores", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("autores")
	private List<Livro> livros;

	// Construtor implícito é requerido pelo Spring quando existe um explícito
	public Autor() {}
	
	// Construtor explícito
	public Autor(String nome, String pais, List<Livro> livros) {
		super();
		this.nome = nome;
		this.pais = pais;
		this.livros = livros;
	}
	
	@Override
	public String toString() {
		return "Autor [autorID=" + autorID + ", nome=" + nome + ", pais=" + pais + "]";
	}



	

}
