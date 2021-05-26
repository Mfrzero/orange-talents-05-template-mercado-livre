package br.com.zupacademy.matheusfernandes.mercadolivre.categoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@ManyToOne
	private Categoria categoria;
	
	@Deprecated
	public Categoria() {
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Categoria(@NotBlank String nome) {
		this.nome = nome;
	}

}
