package br.edu.ifpr.projeto.dao;

import java.util.Date;

import org.junit.Test;

import br.edu.ifpr.projeto.domain.Pessoa;
import br.edu.ifpr.projeto.domain.Sexo;

public class PessoaDAOTest {
	
	@Test
	public void salvar() {
		
//		Cadastro do Associado
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Jevon L");
		pessoa.setSexo(Sexo.MASCULINO);
		pessoa.setDataNascimento(new Date());
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);
		
//		Cadastro do Dependente
//		Pessoa pessoa = new Pessoa();
//		pessoa.setNome("Ana Tieli Dutra");
//		pessoa.setSexo(Sexo.FEMININO);
//		pessoa.setDataNascimento(new Date());
//		
//		PessoaDAO pessoaDAO = new PessoaDAO();
//		pessoaDAO.salvar(pessoa);
		
	}

}
