package br.ufc.si.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufc.si.Interfaces.IVersaoRequisito;
import br.ufc.si.model.Requisito;
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
			List<VersaoRequisito> ListVersao = session.createCriteria(VersaoRequisito.class).list();
			List<VersaoRequisito> listaRetorno = new ArrayList<VersaoRequisito>();
			
				for (VersaoRequisito versaoRequisito : ListVersao) {
					if(versaoRequisito.getIdRequisito().getId() != Integer.parseInt(idRequisito)){
						listaRetorno.add(versaoRequisito);
					}
				}
			
			return listaRetorno;
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

	public void AddVersaoRequisito(Requisito requisito, String descricao) {
		VersaoRequisito versao = new VersaoRequisito();
		versao.setDescricaoVersao(descricao);
		versao.setIdRequisito(requisito);
		
		this.save(versao);
	}
	

}
