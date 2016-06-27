package br.edu.ifpr.projeto.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import br.edu.ifpr.projeto.domain.Associado;
import br.edu.ifpr.projeto.util.HibernateUtil;

public class AssociadoDAO extends GenericDAO<Associado> {
	
	public Long sqlMax(Associado associado) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Criteria criteria = sessao.createCriteria(associado.getClass()).setProjection(Projections.max("codigo"));
		Long maxId = (Long)criteria.uniqueResult();
		
		return maxId;	
	}

}
