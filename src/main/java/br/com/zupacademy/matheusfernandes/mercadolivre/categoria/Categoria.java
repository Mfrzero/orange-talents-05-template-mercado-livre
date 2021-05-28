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
	private Categoria categoriaMae;
	
	@Deprecated
	public Categoria() {
	}
	

	public Categoria(@NotBlank String nome) {
		this.nome = nome;
	}
	
	public void setMae(Categoria categoriaMae) {
		this.categoriaMae = categoriaMae;
	}

	//apagar dps apenas teste para listar
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Categoria getCategoriaMae() {
		return categoriaMae;
	}


	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + ", categoriaMae=" + categoriaMae + "]";
	}
	
	
	

}
