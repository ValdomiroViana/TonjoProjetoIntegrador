package br.edu.ifpr.projeto.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.ifpr.projeto.domain.Estado;

public class EstadoDAOTest {
	
	@Test
//	@Ignore
	public void salvar(){
		
		Estado estado = new Estado();
		estado.setNome("Santa Catarina");
		estado.setSigla("SC");
		
		EstadoDAO estadoDao = new EstadoDAO();
		
		estadoDao.salvar(estado);
	}
	
	@Test
	@Ignore
	public void listar(){
		EstadoDAO estadoDAO = new EstadoDAO();
		//Lista que recebe os resultados do método
		List<Estado> resultado = estadoDAO.lista();
		
		System.out.println("Total de Registros Encontrados: " + resultado.size());
		
		//foreach par apercorrer a lista
		for(Estado estado : resultado){
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 2L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		//acecssar o método buscar e passar o parametro codigo
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum Registro Encontrado");
		}else{
			System.out.println("Registro Encotrado:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 1L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		//Primeiro deve-se buscar o elemento a excluir
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum Registro Encontrado");
		}else{
			estadoDAO.excluir(estado);
			System.out.println("Registro removido:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}		
	}
	
	@Test
	@Ignore
	public void editar() {
		Long codigo = 1L;

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		System.out.println("Estado a ser editado:");
		System.out.println("Codigo do Estado: " + estado.getCodigo());
		System.out.println("Sigla do Estado: " + estado.getSigla());
		System.out.println("Nome do Estado: " + estado.getNome());

		estado.setNome("Santa Catarina");
		estado.setSigla("SC");
		estadoDAO.editar(estado);

		System.out.println("Estado editado:");
		System.out.println("Codigo do Estado: " + estado.getCodigo());
		System.out.println("Sigla do Estado: " + estado.getSigla());
		System.out.println("Nome do Estado: " + estado.getNome());
	}
}
