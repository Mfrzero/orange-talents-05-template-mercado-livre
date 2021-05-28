package br.com.zupacademy.matheusfernandes.mercadolivre.produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.matheusfernandes.mercadolivre.ExistsId;
import br.com.zupacademy.matheusfernandes.mercadolivre.categoria.Categoria;
import br.com.zupacademy.matheusfernandes.mercadolivre.usuario.Usuario;

public class ProdutoForm {

	@NotBlank
	private String nome;
	@NotNull
	@Positive
	private BigDecimal valor;
	@Positive
	private Integer quantidade;
	@NotBlank
	@Size(max = 1000)
	private String descricao;
	@Size(min = 3)
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
	private List<CaracteristicaForm> caracteristica = new ArrayList<>();
	@NotNull
	@ExistsId(domainClass = Categoria.class, fieldName = "id")
	private Long idCategoria;

	public ProdutoForm(@NotBlank String nome, @Positive int quantidade,
			@NotBlank @Length(max = 1000) String descricao,
			@NotNull @Positive BigDecimal valor, @NotNull Long idCategoria,
			List<CaracteristicaForm> caracteristica) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.valor = valor;
		this.idCategoria = idCategoria;
		this.caracteristica.addAll(caracteristica);		
	}
	
	public List<CaracteristicaForm> getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(List<CaracteristicaForm> caracteristica) {
		this.caracteristica = caracteristica;
	}

	public Produto converter(EntityManager manager, Usuario dono) {
		Categoria categoria = manager.find(Categoria.class, idCategoria);
		return new Produto(nome, quantidade, descricao, valor, categoria, dono,
				caracteristica);
	}

	public Set<String> buscaCaracteristicasIguais() {
		HashSet<String> nomesIguais = new HashSet<>();
		HashSet<String> resultados = new HashSet<>();
		for (CaracteristicaForm caracteristica : caracteristica) {
			String nome = caracteristica.getNome();
			if (!nomesIguais.add(nome)) {
				resultados.add(nome);
			}
		}
		return resultados;
	}
	
	@Override
	public String toString() {
		return "ProdutoForm [nome=" + nome + ", valor=" + valor + ", quantidade=" + quantidade + ", descricao="
				+ descricao + ", idCategoria=" + idCategoria + "]";
	}
	
}
