package br.ufc.si.Teste;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import antlr.collections.impl.LList;
import br.ufc.si.DAO.AlunoDAO;
import br.ufc.si.DAO.ProjetoDAO;
import br.ufc.si.DAO.RequisitoDAO;
import br.ufc.si.DAO.VersaoProjetoDAO;
import br.ufc.si.DAO.VersaoRequisitoDAO;
import br.ufc.si.Interfaces.IAluno;
import br.ufc.si.Interfaces.IProjeto;
import br.ufc.si.Interfaces.IRequisito;
import br.ufc.si.Interfaces.IVersaoProjeto;
import br.ufc.si.Interfaces.IVersaoRequisito;
import br.ufc.si.Tipos.PrioridadeRequisito;
import br.ufc.si.Tipos.TipoProjeto;
import br.ufc.si.Tipos.TipoRequisito;
import br.ufc.si.model.Aluno;
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
//			proj.setNome("Teste de adição de versao");
//			proj.setDescricao("Testar dando um Update em um prjeto salava suas versoes");
//			proj.setPontuacao(10);
//			proj.setTipoProjeto(TipoProjeto.DESKTOP);
//			projDAO.save(proj);
			
		Aluno aluno = new Aluno();
//		aluno.setNome("Paulo");
//		aluno.setEmail("teste@email.com");
//		aluno.setSenha("senha");
//		alunoDAO.save(aluno);
		
		proj = projDAO.getProjetoById(2);
		aluno = alunoDAO.getAlunoById(1);
		
//		List<Projeto> projetos = new ArrayList<Projeto>();
//		projetos.add(proj);

		//aluno.setProjetos(projetos);
		//alunoDAO.update(aluno);
		
		proj.setCriador(aluno);
		projDAO.update(proj);
		System.out.println("Temrinou!");
	}

}
