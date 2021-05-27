package br.com.zupacademy.matheusfernandes.mercadolivre.usuario;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeLoginDuplicadoValidator implements Validator{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return UsuarioForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if (errors.hasErrors()) {
			return;
		}
		
		UsuarioForm form = (UsuarioForm) target;
		Optional<Usuario> possivelLogin = usuarioRepository.findByEmail(form.getEmail());
		
		if (possivelLogin.isPresent()) {
			errors.rejectValue("Email", null, "Já existe um login com o mesmo email "+ form.getEmail());
		}
	}

	
}
