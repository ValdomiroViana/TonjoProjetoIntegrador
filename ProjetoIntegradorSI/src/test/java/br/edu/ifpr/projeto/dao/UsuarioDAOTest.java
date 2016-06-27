package br.edu.ifpr.projeto.dao;

import org.junit.Test;

import br.edu.ifpr.projeto.domain.Usuario;

public class UsuarioDAOTest {
	
	@Test
	public void salvar() {
		
		Usuario usuario = new Usuario();
		usuario.setLogin("claiton.neri");
		usuario.setSenha("12345");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
		
	}
}
