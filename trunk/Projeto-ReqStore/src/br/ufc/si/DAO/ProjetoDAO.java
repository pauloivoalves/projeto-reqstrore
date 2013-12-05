package br.ufc.si.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.ufc.si.Interfaces.IAluno;
import br.ufc.si.Interfaces.IProfessor;
import br.ufc.si.Interfaces.IProjeto;
import br.ufc.si.Tipos.TipoProjeto;
import br.ufc.si.model.Aluno;
import br.ufc.si.model.Professor;
import br.ufc.si.model.Projeto;
import br.ufc.si.model.Usuario;
import br.ufc.si.util.HibernateUtil;

@Component
public class ProjetoDAO implements IProjeto {

	public void save(Projeto projeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(projeto);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void update(Projeto projeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(projeto);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void delete(Projeto projeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(projeto);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Projeto> List() {
		Session session = HibernateUtil.getSession();
		try {
			List<Projeto> listaProjetos = session.createCriteria(Projeto.class).list();

			for (Projeto projeto : listaProjetos) {
				Hibernate.initialize(projeto.getRequisitos());
			}

			return listaProjetos;
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public List<Projeto> SearchByName(int id_usuario, String name) {
		Session session = HibernateUtil.getSession();
		try {
			try {
				IAluno alunoDAO = new AlunoDAO();
				Aluno aluno = alunoDAO.getAlunoById(id_usuario);
				
				List<Projeto> lista = new ArrayList<Projeto>();
				for (Projeto projeto : aluno.getProjetos()) {
					if(projeto.getNome().equalsIgnoreCase(name)){
						lista.add(projeto);
					}
				}
				
				for (Projeto projeto : aluno.getProjetos_participantes()) {
					if(projeto.getNome().equalsIgnoreCase(name)){
						lista.add(projeto);
					}
				}
				 
				
				for (Projeto projeto : lista) {
					Hibernate.initialize(projeto);
				}
				return lista;
			} catch (Exception e) {
				
				IProfessor professorDAO = new ProfessorDAO();
				Professor professor = professorDAO.getProfessorById(id_usuario);
				
				List<Projeto> lista = new ArrayList<Projeto>();
				
				for (Projeto projeto : professor.getProjetos()) {
					if(projeto.getNome().equalsIgnoreCase(name)){
						lista.add(projeto);
					}
				}
				
				for (Projeto projeto : professor.getProjetos_participantes()) {
					if(projeto.getNome().equalsIgnoreCase(name)){
						lista.add(projeto);
					}
				}
				
				for (Projeto projeto : lista) {
					Hibernate.initialize(projeto);
				}
				return lista;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public List<Projeto> BuscaDificuldadeTipo(int id_usuario, int dificuldade, TipoProjeto tipo) {
		Session session = HibernateUtil.getSession();
		try {
			try {
				IAluno alunoDAO = new AlunoDAO();
				Aluno aluno = alunoDAO.getAlunoById(id_usuario);
				
				List<Projeto> lista = new ArrayList<Projeto>();
				lista.addAll(aluno.getProjetos());
				lista.addAll(aluno.getProjetos_participantes());
				 
				
				for (Projeto projeto : lista) {
					Hibernate.initialize(projeto);
				}
				return lista;
			} catch (Exception e) {
				IProfessor professorDAO = new ProfessorDAO();
				Professor professor = professorDAO.getProfessorById(id_usuario);
				
				List<Projeto> lista = new ArrayList<Projeto>();
				lista.addAll(professor.getProjetos());
				lista.addAll(professor.getProjetos_participantes());
				 
				
				for (Projeto projeto : lista) {
					Hibernate.initialize(projeto);
				}
				return lista;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	public List<Projeto> MeusProjetos(Usuario user) {
		Session session = HibernateUtil.getSession();
		try {
			
			@SuppressWarnings("unchecked")
			List<Projeto> lista = session.createCriteria(Projeto.class).add(Restrictions.eq("criador", user)).list();
			for (Projeto projeto : lista) {
				Hibernate.initialize(projeto);
			}
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public Projeto getProjetoById(int id) {
		Session session = HibernateUtil.getSession();
		try {
			Projeto projeto = (Projeto) session.get(Projeto.class, id);
			Hibernate.initialize(projeto.getRequisitos());
			return projeto;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
