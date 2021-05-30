package br.com.zupacademy.matheusfernandes.mercadolivre.produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.matheusfernandes.mercadolivre.categoria.Categoria;
import br.com.zupacademy.matheusfernandes.mercadolivre.opiniao.Opiniao;
import br.com.zupacademy.matheusfernandes.mercadolivre.pergunta.Pergunta;
import br.com.zupacademy.matheusfernandes.mercadolivre.usuario.Usuario;
import io.jsonwebtoken.lang.Assert;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private @NotBlank String nome;
	private @NotNull @Positive BigDecimal valor;
	private @Positive Integer quantidade;
	private @NotBlank @Size(max = 1000) String descricao;
	private LocalDateTime instante = LocalDateTime.now();
	private @ManyToOne @NotNull @Valid Categoria categoria;
	private @ManyToOne @NotNull @Valid Usuario dono;
	@OneToMany(mappedBy = "produto", cascade = CascadeType.PERSIST)
	private Set<CaracteristicaProduto> caracteristicas = new HashSet<>();
	@OneToMany(mappedBy = "produto", cascade = CascadeType.MERGE)
	private Set<ImagemProduto> imagens = new HashSet<>();
	@OneToMany(mappedBy = "produto")
	private Set<Pergunta> pergunta = new HashSet<>();
	@OneToMany(mappedBy = "produto", cascade = CascadeType.MERGE)
	private Set<Opiniao> opiniao = new HashSet<>();
	
	@Deprecated
	public Produto() {
	}

	public Produto(@NotBlank String nome, @Positive int quantidade, @NotBlank @Length(max = 1000) String descricao,
			@NotNull @Positive BigDecimal valor, @NotNull @Valid Categoria categoria, @NotNull @Valid Usuario dono,
			@Size(min = 3) @Valid Collection<CaracteristicaForm> caracteristicas) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.valor = valor;
		this.categoria = categoria;
		this.dono = dono;
		this.caracteristicas.addAll(caracteristicas.stream().map(caracteristica -> caracteristica.toModel(this))
				.collect(Collectors.toSet()));
		Assert.isTrue(this.caracteristicas.size() >= 3, "Todo produto precisa ter no mínimo 3 ou mais características");

	}

	public void associaImagens(Set<String> links) {
		Set<ImagemProduto> imagens = links.stream().map(link -> new ImagemProduto(this, link))
				.collect(Collectors.toSet());
		this.imagens.addAll(imagens);
	}

	@Override
	public String toString() {
		return "Produto [Id=" + Id + ", nome=" + nome + ", valor=" + valor + ", quantidade=" + quantidade
				+ ", descricao=" + descricao + ", instante=" + instante + ", categoria=" + categoria + ", dono=" + dono
				+ ", caracteristicas=" + caracteristicas + ", imagens=" + imagens + "]";
	}

	public boolean pertenceAoUsuario(Usuario possivelDono) {
		return this.dono.equals(possivelDono);
	}

	public Usuario getDono() {
		return this.dono;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public Set<CaracteristicaProduto> getCaracteristicas() {
		return caracteristicas;
	}

	public <T> Set <T> mapImagens(Function<ImagemProduto, T> funcaoMapeadora) {
		return this.imagens.stream().map(funcaoMapeadora).collect(Collectors.toSet());
	}
	public <T> Set <T> mapPerguntas(Function<Pergunta, T> funcaoMapeadora) {
		return this.pergunta.stream().map(funcaoMapeadora).collect(Collectors.toSet());
	}

	public Set<Opiniao> getOpiniao() {
		return opiniao;
	}

	public Opinioes getOpinioes() {
		return new Opinioes(this.opiniao);
	}

}

























