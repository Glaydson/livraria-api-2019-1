package br.edu.unichristus.controladores;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.unichristus.entidades.Autor;
import br.edu.unichristus.servicos.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorService servicoAutores;
	
	@GetMapping("/todos")
	public List<Autor> getAutores() {
		return this.servicoAutores.buscarTodos();
	}
	
	@GetMapping("/{id}")
	public Autor buscarPeloID(@PathVariable Long id) {
		return servicoAutores.buscarPeloID(id);
	}
	
	@PostMapping("/novo")
	public ResponseEntity<Object> salvar(@RequestBody Autor autor) {
		Autor autorSalvo = servicoAutores.salvar(autor);
		URI local = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(autorSalvo.getAutorID()).toUri();
		return ResponseEntity.created(local).build();
	}

}
