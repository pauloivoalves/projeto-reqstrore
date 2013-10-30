package br.ufc.si.Teste;

import br.ufc.si.DAO.AlunoDAO;
import br.ufc.si.DAO.ProjetoDAO;
import br.ufc.si.DAO.RequisitoDAO;
import br.ufc.si.DAO.VersaoProjetoDAO;
import br.ufc.si.Interfaces.IAluno;
import br.ufc.si.Interfaces.IProjeto;
import br.ufc.si.Interfaces.IVersaoProjeto;
import br.ufc.si.Tipos.PrioridadeRequisito;
import br.ufc.si.Tipos.TipoRequisito;
import br.ufc.si.model.Aluno;
import br.ufc.si.model.Projeto;
import br.ufc.si.model.Requisito;

@SuppressWarnings("unused")
public class ClsseTeste {

	public static void main(String[] args) {
		IProjeto projDAO = new ProjetoDAO();

		IVersaoProjeto versaoDAO = new VersaoProjetoDAO();
		IAluno alunoDAO = new AlunoDAO();

		Aluno aluno = new Aluno();
		aluno = alunoDAO.getAlunoById(5);
		Projeto proj = new Projeto();

//		 aluno.setNome("Paulo Ivo");
//		 aluno.setEmail("email@teste.com");
//		 aluno.setSenha("teste");
//		 aluno.setConfirmado(true);
//		 aluno.setNumero(123);
//		 alunoDAO.save(aluno);

		RequisitoDAO reqDAO = new RequisitoDAO();
		Requisito req = new Requisito();
//		List<Projeto> projetos = new ArrayList<Projeto>();
//		 for (int i = 4; i <= 8; i++) {
//		 proj.setNome("Projeto " + i);
//		 proj.setCriador(aluno);
//		 proj.setDificuldade(2);
//		 proj.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
//		 proj.setFoco_projeto("Introdução a SQL básico");
//		 proj.setTipoProjeto(TipoProjeto.MOBILE);
//		 projDAO.save(proj);
		 
		
//		 projetos.add(proj);
			 
		
//		 for (int j = 9; j <=10; j++) {
//		 proj = projDAO.getProjetoById(j);
//		 req.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
//		 req.setPrioridadeRequisito(PrioridadeRequisito.DESEJAVEL);
//		 req.setTipoRequisito(TipoRequisito.NAO_FUNCIONAL);
//		 req.setFoco_requisito("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
//		 req.setProjeto(proj);
//		
//		 reqDAO.save(req);
//		 }
//		 }
		 
//		 aluno.setProjetos_participantes(projetos);
//		 alunoDAO.update(aluno);
//		 List<Usuario> users = new ArrayList<Usuario>();
//		 users.add(aluno);
//		 
//		 for (Projeto projeto : projetos) {
//			 projeto.setUsuarios_participantes(users);
//			 projDAO.update(projeto);
//		}
		 
//		 proj = projDAO.getProjetoById(2);
//		 projetos.add(proj);
//		 aluno.setProjetos(projetos);
//		 alunoDAO.update(aluno);
//		 List<Usuario> users = new ArrayList<Usuario>();
//		 users.add(aluno);
//		 proj.setCriador(aluno);
//		 projDAO.update(proj);
		 
//		ITurma turmaDAO = new TurmaDAO();
//		Turma turma = new Turma();
//		turma = turmaDAO.getTurmaById(74);
//		List<Usuario> users = new ArrayList<Usuario>();
//		List<Turma> turmas = new ArrayList<Turma>();
//		users.add(aluno);
//		turma.setUsuarios(users);
//		turmaDAO.update(turma);
//		
//		turmas.add(turma);
//		aluno.setTurmas(turmas);
//		alunoDAO.update(aluno);
		
		
//
//		List<Aluno> alunos = new ArrayList<Aluno>();
//		alunos = alunoDAO.List();
//
//		List<Projeto> projetos = new ArrayList<Projeto>();
//		List<Turma> turmas = new ArrayList<Turma>();
		
//		turmas = turmaDAO.List();
//		System.out.println("tamanho : " + turmas.isEmpty());
//		for (Turma turma : turmas) {
//			System.out.println("nome: " + turma.getNome());	
//		}
//
//		proj = projDAO.getProjetoById(58);
//
//		turma = turmaDAO.getTurmaById(74);
//		turma.setProjetos(projetos);
//		turmas.add(turma);
//
//		proj.setTurmas(turmas);O
//
//		projetos.add(proj);
//
//		for (Projeto proje : projetos) {
//			projDAO.update(proje);
//		}
//		for (Turma t : turmas) {
//			turmaDAO.update(t);
//		}
		
//		Professor prof= new Professor();
//		prof.setNome("professor");
//		prof.setEmail("professer@email.com");
//		prof.setNumero(123);
//		prof.setConfirmado(true);
//		prof.setSenha("professor");
//		
//		IProfessor profDAO = new ProfessorDAO();
//		profDAO.save(prof);

		System.out.println("Temrinou!");
	}

}
