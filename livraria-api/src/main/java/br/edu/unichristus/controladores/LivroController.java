package br.edu.unichristus.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unichristus.entidades.Livro;
import br.edu.unichristus.servicos.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivroService servicoLivros;
	
	@GetMapping("/todos")
	public List<Livro> getLivros() {
		return this.servicoLivros.buscarTodos();
	}

}
