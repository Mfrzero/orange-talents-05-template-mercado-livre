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
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
