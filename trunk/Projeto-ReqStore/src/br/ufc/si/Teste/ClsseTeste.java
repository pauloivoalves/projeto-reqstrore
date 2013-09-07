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
		
		Projeto proj = new Projeto();
//			proj.setNome("Teste de adi��o de versao");
//			proj.setDescricao("Testar dando um Update em um prjeto salava suas versoes");
//			proj.setPontuacao(10);
//			proj.setTipoProjeto(TipoProjeto.DESKTOP);
//			projDAO.save(proj);
			
		Aluno aluno = new Aluno();
		aluno.setNome("Paulo");
		aluno.setEmail("asd@email.com");
		aluno.setSenha("senha");
//		alunoDAO.save(aluno);
		
		
		Aluno alusno  = new Aluno();
		alusno = alunoDAO.carrega(aluno);
		System.out.println(alusno.getNome());
		
		//proj = projDAO.getProjetoById(1);
		//aluno = alunoDAO.getAlunoById(1);
		
//		List<Projeto> projetos = new ArrayList<Projeto>();
//		projetos.add(proj);

		//aluno.setProjetos(projetos);
		//alunoDAO.save(aluno);
		
		//proj.setCriador(aluno);
		//projDAO.save(proj);
		
//		aluno = alunoDAO.getAlunoById(2);
//		proj = projDAO.getProjetoById(1);
		
		//proj.setCriador(aluno);
		//projDAO.update(proj);
		
		RequisitoDAO reqDAO = new RequisitoDAO();
		Requisito req = new Requisito();
		
//		req.setDescricao("Teste");
//		req.setPrioridadeRequisito(PrioridadeRequisito.DESEJAVEL);
//		req.setTipoRequisito(TipoRequisito.NAO_FUNCIONAL);	
//		req.setProjeto(proj);
//		
//		reqDAO.save(req);
//		System.out.println(proj.getRequisitos().get(0).getDescricao() + " ID: " + proj.getRequisitos().get(0).getId());
//		
		
		System.out.println("Temrinou!");
	}

}
