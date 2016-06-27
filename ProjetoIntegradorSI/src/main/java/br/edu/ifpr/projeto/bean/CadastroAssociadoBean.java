package br.edu.ifpr.projeto.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.omnifaces.util.Messages;

import br.edu.ifpr.projeto.dao.AssociadoDAO;
import br.edu.ifpr.projeto.domain.Associado;
import br.edu.ifpr.projeto.domain.Contato;
import br.edu.ifpr.projeto.domain.Dependente;
import br.edu.ifpr.projeto.domain.Endereco;
import br.edu.ifpr.projeto.domain.Pessoa;

@ManagedBean
@ViewScoped
public class CadastroAssociadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Associado associado;
	private Pessoa pessoa;
	private Dependente dependente1;
	private Dependente dependente2;
	private Dependente dependente3;
	private Dependente dependente4;
	private List<Dependente> dependentes;

	public CadastroAssociadoBean() {
		associado = new Associado();
		dependente1 = new Dependente();
		dependente2 = new Dependente();
		dependente3 = new Dependente();
		dependente4 = new Dependente();
		dependente1.setPessoa(new Pessoa());
		dependente2.setPessoa(new Pessoa());
		dependente3.setPessoa(new Pessoa());
		dependente4.setPessoa(new Pessoa());
		associado.setPessoa(new Pessoa());
		associado.setEndereco(new Endereco());
		associado.setContato(new Contato());
		associado.setDependente(new ArrayList<>());
		System.out.println("Instanciando Classes ...");
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}

	public Dependente getDependente1() {
		return dependente1;
	}

	public void setDependente1(Dependente dependente1) {
		this.dependente1 = dependente1;
	}

	public Dependente getDependente2() {
		return dependente2;
	}

	public void setDependente2(Dependente dependente2) {
		this.dependente2 = dependente2;
	}

	public Dependente getDependente3() {
		return dependente3;
	}

	public void setDependente3(Dependente dependente3) {
		this.dependente3 = dependente3;
	}

	public Dependente getDependente4() {
		return dependente4;
	}

	public void setDependente4(Dependente dependente4) {
		this.dependente4 = dependente4;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	// Metodos
	// Metodo para limpar os campos após Salvar
	public void novo() {
		associado = new Associado();
		associado.setPessoa(new Pessoa());
		associado.setEndereco(new Endereco());
		associado.setContato(new Contato());
		System.out.println("Novo Objeto ...");
	}

	// Metodos Salvar
	public void salvar() {
		try {
			chamarId();
			addDependenteList();
			AssociadoDAO associadoDAO = new AssociadoDAO();
			associado.setDependente(dependentes);
			dependente1.setAssociado(associado);
			dependente2.setAssociado(associado);
			dependente3.setAssociado(associado);
			dependente4.setAssociado(associado);
			associadoDAO.salvar(associado);

			Messages.addGlobalInfo("Associado salvo com sucesso");
			novo();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Associado");
			erro.printStackTrace();
		}
	}
	
	public List<Dependente> addDependenteList() {
		dependentes = new ArrayList<>();
		dependentes.add(dependente1);
		dependentes.add(dependente2);
		dependentes.add(dependente3);
		dependentes.add(dependente4);
		
		return dependentes;		
	}

	public void chamarId() {
		try {
			Associado associado = new Associado();
			AssociadoDAO associadoDAO = new AssociadoDAO();
			Long cod = associadoDAO.sqlMax(associado);
			
			Long maxId = cod + 1;
			
			System.out.println("Codigo: " +maxId);		
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Nao pegou o id");
			erro.printStackTrace();
		}
	}
}