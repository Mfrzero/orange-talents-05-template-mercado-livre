
package br.com.zupacademy.matheusfernandes.mercadolivre.categoria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class CategoriaController {

	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	private ProibeNomeDuplicado proibeNomeDuplicado;
	@PersistenceContext
	private EntityManager manager;
	
	@InitBinder 
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeNomeDuplicado);
	}	
	
	@GetMapping(value = "/listaCategoria")
	public List<Categoria> lista(){
		Iterable<Categoria> categoria = categoriaRepository.findAll();
		return (List<Categoria>) categoria;
	}
	
//	@PostMapping("/cadastroCategoria")
//	@Transactional
//	public ResponseEntity<CategoriaForm> criaCategoria(@RequestBody @Valid CategoriaForm form){
//		if (!form.getNome().isBlank()) {
//			Categoria categoria = form.converter(manager);
//			manager.persist(categoria);
//			return ResponseEntity.ok(form);
//		}
//		return ResponseEntity.badRequest().build();
//	}
	@PostMapping("/api/cadastraCategoria")
	@Transactional
	public String criaCategoria(@RequestBody @Valid CategoriaForm form){
			Categoria categoria = form.converter(manager);
			manager.persist(categoria);
			return categoria.toString();
	}
	
}
