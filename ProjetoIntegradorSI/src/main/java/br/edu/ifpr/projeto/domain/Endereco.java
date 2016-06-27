package br.edu.ifpr.projeto.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Endereco {

	@Column(length = 100, nullable = false)
	private String logradouro;
	@Column(length = 6, nullable = false)
	private Short numero;
	@Column(length = 60, nullable = false)
	private String bairro;
	@Column(length = 60, nullable = false)
	private String complemento;
	@ManyToOne
	@JoinColumn(name = "cidade_id", foreignKey = @ForeignKey(name = "fk_CidadeEndereco"))
	private Cidade cidade;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Short getNumero() {
		return numero;
	}

	public void setNumero(Short numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}
