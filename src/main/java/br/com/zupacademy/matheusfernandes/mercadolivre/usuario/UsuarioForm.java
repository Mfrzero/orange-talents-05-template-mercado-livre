package br.com.zupacademy.matheusfernandes.mercadolivre.usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsuarioForm {

	@NotBlank @Email 
	private String login;
	@NotBlank @Size(min = 6)
	private String senha;
	@NotNull
	private LocalDateTime instante = LocalDateTime.now();
	
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		return senha;
	}
	public LocalDateTime getInstante() {
		return instante;
	}
	
	public Usuario converter(EntityManager manager) {
		Usuario usuario = new Usuario(login, senha, instante);
		return usuario;
	}
}