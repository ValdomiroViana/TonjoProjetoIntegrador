package br.edu.ifpr.projeto.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.omnifaces.util.Messages;

import br.edu.ifpr.projeto.dao.AssociadoDAO;
import br.edu.ifpr.projeto.domain.Associado;

@ManagedBean
@ViewScoped
public class PesquisaAssociadosBean {
	
	private List<Associado> associadosFiltrados = new ArrayList<>();

	public List<Associado> getAssociadosFiltrados() {
		return associadosFiltrados;
	}

	public void setAssociadosFiltrados(List<Associado> associadosFiltrados) {
		this.associadosFiltrados = associadosFiltrados;
	}

	public void listar() {
		try {
			AssociadoDAO associadoDAO = new AssociadoDAO();
			associadosFiltrados = associadoDAO.lista();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os associados");
			erro.printStackTrace();
		}
	}
}
