package br.com.zupacademy.matheusfernandes.mercadolivre.produto;

import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import br.com.zupacademy.matheusfernandes.mercadolivre.opiniao.Opiniao;

public class Opinioes {

	private Set<Opiniao> opinioes;

	public Opinioes(Set<Opiniao> opinioes) {
		this.opinioes = opinioes;
	}
	
	public <T> Set <T> mapOpinioes(Function<Opiniao, T> funcaoMapeadora) {
		return this.opinioes.stream().map(funcaoMapeadora).collect(Collectors.toSet());
	}
	
	public double media() {
		Set<Integer> notas = mapOpinioes(opiniao -> opiniao.getNota());
		OptionalDouble possivelMedia = notas.stream().mapToInt(nota -> nota).average();
		return possivelMedia.orElse(0.0);
	}
	
	public int total() {
		return this.opinioes.size();
	}
}




















