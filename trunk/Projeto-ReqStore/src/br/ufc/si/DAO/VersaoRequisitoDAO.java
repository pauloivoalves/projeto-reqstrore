package br.ufc.si.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.ufc.si.Interfaces.IVersaoRequisito;
import br.ufc.si.model.VersaoRequisito;
import br.ufc.si.util.HibernateUtil;

public class VersaoRequisitoDAO implements IVersaoRequisito {

	public void save(VersaoRequisito versao) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(versao);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void update(VersaoRequisito versao) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(versao);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void delete(VersaoRequisito versao) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(versao);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<VersaoRequisito> List(String idRequisito) {
		Session session = HibernateUtil.getSession();
		try {
			Criteria criteria = session.createCriteria(VersaoRequisito.class)
					.add(Restrictions.eqProperty("idRequisito", idRequisito));
			return criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public VersaoRequisito SearchById(int id) {
		Session session = HibernateUtil.getSession();

		try {
			return (VersaoRequisito) session.get(VersaoRequisito.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
