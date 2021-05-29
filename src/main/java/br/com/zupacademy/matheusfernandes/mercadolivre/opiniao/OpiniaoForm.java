package br.com.zupacademy.matheusfernandes.mercadolivre.opiniao;

import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.zupacademy.matheusfernandes.mercadolivre.produto.Produto;
import br.com.zupacademy.matheusfernandes.mercadolivre.usuario.Usuario;

public class OpiniaoForm {

	@Max(5) @Positive
	private Integer nota;
	@Enumerated @NotNull
	private Titulo titulo;
	@NotBlank @Size(max = 500)	
	private String descricao;
	

	public OpiniaoForm(@Max(5) @Positive Integer nota,@NotNull Titulo titulo, @NotBlank @Size(max = 500) String descricao) {
		this.nota = nota;
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public Opiniao converter(Usuario consumidor, Produto produto) {
		return new Opiniao(nota, titulo, descricao, produto, consumidor);
	}

	@Override
	public String toString() {
		return "OpiniaoForm [nota=" + nota + ", titulo=" + titulo + ", descricao=" + descricao + "]";
	}
	
	
}
