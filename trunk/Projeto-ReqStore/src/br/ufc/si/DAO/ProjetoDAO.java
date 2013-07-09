package br.ufc.si.DAO;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.ufc.si.Interfaces.IProjeto;
import br.ufc.si.model.Projeto;
import br.ufc.si.util.HibernateUtil;

public class ProjetoDAO implements IProjeto {

	public void save(Projeto projeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(projeto);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void update(Projeto projeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(projeto);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}

	}

	public void delete(Projeto projeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(projeto);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Projeto> List() {
		Session session = HibernateUtil.getSession();
		try {
			List<Projeto> listaProjetos = session.createCriteria(Projeto.class).list();
			
			for (Projeto projeto : listaProjetos) {
				Hibernate.initialize(projeto.getRequisitos());
			}
			
			return listaProjetos;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Projeto> SearchByName(String name) {
		Session session = HibernateUtil.getSession();
		try {

			List<Projeto> listaProjetos = session.createCriteria(Projeto.class)
					.add(Restrictions.like("nome", "%" + name + "%")).list();
			for (Projeto projeto : listaProjetos) {
				Hibernate.initialize(projeto.getRequisitos());
			}		
			return listaProjetos;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	public Projeto SearchById(String id) {
		Session session = HibernateUtil.getSession();

		try {
			return (Projeto) session.get(Projeto.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
