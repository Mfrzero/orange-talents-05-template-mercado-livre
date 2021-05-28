package br.com.zupacademy.matheusfernandes.mercadolivre.produto;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zupacademy.matheusfernandes.mercadolivre.usuario.Usuario;
import br.com.zupacademy.matheusfernandes.mercadolivre.usuario.UsuarioRepository;

@RestController
public class ImagemController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private UploaderFake uploaderFake;
	
	@Transactional
	@PostMapping("api/auth/produtos/{id}/imagens")
	public ResponseEntity<ImagemForm> insereImagem(@PathVariable("id") Long id,@Valid ImagemForm form) {
		Usuario dono = usuarioRepository.findByEmail("matheus@zup.com").get();
		Produto produto = manager.find(Produto.class, id);
		Set<String> links = uploaderFake.enviar(form.getImagem());
		produto.associaImagens(links);
		manager.merge(produto);
		if (!produto.pertenceAoUsuario(dono)) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
		}
		return ResponseEntity.ok().build();
	}
}
