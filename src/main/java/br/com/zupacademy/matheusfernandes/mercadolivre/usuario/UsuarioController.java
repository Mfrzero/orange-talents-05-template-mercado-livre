package br.com.zupacademy.matheusfernandes.mercadolivre.usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
	
	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping(value = "/listaUsuarios")
	public List<Usuario> lista(){
		Iterable<Usuario> usuario = usuarioRepository.findAll();
		
		return (List<Usuario>) usuario;
		
	}

	@PostMapping("/cadastraUsuario")
	@Transactional
	public ResponseEntity<UsuarioForm> criar(@RequestBody @Valid UsuarioForm form){
		if(form.getLogin().isBlank() || form.getSenha().isBlank()) {
			return ResponseEntity.badRequest().build();
		}
		Usuario usuario = form.converter(manager);
		manager.persist(usuario);
		return ResponseEntity.ok().build();
		
	}
}
