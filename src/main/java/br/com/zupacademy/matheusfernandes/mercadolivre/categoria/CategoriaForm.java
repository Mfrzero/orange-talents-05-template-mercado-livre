package br.com.zupacademy.matheusfernandes.mercadolivre.categoria;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import br.com.zupacademy.matheusfernandes.mercadolivre.UniqueValue;

public class CategoriaForm {

	@NotBlank @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;
	@Positive 
	private Long idCategoriaMae;

	public String getNome() {
		return nome;
	}
	
	public Long getIdCategoriaMae() {
		return idCategoriaMae;
	}


	public Categoria converter(EntityManager manager) {
		Categoria categoria = new Categoria(nome);
		if (idCategoriaMae != null) {
			Categoria categoriaMae = manager.find(Categoria.class, idCategoriaMae);
			categoria.setMae(categoriaMae);
		}
		return categoria;
	}
}
