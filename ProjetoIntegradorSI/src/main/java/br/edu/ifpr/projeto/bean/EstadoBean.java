package br.edu.ifpr.projeto.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.omnifaces.util.Messages;

import br.edu.ifpr.projeto.dao.EstadoDAO;
import br.edu.ifpr.projeto.domain.Estado;

@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Estado estado;
	private List<Estado> estados;

	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	
	@PostConstruct
	public void iniciar() {
		try {
			// Cria um objeto para armazenar os dados da tela
			Estado estado = new Estado();

			// Cria um objeto para ter acesso as operaÃ§Ãµes de banco de dados
			EstadoDAO estadoDAO = new EstadoDAO();

			// Recupera os registros do banco de dados e armazena o resultado em uma lista
			estados = estadoDAO.lista();

		} catch (RuntimeException runtimeException) {
			// Exibe uma mensagem de erro
			Messages.addGlobalError(runtimeException.getMessage());
		}
	}
	
//	Metodo Novo
	public void novo() {
		estado = new Estado();
	}
	
//	Metodo Salvar
	public void salvar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.salvar(estado);
			novo();
			 Messages.addGlobalInfo("Estado salvo com sucesso");
		} catch (RuntimeException erro) {
			 Messages.addGlobalError("Ocooreu um erro ao tentar");
			erro.printStackTrace();
		}
	}
}
