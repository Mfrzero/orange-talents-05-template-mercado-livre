package br.com.zupacademy.matheusfernandes.mercadolivre.usuario;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsuarioForm {

	@NotBlank @Email
	private String email;
	@NotBlank @Size(min = 6)
	private String senha;
	@NotNull
	private LocalDateTime instante = LocalDateTime.now();
	
	public String getEmail() {
		return this.email;
	}
	public String getSenha() {
		return senha;
	}
	public LocalDateTime getInstante() {
		return instante;
	}
	
	public Usuario converter(EntityManager manager) {
		Usuario usuario = new Usuario(email, new SenhaLimpa(senha), instante);
		return usuario;
	}
	@Override
	public String toString() {
		return "UsuarioForm [email=" + email + ", senha=" + senha + ", instante=" + instante + "]";
	}
	
	
}
