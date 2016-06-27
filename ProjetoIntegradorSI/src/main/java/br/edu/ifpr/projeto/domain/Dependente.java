package br.edu.ifpr.projeto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_Dependente")
public class Dependente extends GenericDomain {

	private static final long serialVersionUID = 1L;

	@Column(length = 15, nullable = false)
	private String parentesco;
	@OneToOne
	@JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(name="fk_PessoaDependente"))
	private Pessoa pessoa;
	@ManyToOne
	@JoinColumn(name = "associado_id", nullable = false, foreignKey = @ForeignKey(name="fk_AssociadoDependente"))
	private Associado associado;

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}
}
