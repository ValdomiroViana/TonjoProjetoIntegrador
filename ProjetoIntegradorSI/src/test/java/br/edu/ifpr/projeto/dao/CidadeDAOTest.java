package br.edu.ifpr.projeto.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.bsi.sistema.dao.CidadeDAO;
import br.edu.ifpr.projeto.domain.Cidade;
import br.edu.ifpr.projeto.domain.Estado;

public class CidadeDAOTest {
	
	@Test
	@Ignore
	public void salvar() {

		Long codigoEstado = 2L;

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigoEstado);

		// Cria o objeto que ira receber os dados
		Cidade cidade = new Cidade();

		// Preenche os atributos do objeto
		cidade.setNome("Chapecó");
		cidade.setEstado(estado);

		// Cria o objeto que permite chamar ações do banco de dados
		CidadeDAO cidadedao = new CidadeDAO();

		// Invoca a operação de salvar
		cidadedao.salvar(cidade);
	}
	
	@Test
//	@Ignore
	public void buscarCidade() {
		Long estado_id = 1L;
			
//		Instanciação das classes
		CidadeDAO cidadeDAO = new CidadeDAO();
		List <Cidade> cidades = new ArrayList<>();
		cidades = (List<Cidade>) cidadeDAO.listarCidades(estado_id);

//		Se o objeto for nulo retornara a frase "Nenhum Registro Encontrado", senão as informações conforme solicitadas
		for (Cidade cidade : cidades) {
			System.out.println("Nome: " +cidade.getNome());
		}
	}
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 1L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		cidadeDAO.excluir(cidade);
		
		System.out.println("Cidade Removida");
		System.out.println("Código da Cidade: " + cidade.getCodigo());
		System.out.println("Nome da Cidade: " + cidade.getNome());
		System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
		System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
		System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
	}
}
