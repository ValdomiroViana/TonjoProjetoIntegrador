package br.edu.ifpr.projeto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_Estado")
public class Estado extends GenericDomain {

	private static final long serialVersionUID = 1L;

	@Column(length = 50, nullable = false)
	private String nome;
	@Column(length = 2, nullable = false)
	private String sigla;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}
