package br.com.zupacademy.matheusfernandes.mercadolivre.opiniao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.zupacademy.matheusfernandes.mercadolivre.produto.Produto;
import br.com.zupacademy.matheusfernandes.mercadolivre.usuario.Usuario;

@Entity
public class Opiniao {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Max(5) @Positive
	private Integer nota;
	@NotNull
	private Titulo titulo;
	@NotBlank @Size(max = 500) 
	private String descricao;
	@ManyToOne @NotNull @Valid
	private Produto produto;
	@ManyToOne @NotNull @Valid
	private Usuario consumidor;
	

	public Opiniao(@Max(5) @Positive Integer nota, @NotNull Titulo titulo, @NotBlank @Size(max = 500) String descricao,
			@NotNull @Valid Produto produto, @NotNull @Valid Usuario consumidor) {
		this.nota = nota;
		this.titulo = titulo;
		this.descricao = descricao;
		this.produto = produto;
		this.consumidor = consumidor;
	}


	@Override
	public String toString() {
		return "Opiniao [nota=" + nota + ", titulo=" + titulo + ", descricao=" + descricao + ", produto=" + produto
				+ ", consumidor=" + consumidor + "]";
	}
	
	

	
}
