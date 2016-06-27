package br.edu.ifpr.projeto.dao;

import org.junit.Test;

import br.edu.ifpr.projeto.domain.Associado;
import br.edu.ifpr.projeto.domain.Contato;

public class ContatoDAOTest {
	
	@Test
	public void salvar() {
		
		Long codigoAssociado = 1L;
		
		AssociadoDAO associadoDAO = new AssociadoDAO();
		Associado associado = associadoDAO.buscar(codigoAssociado);

		Contato contato = new Contato();
		contato.setEmail("claitondidone@gmail.com");
		contato.setTelefoneCelular("9920 8768");
		contato.setTelefoneComercial("3263 1166");
		contato.setTelefoneResidencial("3263 1385");
//		contato.setAssociado(associado);
		
		ContatoDAO contatoDAO = new ContatoDAO();
		contatoDAO.salvar(contato);
		
	}
}
