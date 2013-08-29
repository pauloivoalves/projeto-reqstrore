package br.ufc.si.DAO;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.ufc.si.Interfaces.IVersaoProjeto;
import br.ufc.si.model.Projeto;
import br.ufc.si.model.VersaoProjeto;
import br.ufc.si.util.HibernateUtil;

@Component
public class VersaoProjetoDAO implements IVersaoProjeto {

	public void save(VersaoProjeto versaoProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(versaoProjeto);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void update(VersaoProjeto versaoProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(versaoProjeto);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void delete(VersaoProjeto versaoProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(versaoProjeto);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<VersaoProjeto> List(Projeto projeto) {
		Session session = HibernateUtil.getSession();
		try {
			List<VersaoProjeto> Vprojetos = session
					.createCriteria(VersaoProjeto.class)
					.add(Restrictions.eqProperty("idProjeto",
							Integer.toString(projeto.getId()))).list();

			for (VersaoProjeto versaoProjeto : Vprojetos) {
				Hibernate.initialize(versaoProjeto.getIdProjeto());
			}

			return Vprojetos;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public VersaoProjeto getVersaoById(int id) {
		Session session = HibernateUtil.getSession();

		try {
			VersaoProjeto versaoProjeto = (VersaoProjeto) session.get(
					VersaoProjeto.class, id);
			Hibernate.initialize(versaoProjeto.getIdProjeto());
			return versaoProjeto;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
