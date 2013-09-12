package br.ufc.si.Teste;

import java.util.ArrayList;
import java.util.List;

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
		aluno = alunoDAO.getAlunoById(2);
		
		
		Projeto proj = new Projeto();
			
			
		
//		aluno.setNome("Paulo");
//		aluno.setEmail("asd@email.com");
//		aluno.setSenha("senha");
//		alunoDAO.save(aluno);
//		
//		
//		Aluno alusno  = new Aluno();
//		alusno = alunoDAO.carrega(aluno);
//		System.out.println(alusno.getNome());
		
//		proj = projDAO.getProjetoById(4);
		aluno = alunoDAO.getAlunoById(1);
		
//		List<Projeto> projetos = new ArrayList<Projeto>();
//		projetos.add(proj);

		//aluno.setProjetos(projetos);
		//alunoDAO.save(aluno);
		
		//proj.setCriador(aluno);
		//projDAO.save(proj);
		
//		aluno = alunoDAO.getAlunoById(2);
//		proj = projDAO.getProjetoById(1);
		
		
		//projDAO.update(proj);
		
		RequisitoDAO reqDAO = new RequisitoDAO();
		Requisito req = new Requisito();
		
		for (int i = 0; i < 10; i++) {
//			req.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
//			req.setPrioridadeRequisito(PrioridadeRequisito.ESSENCIAL);
//			req.setTipoRequisito(TipoRequisito.FUNCIONAL);	
//			req.setProjeto(proj);
//			
//			reqDAO.save(req);	
			
			proj.setNome("Projeto " + i);
			proj.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In a mattis sem. Morbi nisl erat, iaculis ac tincidunt sit amet, facilisis ac diam. Vestibulum posuere elit ac massa sodales commodo. Ut et eleifend ligula, ac aliquam mi. Ut ultricies aliquet quam non interdum. Donec eros ipsum, vulputate quis cursus in, consectetur sit amet sapien. Pellentesque sit amet nibh condimentum, tristique posuere.");
			proj.setPontuacao(5);
			proj.setTipoProjeto(TipoProjeto.DESKTOP);
			proj.setCriador(aluno);
			projDAO.save(proj);
		}
		
//		System.out.println(proj.getRequisitos().get(0).getDescricao() + " ID: " + proj.getRequisitos().get(0).getId());
//		
		
		System.out.println("Temrinou!");
	}

}
