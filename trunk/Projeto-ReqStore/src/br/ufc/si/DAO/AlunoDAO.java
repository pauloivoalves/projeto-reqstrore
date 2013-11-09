package br.ufc.si.DAO;

import java.util.List;

import org.hibernate.Hibernate;
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
			Aluno aluno = (Aluno) session.get(Aluno.class, id);
				Hibernate.initialize(aluno.getProjetos());
			return aluno;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> List() {
		Session session = HibernateUtil.getSession();
		try {
			List<Aluno> alunos = session.createCriteria(Aluno.class).list();
			for (Aluno aluno : alunos) {
				Hibernate.initialize(aluno.getProjetos());
			}
			return alunos;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> SearchByName(String name) {
		Session session = HibernateUtil.getSession();
		try {
			List<Aluno> alunos = session.createCriteria(Aluno.class)
					.add(Restrictions.like("nome", "%" + name + "%")).list();
			for (Aluno aluno : alunos) {
				Hibernate.initialize(aluno.getProjetos());
			}
			return alunos;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public Aluno buscaPorEmail(Aluno aluno) {
		Session session = HibernateUtil.getSession();
		try {
			return (Aluno) session.createCriteria(Aluno.class)
					.add(Restrictions.eq("email", aluno.getEmail()))
					.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	public Aluno carrega(Aluno aluno) {
		Session session = HibernateUtil.getSession();
		try {
			return (Aluno) session.createCriteria(Aluno.class)
					.add(Restrictions.eq("email", aluno.getEmail()))
					.add(Restrictions.eq("senha", aluno.getSenha()))
					.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
