package br.edu.unichristus.controladores;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.unichristus.entidades.Editora;
import br.edu.unichristus.excecoes.EditoraNaoEncontradaException;
import br.edu.unichristus.servicos.EditoraService;

@CrossOrigin(origins="http://localhost:8080")
@RestController
@RequestMapping("/editoras")
public class EditoraController {
	
	@Autowired
	private EditoraService servicoEditoras;
	
	@GetMapping("/todos")
	public List<Editora> buscarTodos() {
		return servicoEditoras.buscarTodas();
	}

	// Com @PathVariable o id da editora vem na própria URI da requisição
	@GetMapping("/{id}")
	public Editora buscarPeloID(@PathVariable Long id) {
		return servicoEditoras.buscarPeloID(id);
	}
	
	// Com @Param o nome da editora é lida da lista de parâmetros da requisição
	@GetMapping("/buscar{nome}")
	public List<Editora> buscarPeloNome(@Param ("nome") String nome) {
		return servicoEditoras.buscarPeloNomeContendo(nome);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEditora(@PathVariable("id") Long id) {
		servicoEditoras.remover(id);
		return new ResponseEntity<>("Editora foi removida!", HttpStatus.OK);
	}
	
	@PutMapping("/atualiza/{id}")
	public ResponseEntity<Object> atualizaEditora(@RequestBody Editora editora, @PathVariable long id) {
		try {
			Editora editoraBD = servicoEditoras.buscarPeloID(id);
		} catch (EditoraNaoEncontradaException enee) {
			return ResponseEntity.notFound().build();
		}
		editora.setEditoraID(id);
		servicoEditoras.salvar(editora);
		return ResponseEntity.noContent().build();
	}

	
	@PostMapping("/novo")
	public ResponseEntity<Object> salvar(@Valid @RequestBody Editora editora) {
		Editora editoraSalva = servicoEditoras.salvar(editora);
		URI local = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(editoraSalva.getEditoraID()).toUri();
		return ResponseEntity.created(local).build();
	}

}
