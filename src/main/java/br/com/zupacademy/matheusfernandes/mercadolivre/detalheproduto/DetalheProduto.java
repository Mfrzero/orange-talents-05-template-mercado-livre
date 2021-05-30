package br.com.zupacademy.matheusfernandes.mercadolivre.detalheproduto;

import java.math.BigDecimal;
import java.util.Set;

import br.com.zupacademy.matheusfernandes.mercadolivre.opiniao.Opiniao;
import br.com.zupacademy.matheusfernandes.mercadolivre.produto.CaracteristicaProduto;
import br.com.zupacademy.matheusfernandes.mercadolivre.produto.Opinioes;
import br.com.zupacademy.matheusfernandes.mercadolivre.produto.Produto;

public class DetalheProduto {

	private String descricao;
	private String nome;
	private BigDecimal preco;
	private Set<CaracteristicaProduto> caracteristicas;
	private Set<String> imagens;
	private Set<String> pergunta;
	private Set<Opiniao> opiniao;
	private double mediaNotas;
	private int total;

	public DetalheProduto(Produto produto) {

		this.descricao = produto.getDescricao();
		this.nome = produto.getNome();
		this.preco = produto.getValor();
		this.caracteristicas = produto.getCaracteristicas();
		this.imagens = produto.mapImagens(imagem -> imagem.getLink());
		this.pergunta = produto.mapPerguntas(pergunta -> pergunta.getTitulo());
		this.opiniao = produto.getOpiniao();
		Opinioes opinioes = produto.getOpinioes();
		this.mediaNotas = opinioes.media();
		this.total = opinioes.total();
	}
	
	public String getDescricao() {
		return descricao;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Set<CaracteristicaProduto> getCaracteristicas() {
		return caracteristicas;
	}

	public Set<String> getImagens() {
		return imagens;
	}

	public Set<String> getPergunta() {
		return pergunta;
	}

	public Set<Opiniao> getOpiniao() {
		return opiniao;
	}

	public double getMediaNotas() {
		return mediaNotas;
	}

	public int getTotal() {
		return total;
	}
	
}
