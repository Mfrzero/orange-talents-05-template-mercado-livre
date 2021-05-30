package br.com.zupacademy.matheusfernandes.mercadolivre.security;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.zupacademy.matheusfernandes.mercadolivre.usuario.Usuario;

public class UsuarioLogado implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private User springUserDetails;
	
	public UsuarioLogado(@NotNull @Valid Usuario usuario) {
		this.usuario = usuario;
		springUserDetails = new User(usuario.getEmail(), usuario.getSenha(), List.of());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return springUserDetails.getAuthorities();
	}

	@Override
	public String getPassword() {
		return springUserDetails.getPassword();
	}

	@Override
	public String getUsername() {
		return springUserDetails.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
