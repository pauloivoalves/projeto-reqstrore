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
		
		Professor prof = new Professor();
		IProfessor professorDAO = new ProfessorDAO();
		
//		prof.setNome("teste");
//		prof.setEmail("teste@gmail.com");
//		prof.setSenha("teste");
//		
//		professorDAO.save(prof);
		
		Aluno aluno = new Aluno();
		aluno = alunoDAO.getAlunoById(4);
		Projeto proj = new Projeto();
		
//		aluno.setNome("email");
//		aluno.setEmail("email@teste.com");
//		aluno.setSenha("email");
//		alunoDAO.save(aluno);

//		Aluno alusno  = new Aluno();
//		alusno = alunoDAO.carrega(aluno);
//		System.out.println(alusno.getNome());
		
//		proj = projDAO.getProjetoById(4);
//		aluno = alunoDAO.getAlunoById(1);
		
		List<Projeto> projetos = new ArrayList<Projeto>();
//		projetos.add(proj);

		//aluno.setProjetos(projetos);
		//alunoDAO.save(aluno);
		
		//proj.setCriador(aluno);
		//projDAO.save(proj);
		
//		aluno = alunoDAO.getAlunoById(2);
		
		projetos = BuscaNomeRequisito(10, TipoProjeto.DESKTOP, 3, "");
		
		
		for (Projeto projeto : projetos) {
			System.out.println(projeto.getId());
		}
		
		
		//projDAO.update(proj);
		
		RequisitoDAO reqDAO = new RequisitoDAO();
		Requisito req = new Requisito();
		
//		for (int i = 0; i < 10; i++) {
//			req.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
//			req.setPrioridadeRequisito(PrioridadeRequisito.ESSENCIAL);
//			req.setTipoRequisito(TipoRequisito.NAO_FUNCIONAL);
//			req.setFoco_requisito("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
//			req.setProjeto(proj);
//			
//			reqDAO.save(req);	
			
//			proj.setNome("Projeto " + i);
//			proj.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
//			proj.setPontuacao(3);
//			proj.setTipoProjeto(TipoProjeto.DESKTOP);
//			proj.setFoco_projeto("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
//			proj.setCriador(aluno);
//			projDAO.save(proj);
			
			
		//}
		
//		System.out.println(proj.getRequisitos().get(0).getDescricao() + " ID: " + proj.getRequisitos().get(0).getId());
//		
		
		System.out.println("Temrinou!");
	}
	
	public static List<Projeto> BuscaNomeRequisito(int dificuldade, TipoProjeto tipo,  int numReq, String nome){
		IProjeto dao = new ProjetoDAO(); 
		List<Projeto> projetos  = dao.BuscaDificuldadeTipo(dificuldade,  tipo);
		
		if((numReq > 0) && (!nome.equals(""))){
			System.out.println("Teste 1");
			
			List<Projeto> list = new ArrayList<Projeto>();
			
			for (Projeto projeto : projetos) {
				Hibernate.initialize(projeto.getRequisitos());
				if((projeto.getNome().equals(nome)) && (projeto.getRequisitos().size() <= numReq)){
					list.add(projeto);
				}
			}
			
			for (Projeto projeto : list) {
				System.out.println(projeto.getNome());
			}
			return list;
		}else if(!nome.equals("")){
			System.out.println("Teste 2");
			List<Projeto> list = new ArrayList<Projeto>();
			
			for (Projeto projeto : projetos) {
				Hibernate.initialize(projeto.getRequisitos());
				
				if((projeto.getNome().equals(nome))){
					list.add(projeto);
					System.err.println("asd");
				}
			}
			return list;
			
		}else if(numReq > 0){
			System.out.println("Teste 3");
			List<Projeto> list = new ArrayList<Projeto>();
			
			for (Projeto projeto : projetos) {
				Hibernate.initialize(projeto.getRequisitos());
				
				if(projeto.getRequisitos().size() <= numReq){
					list.add(projeto);
				}
			}
			return list;
		}
		return projetos;
	}

}
