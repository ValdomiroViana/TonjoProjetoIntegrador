package br.edu.ifpr.projeto.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_Associado")
public class Associado extends GenericDomain {

	private static final long serialVersionUID = 1L;

	@Column(length = 12, nullable = false)
	private String rg;
	@Column(length = 14, nullable = false)
	private String cpf;
	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private Status status;
	@Column(columnDefinition = "text")
	private String observacao;
	@Column(length = 40)
	private String cidadeNaturalidade;
	@Column(length = 40)
	private String estadoNaturalidade;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(name = "fk_PessoaAssociado"))
	private Pessoa pessoa;
	@Embedded
	private Endereco endereco;
	@Embedded
	private Contato contato;
	@OneToMany(mappedBy = "associado")
	private List<Dependente> dependente;

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getCidadeNaturalidade() {
		return cidadeNaturalidade;
	}

	public void setCidadeNaturalidade(String cidadeNaturalidade) {
		this.cidadeNaturalidade = cidadeNaturalidade;
	}

	public String getEstadoNaturalidade() {
		return estadoNaturalidade;
	}

	public void setEstadoNaturalidade(String estadoNaturalidade) {
		this.estadoNaturalidade = estadoNaturalidade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Dependente> getDependente() {
		return dependente;
	}

	public void setDependente(List<Dependente> dependente) {
		this.dependente = dependente;
	}
}
