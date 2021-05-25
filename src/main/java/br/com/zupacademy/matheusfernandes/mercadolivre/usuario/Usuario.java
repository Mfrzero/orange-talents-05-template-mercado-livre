package br.com.zupacademy.matheusfernandes.mercadolivre.usuario;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.zupacademy.matheusfernandes.mercadolivre.UniqueValue;

@Entity
public class Usuario {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank @Email @UniqueValue(domainClass = Usuario.class, fieldName = "login")
	private String login;
	@NotBlank @Size(min = 6)
	private String senha;
	@NotNull
	private LocalDateTime instante = LocalDateTime.now();
	
	public Usuario() {
	}

	public Usuario(@NotBlank @Email String login, @NotBlank @Size(min = 6) String senha, @NotNull LocalDateTime instante) {
		this.login = login;
		this.senha = new BCryptPasswordEncoder().encode(senha);
		this.instante = instante;
	}
	
	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public LocalDateTime getInstante() {
		return instante;
	}
	
	
	
	
}
