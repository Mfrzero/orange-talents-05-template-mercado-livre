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
			instance = usuarioRepository.findByEmail(value);
		} 
		instance = usuarioRepository.findByEmail(value);
		if (instance.isEmpty()) {
			return true;
		}
		return false;
	}

}
