package br.edu.ifpr.projeto.dao;

import java.util.Date;
import java.util.regex.Pattern;

import org.junit.Test;

import br.edu.ifpr.projeto.domain.Associado;
import br.edu.ifpr.projeto.domain.Mensalidade;
import br.edu.ifpr.projeto.domain.Situacao;

public class MensalidadeDAOTest {
	
	@Test
	public void salvar() {
		
		Long codigoAssociado = 2L;
		
		AssociadoDAO associadoDAO = new AssociadoDAO();
		Associado associado = associadoDAO.buscar(codigoAssociado);
		
		Mensalidade mensalidade = new Mensalidade();
		mensalidade.setDataPagamento(new Date());
		mensalidade.setDataVencimento(new Date());
		mensalidade.setSituacao(Situacao.ATRASADO);
		mensalidade.setValor(new Float(70));
		mensalidade.setAssociado(associado);
		
		MensalidadeDAO mensalidadeDAO = new MensalidadeDAO();
		mensalidadeDAO.salvar(mensalidade);
	
	}
}
