package br.edu.ifpr.projeto.dao;

import org.junit.Test;

import br.edu.ifpr.projeto.domain.Associado;
import br.edu.ifpr.projeto.domain.Pessoa;
import br.edu.ifpr.projeto.domain.Status;

public class AssociadoDAOTest {
	
	@Test
	public void salvar() {
		
		Long codigoPessoa = 6L;
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);

		AssociadoDAO associadoDAO = new AssociadoDAO();
		Associado associado = new Associado();
		associado.setRg("1.234.567-8");
		associado.setCpf("012.345.678-90");
		associado.setCidadeNaturalidade("Clevelãndia");
		associado.setEstadoNaturalidade("Parana");
		associado.setObservacao("Ops !!!");
		associado.setStatus(Status.ATIVO);
		associado.setPessoa(pessoa);
		
		associadoDAO.salvar(associado);
	}
}
