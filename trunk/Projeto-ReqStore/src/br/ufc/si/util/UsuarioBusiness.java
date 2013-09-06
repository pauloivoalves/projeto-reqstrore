package br.ufc.si.util;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.ufc.si.model.Usuario;

public class UsuarioBusiness {
	private EntityManager manager;

	public UsuarioBusiness(EntityManager manager) {
		this.manager = manager;
	}

	public Usuario autenticar(String email, String senha, int tipo_usuario) {
		
		//Aluno
		if(tipo_usuario == 1){
			try {
				Query query = manager.createQuery("from aluno where email = :email and senha = :senha");
				query.setParameter("email", email);
				query.setParameter("senha", senha);
				return (Usuario) query.getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
			//Professor
		}else if(tipo_usuario == 2){
			try {
				Query query = manager.createQuery("from professor where email = :email and senha = :senha");
				query.setParameter("email", email);
				query.setParameter("senha", senha);
				return (Usuario) query.getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
			//Administrador
		}else{
			try {
				Query query = manager.createQuery("from administrador where email = :email and senha = :senha");
				query.setParameter("email", email);
				query.setParameter("senha", senha);
				return (Usuario) query.getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
		}
		
	}
}
