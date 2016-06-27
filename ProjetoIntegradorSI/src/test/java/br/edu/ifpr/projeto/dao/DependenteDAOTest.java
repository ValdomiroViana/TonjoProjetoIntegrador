package br.edu.ifpr.projeto.dao;

import org.junit.Test;

import br.edu.ifpr.projeto.domain.Associado;
import br.edu.ifpr.projeto.domain.Dependente;
import br.edu.ifpr.projeto.domain.Pessoa;

public class DependenteDAOTest {
	
	@Test
	public void salvar() {
		
		Long codigoAssociado = 2L;
		Long codigoPessoa = 7L;
		
		AssociadoDAO associadoDAO = new AssociadoDAO();
		Associado associado = associadoDAO.buscar(codigoAssociado);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);
		
		DependenteDAO dependenteDAO = new DependenteDAO();
		Dependente dependente = new Dependente();
		dependente.setParentesco("Cônjuge");
		dependente.setPessoa(pessoa);
		dependente.setAssociado(associado);
		
		dependenteDAO.salvar(dependente);
		
	}
}
