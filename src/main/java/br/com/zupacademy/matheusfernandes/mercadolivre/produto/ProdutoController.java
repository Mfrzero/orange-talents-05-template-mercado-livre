package br.com.zupacademy.matheusfernandes.mercadolivre.produto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.matheusfernandes.mercadolivre.categoria.ProibeNomeDuplicado;
import br.com.zupacademy.matheusfernandes.mercadolivre.usuario.Usuario;
import br.com.zupacademy.matheusfernandes.mercadolivre.usuario.UsuarioRepository;

@RestController
public class ProdutoController {

	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ProibeCaracteristicasIguais proibeCaracteristicasIguais;
	
	@InitBinder 
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeCaracteristicasIguais);
	}	
	
	
	@Transactional
	@PostMapping("/api/auth/produto")
	public ResponseEntity<ProdutoForm> criar(@RequestBody @Valid ProdutoForm form){
		Usuario dono = usuarioRepository.findByEmail("matheus@zup.com").get();
		Produto produto = form.converter(manager, dono);
		manager.persist(produto);
		return ResponseEntity.ok().build();
	}
}
