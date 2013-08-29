package br.ufc.si.DAO;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.ufc.si.Interfaces.IAdministrador;
import br.ufc.si.model.Administrador;
import br.ufc.si.util.HibernateUtil;

@Component
public class AdministradorDAO implements IAdministrador {

	public void save(Administrador admin) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(admin);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}

	}

	public void update(Administrador admin) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(admin);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}

	}

	public void delete(Administrador admin) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(admin);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	public java.util.List<Administrador> List() {
		Session session = HibernateUtil.getSession();
		try {
			List<Administrador> admins = session.createCriteria(
					Administrador.class).list();

			for (Administrador administrador : admins) {
				Hibernate.initialize(administrador.getProjetos());
			}
			return admins;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public java.util.List<Administrador> SearchByName(String name) {
		Session session = HibernateUtil.getSession();
		try {

			List<Administrador> admins = session
					.createCriteria(Administrador.class)
					.add(Restrictions.like("nome", "%" + name + "%")).list();

			for (Administrador administrador : admins) {
				Hibernate.initialize(administrador.getProjetos());
			}

			return admins;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public Administrador getAdministradorById(Integer id) {
		try {
			Session session = HibernateUtil.getSession();
			Administrador admin = (Administrador) session.get(
					Administrador.class, id);
			Hibernate.initialize(admin.getProjetos());
			return admin;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
