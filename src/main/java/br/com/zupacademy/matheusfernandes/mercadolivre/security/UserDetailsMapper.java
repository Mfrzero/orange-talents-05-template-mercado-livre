package br.com.zupacademy.matheusfernandes.mercadolivre.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsMapper {

	UserDetails map(Object shoudBeASystemUser);
}
