package br.ufc.si.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.ufc.si.Interfaces.IRequisito;
import br.ufc.si.model.Requisito;
import br.ufc.si.util.HibernateUtil;

public class RequisitoDAO implements IRequisito {

	public void save(Requisito requisito) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(requisito);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void update(Requisito requisito) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(requisito);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void delete(Requisito requisito) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(requisito);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Requisito> List(String idProjeto) {
		Session session = HibernateUtil.getSession();
		try {
			Criteria criteria = session.createCriteria(Requisito.class).add(Restrictions.eqProperty("projeto", idProjeto));
			return criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public Requisito SearchById(String id) {
		Session session = HibernateUtil.getSession();

		try {
			return (Requisito) session.get(Requisito.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}


}
