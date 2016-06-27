package br.edu.ifpr.projeto.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.Email;

@Embeddable
public class Contato {

	@Column(length = 20, nullable = false)
	private String telefoneResidencial;
	@Column(length = 20, nullable = false)
	private String telefoneComercial;
	@Column(length = 20, nullable = false)
	private String telefoneCelular;
	@Column(length = 30, nullable = false)
	private String email;

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
