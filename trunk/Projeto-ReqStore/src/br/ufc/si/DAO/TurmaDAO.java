package br.ufc.si.DAO;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.ufc.si.Interfaces.ITurma;
import br.ufc.si.model.Turma;
import br.ufc.si.util.HibernateUtil;

@Component
public class TurmaDAO implements ITurma {

	/* (non-Javadoc)
	 * @see br.ufc.si.DAO.ITurma#save(br.ufc.si.model.Turma)
	 */
	public void save(Turma turma) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(turma);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* (non-Javadoc)
	 * @see br.ufc.si.DAO.ITurma#delete(br.ufc.si.model.Turma)
	 */
	public void delete(Turma turma) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(turma);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* (non-Javadoc)
	 * @see br.ufc.si.DAO.ITurma#update(br.ufc.si.model.Turma)
	 */
	public void update(Turma turma) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(turma);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* (non-Javadoc)
	 * @see br.ufc.si.DAO.ITurma#getTurmaById(java.lang.Integer)
	 */
	public Turma getTurmaById(Integer id) {
		Session session = HibernateUtil.getSession();
		try {
			Turma turma = (Turma) session.get(Turma.class, id);
			Hibernate.initialize(turma.getProjetos());
			Hibernate.initialize(turma.getUsuarios());
			return turma;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see br.ufc.si.DAO.ITurma#List()
	 */
	@SuppressWarnings("unchecked")
	public List<Turma> List() {
		Session session = HibernateUtil.getSession();
		try {
			List<Turma> turmas = session.createCriteria(Turma.class).list();
			for (Turma turma : turmas) {
				Hibernate.initialize(turma.getProjetos());
				Hibernate.initialize(turma.getUsuarios());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see br.ufc.si.DAO.ITurma#SearchByName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<Turma> SearchByName(String name) {
		Session session = HibernateUtil.getSession();
		try {
			List<Turma> turmas = session.createCriteria(Turma.class)
					.add(Restrictions.like("nome", "%" + name + "%")).list();
			for (Turma turma : turmas) {
				Hibernate.initialize(turma.getProjetos());
				Hibernate.initialize(turma.getUsuarios());
			}
			return turmas;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
}
