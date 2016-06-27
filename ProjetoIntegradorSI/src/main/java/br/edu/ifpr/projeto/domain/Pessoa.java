package br.edu.ifpr.projeto.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "tb_Pessoa")
public class Pessoa extends GenericDomain {

	private static final long serialVersionUID = 1L;

	@Column(length = 50, nullable = false)
	private String nome;
	@Temporal(TemporalType.DATE)
	@Column
	private Date dataNascimento;
	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private Sexo sexo;
	@OneToOne(mappedBy = "pessoa")
	private Associado associado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}
}
