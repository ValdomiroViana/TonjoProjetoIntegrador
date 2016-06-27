package br.edu.ifpr.projeto.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.omnifaces.util.Messages;

import br.edu.ifpr.projeto.dao.CidadeDAO;
import br.edu.ifpr.projeto.domain.Cidade;
import br.edu.ifpr.projeto.domain.Estado;

@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Cidade cidade;
	private List<Cidade> cidades;
	private Estado estadoPai;
	
	public CidadeBean() {
		cidade = new Cidade();
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public List<Cidade> getCidades() {
		return cidades;
	}
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	public Estado getEstadoPai() {
		return estadoPai;
	}

	public void setEstadoPai(Estado estadoPai) {
		this.estadoPai = estadoPai;
	}
	

	@PostConstruct
	public void iniciar() {
		try {
			// Cria um objeto para armazenar os dados da tela
			Cidade cidade = new Cidade();

			// Cria um objeto para ter acesso as operaÃ§Ãµes de banco de dados
			CidadeDAO cidadeDAO = new CidadeDAO();

			// Recupera os registros do banco de dados e armazena o resultado em uma lista
			cidades = cidadeDAO.lista();

		} catch (RuntimeException runtimeException) {
			// Exibe uma mensagem de erro
			Messages.addGlobalError(runtimeException.getMessage());
		}
	}
	
	@PostConstruct
	public void listarCidadesBean() {
		try {
			Long codigoCidade = 1L;
			// Cria um objeto para armazenar os dados da tela
			Cidade cidade = new Cidade();

			// Cria um objeto para ter acesso as operaÃ§Ãµes de banco de dados
			CidadeDAO cidadeDAO = new CidadeDAO();

			// Recupera os registros do banco de dados e armazena o resultado em uma lista
			cidades = cidadeDAO.listarCidades(codigoCidade);

		} catch (RuntimeException runtimeException) {
			// Exibe uma mensagem de erro
			Messages.addGlobalError(runtimeException.getMessage());
		}
	}
	
}
