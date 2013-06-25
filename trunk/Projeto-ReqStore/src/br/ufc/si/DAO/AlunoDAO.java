package br.ufc.si.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.ufc.si.Interfaces.IAlunoDao;
import br.ufc.si.model.Aluno;
import br.ufc.si.util.HibernateUtil;

public class AlunoDAO implements IAlunoDao {
	public void save(Aluno aluno) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(aluno);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}

	public void delete(Aluno aluno) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(aluno);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}

	public void update(Aluno aluno) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(aluno);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}

	public Aluno getAlunoById(Integer id) {

		Session session = HibernateUtil.getSession();

		try {
			return (Aluno) session.get(Aluno.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> List() {
		Session session = HibernateUtil.getSession();
		try {
			Criteria criteria = session.createCriteria(Aluno.class);
			return criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	public List<Aluno> SearchByName(String name) {
		try {
			Session session = HibernateUtil.getSession();
			List<Aluno> alunos = session.createCriteria(Aluno.class)
					.add(Restrictions.like("nome", "%" + name + "%")).list();
			return alunos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
