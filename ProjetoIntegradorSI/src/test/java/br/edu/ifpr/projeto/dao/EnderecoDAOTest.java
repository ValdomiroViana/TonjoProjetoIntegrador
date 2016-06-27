package br.edu.ifpr.projeto.dao;

import org.junit.Test;

import br.edu.ifpr.projeto.domain.Associado;
import br.edu.ifpr.projeto.domain.Cidade;
import br.edu.ifpr.projeto.domain.Endereco;

public class EnderecoDAOTest {
	
	@Test
	public void salvar() {
		
		Long codigoAssociado = 1L;
		Long codigoCidade = 1L;
		
		AssociadoDAO associadoDAO = new AssociadoDAO();
		Associado associado = associadoDAO.buscar(codigoAssociado);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Prof. Vergílio Ferreira");
		endereco.setNumero(new Short("957"));
		endereco.setComplemento("Próximo a pista de skate");
		endereco.setCidade(cidade);
//		endereco.setAssociado(associado);
		
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		enderecoDAO.salvar(endereco);

	}
}
