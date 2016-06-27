package br.edu.ifpr.projeto.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_Mensalidade")
public class Mensalidade extends GenericDomain {

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataPagamento;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataVencimento;
	@Column(nullable = false, precision = 10, scale = 2)
	private float valor;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Situacao situacao;
	@ManyToOne
	@JoinColumn(name = "associado_id", nullable = false, foreignKey = @ForeignKey(name = "fk_AssociadoMensalidade"))
	private Associado associado;

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}

}
