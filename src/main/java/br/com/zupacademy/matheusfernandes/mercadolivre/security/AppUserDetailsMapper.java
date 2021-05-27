package br.com.zupacademy.matheusfernandes.mercadolivre.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.zupacademy.matheusfernandes.mercadolivre.usuario.Usuario;

@Configuration
public class AppUserDetailsMapper implements UserDetailsMapper{

	@Override
	public UserDetails map(Object shoudBeASystemUser) {
		return new UsuarioLogado((Usuario)shoudBeASystemUser);
	}

}
