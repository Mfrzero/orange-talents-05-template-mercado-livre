package br.com.zupacademy.matheusfernandes.mercadolivre.pergunta;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.matheusfernandes.mercadolivre.produto.Produto;
import br.com.zupacademy.matheusfernandes.mercadolivre.usuario.Usuario;

public class PerguntaForm {

	@NotBlank
	private String titulo;
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Pergunta converter(@NotNull @Valid Usuario usuario, @NotNull @Valid Produto produto) {
		return new Pergunta(titulo, usuario, produto);
	}
	
}
