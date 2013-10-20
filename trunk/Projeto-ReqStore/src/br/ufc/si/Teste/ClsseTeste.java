package br.ufc.si.Teste;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import antlr.collections.impl.LList;
import br.ufc.si.DAO.AlunoDAO;
import br.ufc.si.DAO.ProfessorDAO;
import br.ufc.si.DAO.ProjetoDAO;
import br.ufc.si.DAO.RequisitoDAO;
import br.ufc.si.DAO.VersaoProjetoDAO;
import br.ufc.si.DAO.VersaoRequisitoDAO;
import br.ufc.si.Interfaces.IAluno;
import br.ufc.si.Interfaces.IProfessor;
import br.ufc.si.Interfaces.IProjeto;
import br.ufc.si.Interfaces.IRequisito;
import br.ufc.si.Interfaces.IVersaoProjeto;
import br.ufc.si.Interfaces.IVersaoRequisito;
import br.ufc.si.Tipos.PrioridadeRequisito;
import br.ufc.si.Tipos.TipoProjeto;
import br.ufc.si.Tipos.TipoRequisito;
import br.ufc.si.model.Aluno;
import br.ufc.si.model.Professor;
import br.ufc.si.model.Projeto;
import br.ufc.si.model.Requisito;
import br.ufc.si.model.VersaoProjeto;
import br.ufc.si.model.VersaoRequisito;
import br.ufc.si.util.HibernateUtil;

@SuppressWarnings("unused")
public class ClsseTeste {
		
	public static void main(String[] args) {
		IProjeto projDAO = new ProjetoDAO();
		
		IVersaoProjeto versaoDAO = new VersaoProjetoDAO();
		IAluno alunoDAO = new AlunoDAO();
		
		
		
		Aluno aluno = new Aluno();
		aluno = alunoDAO.getAlunoById(1);
		Projeto proj = new Projeto();
		
//		
//		aluno.setNome("Paulo");
//		aluno.setEmail("email@teste.com");
//		aluno.setSenha("teste");
//		aluno.setConfirmado(true);
//		aluno.setNumero(123);
//		alunoDAO.save(aluno);
		
		
		RequisitoDAO reqDAO = new RequisitoDAO();
		Requisito req = new Requisito();
//		
		for (int i = 10; i <= 21; i++) {
			proj = projDAO.getProjetoById(i);
			
			for (int j = 0; j < 5; j++) {
				req.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
				req.setPrioridadeRequisito(PrioridadeRequisito.ESSENCIAL);
				req.setTipoRequisito(TipoRequisito.NAO_FUNCIONAL);
				req.setFoco_requisito("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
				req.setProjeto(proj);
				
				reqDAO.save(req);
			}
		}
		System.out.println("Temrinou!");
	}
	
}
