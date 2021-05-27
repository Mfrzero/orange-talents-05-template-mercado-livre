package br.com.zupacademy.matheusfernandes.mercadolivre.usuario;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Usuario 
{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank @Email 
	private String email;
	@NotBlank @Size(min = 6)
	private String senha;
	@NotNull
	private LocalDateTime instante = LocalDateTime.now();

	public Usuario() {
	}

	public Usuario(@NotBlank @Email String email, @Valid @NotBlank SenhaLimpa senhaLimpa, @NotNull LocalDateTime instante) {
		this.email = email;
		this.senha = senhaLimpa.hash();
		this.instante = instante;
	}
	
	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public LocalDateTime getInstante() {
		return instante;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", senha=" + senha + ", instante=" + instante + "]";
	}
	
	
}
