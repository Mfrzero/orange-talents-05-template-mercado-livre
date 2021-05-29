package br.com.zupacademy.matheusfernandes.mercadolivre.opiniao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.matheusfernandes.mercadolivre.produto.Produto;
import br.com.zupacademy.matheusfernandes.mercadolivre.usuario.Usuario;
import br.com.zupacademy.matheusfernandes.mercadolivre.usuario.UsuarioRepository;

@RestController
public class OpiniaoController {

	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	@PostMapping("api/auth/produtos/{id}/opiniao")
	public ResponseEntity<OpiniaoForm> criar(@PathVariable("id") Long id,@RequestBody @Valid OpiniaoForm form, 
			@AuthenticationPrincipal Usuario usuario) {
		Produto produto = manager.find(Produto.class, id);
		usuario = usuarioRepository.findByEmail("matheus@zup.com").get();
		Opiniao opiniao = form.converter(usuario, produto);
		manager.persist(opiniao);
		return ResponseEntity.ok().build();
	}
}
