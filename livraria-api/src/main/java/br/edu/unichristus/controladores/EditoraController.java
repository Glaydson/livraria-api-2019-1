package br.edu.unichristus.controladores;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.unichristus.entidades.Editora;
import br.edu.unichristus.entidades.Livro;
import br.edu.unichristus.servicos.EditoraService;

@RestController
@RequestMapping("/editoras")
public class EditoraController {
	
	@Autowired
	private EditoraService servicoEditoras;
	
	@PostMapping("/novo")
	public ResponseEntity<Object> salvar(@Valid @RequestBody Editora editora) {
		Editora editoraSalva = servicoEditoras.salvar(editora);
		URI local = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(editoraSalva.getEditoraID()).toUri();
		return ResponseEntity.created(local).build();
	}

}
