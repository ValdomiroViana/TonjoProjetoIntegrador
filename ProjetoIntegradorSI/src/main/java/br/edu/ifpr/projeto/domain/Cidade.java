package br.edu.ifpr.projeto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_Cidade")
public class Cidade extends GenericDomain {

	private static final long serialVersionUID = 1L;

	@Column(length = 40, nullable = false)
	private String nome;
	// Inndica Cardinalidade Muitos para um
	@ManyToOne
	// Indica Chave estrangeira
	// ForeignKey > Nome para a Constraint
	@JoinColumn(name = "estado_id", nullable = false, foreignKey = @ForeignKey(name="fk_EstadoCidade"))
	private Estado estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
