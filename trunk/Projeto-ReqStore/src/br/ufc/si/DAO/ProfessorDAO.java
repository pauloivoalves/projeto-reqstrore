package br.ufc.si.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.ufc.si.Interfaces.IProfessor;
import br.ufc.si.model.Professor;
import br.ufc.si.util.HibernateUtil;

@Component
public class ProfessorDAO implements IProfessor {

	public void save(Professor professor) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(professor);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void update(Professor professor) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(professor);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void delete(Professor professor) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(professor);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Professor> List() {
		Session session = HibernateUtil.getSession();
		try {
			Criteria criteria = session.createCriteria(Professor.class);
			return criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	public List<Professor> SearchByName(String name) {
		Session session = HibernateUtil.getSession();
		try {
		
			List<Professor> professor = session.createCriteria(Professor.class)
					.add(Restrictions.like("nome", "%" + name + "%")).list();
			return professor;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;

	}
	
	public Professor getProfessorById(Integer id) {
		try {
			Session session = HibernateUtil.getSession();
			return (Professor) session.get(Professor.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
