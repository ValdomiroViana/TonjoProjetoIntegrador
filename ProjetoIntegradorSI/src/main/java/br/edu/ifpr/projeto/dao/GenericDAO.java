package br.edu.ifpr.projeto.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.edu.ifpr.projeto.domain.Associado;
import br.edu.ifpr.projeto.util.HibernateUtil;

public class GenericDAO<Entidade> {
	private Class<Entidade> classe;

	// implentação da api reflection - Pega a classe em execucão e atribui a
	// classe
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void salvar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		// Cria a transação que ocorrerá
		Transaction transacao = null;

		try {
			// Cria a transação que ocorrerá
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Entidade> lista() {
		// acessa a fábrica de e...
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			// atribui a classe em execução a consulta
			Criteria consulta = sessao.createCriteria(classe);
			// atribui a consulta ao resultado do tipo List
			List<Entidade> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Entidade> listarCidades(long codigo) {
		// acessa a fábrica de e...
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			System.out.println("Codigo: " + codigo);
			// atribui a classe em execução a consulta
			Criteria consulta = sessao.createCriteria(classe);
			consulta.add(Restrictions.eq("estado_id", 1L));
			// atribui a consulta ao resultado do tipo List
			List<Entidade> resultados = consulta.list();
			return resultados;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public Entidade buscar(long codigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(classe);
			// Restriction são os criterios de consulta, que nesse
			// caso está pesquisando o código.
			consulta.add(Restrictions.idEq(codigo));
			// Converte a consulta do uniqueResult para resultado do
			// tipo Entidade
			Entidade resultado = (Entidade) consulta.uniqueResult();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public Entidade buscarCidades(long estado_id) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(classe);
			// Restriction são os criterios de consulta, que nesse
			// caso está pesquisando o código.
			consulta.add(Restrictions.idEq(estado_id));
			// Converte a consulta do uniqueResult para resultado do
			// tipo Entidade
			Entidade resultado = (Entidade) consulta.uniqueResult();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

	// Método de exclusão
	public void excluir(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}

	// Método de edição
	public void editar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}
}
