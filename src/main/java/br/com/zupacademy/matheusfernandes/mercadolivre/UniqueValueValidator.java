package br.com.zupacademy.matheusfernandes.mercadolivre;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.matheusfernandes.mercadolivre.usuario.Usuario;
import br.com.zupacademy.matheusfernandes.mercadolivre.usuario.UsuarioRepository;


public class UniqueValueValidator implements ConstraintValidator<UniqueValue, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if(value.contains("@")) {
			System.out.println("Tem email ai");
			return true;
		}
		System.out.println("Saindooo");
		return false;
	}



}
