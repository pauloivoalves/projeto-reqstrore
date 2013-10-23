package br.ufc.si.Teste;

import java.util.ArrayList;
import java.util.List;

import br.ufc.si.DAO.AlunoDAO;
import br.ufc.si.DAO.ProjetoDAO;
import br.ufc.si.DAO.RequisitoDAO;
import br.ufc.si.DAO.TurmaDAO;
import br.ufc.si.DAO.VersaoProjetoDAO;
import br.ufc.si.Interfaces.IAluno;
import br.ufc.si.Interfaces.IProjeto;
import br.ufc.si.Interfaces.ITurma;
import br.ufc.si.Interfaces.IVersaoProjeto;
import br.ufc.si.model.Aluno;
import br.ufc.si.model.Projeto;
import br.ufc.si.model.Requisito;
import br.ufc.si.model.Turma;

@SuppressWarnings("unused")
public class ClsseTeste {

	public static void main(String[] args) {
		IProjeto projDAO = new ProjetoDAO();

		IVersaoProjeto versaoDAO = new VersaoProjetoDAO();
		IAluno alunoDAO = new AlunoDAO();

		Aluno aluno = new Aluno();
		// aluno = alunoDAO.getAlunoById(1);
		Projeto proj = new Projeto();

		// aluno.setNome("Paulo");
		// aluno.setEmail("email@teste.com");
		// aluno.setSenha("teste");
		// aluno.setConfirmado(true);
		// aluno.setNumero(123);
		// alunoDAO.save(aluno);

		RequisitoDAO reqDAO = new RequisitoDAO();
		Requisito req = new Requisito();

		// for (int i = 0; i <= 2; i++) {
		// proj.setNome("Projeto " + i);
		// proj.setCriador(aluno);
		// proj.setDificuldade(2);
		// proj.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
		// proj.setFoco_projeto("Introdução a SQL básico");
		// proj.setTipoProjeto(TipoProjeto.WEB);
		// projDAO.save(proj);
		//
		// proj = projDAO.getProjetoById(58);
		// for (int j = 0; j < 5; j++) {
		// req.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
		// req.setPrioridadeRequisito(PrioridadeRequisito.ESSENCIAL);
		// req.setTipoRequisito(TipoRequisito.FUNCIONAL);
		// req.setFoco_requisito("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
		// req.setProjeto(proj);
		//
		// reqDAO.save(req);
		// }
		// }

		ITurma turmaDAO = new TurmaDAO();
		Turma turma = new Turma();

		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos = alunoDAO.List();

		List<Projeto> projetos = new ArrayList<Projeto>();
		List<Turma> turmas = new ArrayList<Turma>();

		proj = projDAO.getProjetoById(58);

		turma = turmaDAO.getTurmaById(74);
		turma.setProjetos(projetos);
		turmas.add(turma);

		proj.setTurmas(turmas);

		projetos.add(proj);

		for (Projeto proje : projetos) {
			projDAO.update(proje);
		}
		for (Turma t : turmas) {
			turmaDAO.update(t);
		}

		System.out.println("Temrinou!");
	}

}
