package br.com.zupacademy.matheusfernandes.mercadolivre.detalheproduto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.matheusfernandes.mercadolivre.produto.Produto;

@RestController
public class DetalheProdutoController {

	@PersistenceContext
	private EntityManager manager;
	
	@GetMapping("api/auth/{id}/detalhesProduto")
	public DetalheProduto mostrar(@PathVariable("id") Long id) {
		Produto produto = manager.find(Produto.class, id);
		return new DetalheProduto(produto);
	}
}
