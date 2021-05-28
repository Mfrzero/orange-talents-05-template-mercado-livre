package br.com.zupacademy.matheusfernandes.mercadolivre.produto;


import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeCaracteristicasIguais implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ProdutoForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return ;
		}
		
		ProdutoForm form = (ProdutoForm) target;
		Set<String> nomesIguais = form.buscaCaracteristicasIguais();
		if(!nomesIguais.isEmpty()) {
			errors.rejectValue("caracteristica", null, "você tem caracteristicas iguais "+nomesIguais);
		}
	}

}