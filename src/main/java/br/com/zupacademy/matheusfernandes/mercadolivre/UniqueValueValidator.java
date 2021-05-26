package br.com.zupacademy.matheusfernandes.mercadolivre;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.matheusfernandes.mercadolivre.usuario.UsuarioRepository;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, String> {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Optional<?> instance;
		if (value.contains("@")) {
			instance = usuarioRepository.findByLogin(value);
		} 
		instance = usuarioRepository.findByLogin(value);
		if (instance.isEmpty()) {
			return true;
		}
		return false;
	}

}
