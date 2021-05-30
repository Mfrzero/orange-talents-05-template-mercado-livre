package br.com.zupacademy.matheusfernandes.mercadolivre.pergunta;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.matheusfernandes.mercadolivre.produto.Produto;
import br.com.zupacademy.matheusfernandes.mercadolivre.usuario.Usuario;
import br.com.zupacademy.matheusfernandes.mercadolivre.usuario.UsuarioRepository;

@RestController
public class PerguntaController {

	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private Emails emails;	

	@Transactional
	@PostMapping("api/auth/produto/{id}/pergunta")
	public ResponseEntity<PerguntaForm> criar(@PathVariable("id") Long id, @RequestBody @Valid PerguntaForm form){
		Usuario usuario = usuarioRepository.findByEmail("matheus1@zup.com").get();
		Produto produto = manager.find(Produto.class, id);
		Pergunta pergunta = form.converter(usuario, produto);
		manager.persist(pergunta);
		emails.novaPergunta(pergunta);
		return ResponseEntity.ok().build();
	}
	
	
	
}
