package br.com.resource.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


@Repository
@EnableTransactionManagement
public class Dao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public <T> void salvar(T entidade) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(entidade);
	}
	
	@Transactional
	public <T> void excluir(T entidade) {
		Session session = this.sessionFactory.getCurrentSession();
		session.remove(entidade);
	}
	
	@Transactional
	public <T> void altera(T entidade) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(entidade);
	}
	
	@Transactional
	@SuppressWarnings(value = { "unchecked" })
	public <T> List<T> buscaTodos(Class<T> classeEntidade){
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM "+classeEntidade.getSimpleName()).getResultList();
	}
	
	@Transactional
	public <T> T buscarPorId(int id, Class<T> classeEntidade) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.find(classeEntidade, id);
	}
	
}
