package br.edu.ifpr.projeto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_Usuario")
public class Usuario extends GenericDomain {

	private static final long serialVersionUID = 1L;

	@Column(length = 20, nullable = false)
	private String login;
	@Column(length = 20, nullable = false)
	private String senha;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
