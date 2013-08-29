package br.ufc.si.DAO;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.ufc.si.Interfaces.IVersaoRequisito;
import br.ufc.si.model.Requisito;
import br.ufc.si.model.VersaoRequisito;
import br.ufc.si.util.HibernateUtil;

@Component
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
	public List<VersaoRequisito> List(Requisito requisito) {
		Session session = HibernateUtil.getSession();
		try {
			List<VersaoRequisito> Vrequisitos = session
					.createCriteria(VersaoRequisito.class)
					.add(Restrictions.eqProperty("idRequisito",
							Integer.toString(requisito.getId()))).list();

			for (VersaoRequisito versaoRequisito : Vrequisitos) {
				Hibernate.initialize(versaoRequisito.getIdRequisito());
			}
			return Vrequisitos;
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
			VersaoRequisito versaoRequisito = (VersaoRequisito) session.get(
					VersaoRequisito.class, id);
			Hibernate.initialize(versaoRequisito.getIdRequisito());
			return versaoRequisito;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
