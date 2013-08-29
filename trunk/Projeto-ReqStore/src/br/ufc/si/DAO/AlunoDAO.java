package br.ufc.si.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.ufc.si.Interfaces.IAluno;
import br.ufc.si.model.Aluno;
import br.ufc.si.util.HibernateUtil;

@Component
public class AlunoDAO implements IAluno {

	public void save(Aluno aluno) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction t = session.beginTransaction();
			session.save(aluno);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Aluno aluno) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction t = session.beginTransaction();

			session.delete(aluno);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Aluno aluno) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction t = session.beginTransaction();

			session.update(aluno);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public Aluno getAlunoById(Integer id) {
		try {
			Session session = HibernateUtil.getSession();
			return (Aluno) session.get(Aluno.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> List() {
		try {
			Session session = HibernateUtil.getSession();

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
