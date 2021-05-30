package br.com.zupacademy.matheusfernandes.mercadolivre.pergunta;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.matheusfernandes.mercadolivre.produto.Produto;
import br.com.zupacademy.matheusfernandes.mercadolivre.usuario.Usuario;

@Entity
public class Pergunta {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String titulo;
	@ManyToOne @NotNull @Valid
	private Usuario usuario;
	@ManyToOne @NotNull @Valid
	private Produto produto;
	
	@Deprecated
	public Pergunta() {
	}

	public Pergunta(@NotBlank String titulo, @NotNull @Valid Usuario usuario, @NotNull @Valid Produto produto) {
		this.titulo = titulo;
		this.usuario = usuario;
		this.produto = produto;
	}
	

	public String getTitulo() {
		return titulo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Usuario getDonoProduto() {
		return produto.getDono();
	}
	
}
