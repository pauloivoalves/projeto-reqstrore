package br.ufc.si.Teste;

import java.util.List;

import br.ufc.si.DAO.AlunoDAO;
import br.ufc.si.DAO.ProfessorDAO;
import br.ufc.si.DAO.ProjetoDAO;
import br.ufc.si.DAO.RequisitoDAO;
import br.ufc.si.DAO.TurmaDAO;
import br.ufc.si.Interfaces.IAluno;
import br.ufc.si.Interfaces.IProfessor;
import br.ufc.si.Interfaces.IProjeto;
import br.ufc.si.Interfaces.IRequisito;
import br.ufc.si.Interfaces.ITurma;
import br.ufc.si.Tipos.PrioridadeRequisito;
import br.ufc.si.Tipos.TipoProjeto;
import br.ufc.si.Tipos.TipoRequisito;
import br.ufc.si.model.Aluno;
import br.ufc.si.model.Professor;
import br.ufc.si.model.Projeto;
import br.ufc.si.model.Requisito;
import br.ufc.si.model.Turma;
import br.ufc.si.model.Usuario;

public class ClsseTeste {
	public static IProjeto projDAO = new ProjetoDAO();
	public static IAluno alunoDAO = new AlunoDAO();
	public static ITurma turmaDAO = new TurmaDAO();
	public static IProfessor profDAO = new ProfessorDAO();
	public static IRequisito reqDAO = new RequisitoDAO();

	public static void AdicionarAlunos(int quantidade) {
		Aluno aluno;
		for (int i = 0; i < quantidade; i++) {
			aluno = new Aluno();
			aluno.setNome("Aluno " + i);
			aluno.setEmail("email" + i + "@email.com");
			aluno.setSenha("senha");
			aluno.setConfirmado(true);
			aluno.setNumero(i);
			alunoDAO.save(aluno);
		}
	}

	public static void AdicionarProfessores(int quantidade) {
		Professor prof;
			prof = new Professor();
			prof.setNome("Paulo Ivo Alves Pordeus");
			prof.setEmail("pauloivoalves@gmail.com");
			prof.setSenha("071832");
			prof.setConfirmado(true);
			prof.setNumero(123);
			profDAO.save(prof);
	}

	public static List<Projeto> listarMeusprojetos(Usuario usuario) {
		return projDAO.MeusProjetos(usuario);
	}

	public static void AdicionarPeojetos(int quantidade) {
		Projeto proj;
		for (int i = 0; i < quantidade; i++) {
			proj = new Projeto();
			proj.setNome("Projeto " + i);
			proj.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
			proj.setDificuldade(5);
			proj.setFoco_projeto("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
			proj.setTipoProjeto(TipoProjeto.WEB);
			projDAO.save(proj);
		}
		for (int i = 0; i < quantidade; i++) {
			proj = new Projeto();
			proj.setNome("Projeto " + i);
			proj.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
			proj.setDificuldade(5);
			proj.setFoco_projeto("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
			proj.setTipoProjeto(TipoProjeto.DESKTOP);
			projDAO.save(proj);
		}
		for (int i = 0; i < quantidade; i++) {
			proj = new Projeto();
			proj.setNome("Projeto " + i);
			proj.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
			proj.setDificuldade(5);
			proj.setFoco_projeto("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
			proj.setTipoProjeto(TipoProjeto.MOBILE);
			projDAO.save(proj);
		}
	}

	public static void AdicionarCriadoProjeto(Usuario usuario, Projeto projeto) {
		projeto.setCriador(usuario);
		projDAO.update(projeto);

		List<Projeto> projetos = usuario.getProjetos();
		projetos.add(projeto);
		usuario.setProjetos(projetos);
		if (usuario instanceof Aluno) {
			alunoDAO.update((Aluno) usuario);
		} else if (usuario instanceof Professor) {
			profDAO.update((Professor) usuario);
		}

	}

	public static void adicionarRequisitoProjeto(int quantidade) {
		List<Projeto> projetos = projDAO.List();
		Projeto proj = new Projeto();

		for (int i = 0; i < projetos.size(); i++) {
			proj = projetos.get(i);
			for (int j = 0; j < quantidade; j++) {
				Requisito req = new Requisito();
				req.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
				req.setFoco_requisito("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
				req.setPrioridadeRequisito(PrioridadeRequisito.ESSENCIAL);
				req.setTipoRequisito(TipoRequisito.NEGOCIO);
				req.setProjeto(proj);
				reqDAO.save(req);
			}
		}

		for (int i = 0; i < projetos.size(); i++) {
			proj = projetos.get(i);
			for (int j = 0; j < quantidade; j++) {
				Requisito req = new Requisito();
				req.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
				req.setFoco_requisito("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
				req.setPrioridadeRequisito(PrioridadeRequisito.IMPORTANTE);
				req.setTipoRequisito(TipoRequisito.NAO_FUNCIONAL);
				req.setProjeto(proj);
				reqDAO.save(req);
			}
		}

		for (int i = 0; i < projetos.size(); i++) {
			proj = projetos.get(i);
			for (int j = 0; j < quantidade; j++) {
				Requisito req = new Requisito();
				req.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
				req.setFoco_requisito("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
				req.setPrioridadeRequisito(PrioridadeRequisito.DESEJAVEL);
				req.setTipoRequisito(TipoRequisito.FUNCIONAL);
				req.setProjeto(proj);
				reqDAO.save(req);
			}
		}
	}

	public static void AdicionarTurmas(int quantidade) {

		for (int i = 0; i < quantidade; i++) {
			// adiciona a turma
			Turma turma = new Turma();
			turma.setNome("Turma " + 1);
			turma.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in aliquet dui, vel fringilla justo. Sed sed orci eu metus faucibus rhoncus eget sed ante. Sed malesuada lobortis ultricies. Donec ullamcorper fringilla sapien dignissim egestas. Nulla ultrices mauris nec tellus pulvinar, sed adipiscing eros faucibus. Duis aliquet tellus nulla, vel pharetra quam iaculis eu. Fusce sagittis ligula amet");
			turmaDAO.save(turma);
		}
	}

	public static void AdicionarUsuarioProjeto(Usuario user, Projeto proj) {
		List<Usuario> usuarios = proj.getUsuarios_participantes();
		usuarios.add(user);
		proj.setUsuarios_participantes(usuarios);

		projDAO.update(proj);
		List<Projeto> projetos = user.getProjetos_participantes();
		projetos.add(proj);
		user.setProjetos_participantes(projetos);

		if (user instanceof Aluno) {
			alunoDAO.update((Aluno) user);
		} else if (user instanceof Professor) {
			profDAO.update((Professor) user);
		}

	}

	public static void AdicionarProjetoTurma(Projeto proj, Turma turma) {
		List<Projeto> projetos = turma.getProjetos();
		projetos.add(proj);
		turma.setProjetos(projetos);
		turmaDAO.update(turma);

		List<Turma> turmas = proj.getTurmas();
		turmas.add(turma);
		proj.setTurmas(turmas);
		projDAO.update(proj);

	}

	public static void AdicionarProfessorTurma(Professor prof, Turma turma) {

		turma.setResponsavel(prof);
		turmaDAO.update(turma);

		List<Turma> turmas = prof.getTurmas();
		turmas.add(turma);
		prof.setTurmas(turmas);
		profDAO.update(prof);

	}

	public static void AdicionarUsuarioTurma(Usuario user, Turma turma) {

		List<Turma> turmas = user.getTurmas();
		turmas.add(turma);
		user.setTurmas(turmas);

		if (user instanceof Aluno) {
			alunoDAO.update((Aluno) user);
		} else if (user instanceof Professor) {
			profDAO.update((Professor) user);
		}

		List<Usuario> usuarios = turma.getUsuarios();
		usuarios.add(user);
		turma.setUsuarios(usuarios);
		turmaDAO.update(turma);

	}
	
	public static void RemoveProjeto(int id_projeto, int id_usuario) {
		System.out.println("Usuario : " + id_usuario);
		
		Projeto projeto = projDAO.getProjetoById(id_projeto);
		
		for (Usuario usuario : projeto.getUsuarios_participantes()) {
			usuario.getProjetos_participantes().remove(projeto);
			if (usuario instanceof Aluno) {
				alunoDAO.update((Aluno) usuario);
			} else if (usuario instanceof Professor) {
				profDAO.update((Professor) usuario);
			}
		}
		projeto.getUsuarios_participantes().clear();

		projeto.setCriador(null);
		
		projeto.getTurmas().clear();
		projDAO.update(projeto);
		
		try {
			Aluno user = alunoDAO.getAlunoById(id_usuario);
			user.getProjetos().remove(projeto);
			alunoDAO.update(user);
		} catch (Exception e) {
			Professor user = profDAO.getProfessorById(id_usuario);
			user.getProjetos().remove(projeto);
			profDAO.update(user);
		}
		
		
		projDAO.delete(projeto);
	}
	
	public static void RemoveProjetoTurma(int id_projeto, int id_turma) {
		Projeto projeto = projDAO.getProjetoById(id_projeto);
		Turma turma = turmaDAO.getTurmaById(id_turma);
		
		System.out.println("\n\nA turma tem o projeto: " + turma.getProjetos().contains(projeto));
		for (Usuario usuario: turma.getUsuarios()) {
			System.out.println("\n\n O usuario: " + usuario.getId() + "possui o projeto - >" + usuario.getProjetos_participantes().contains(projeto));

			if(usuario.getProjetos_participantes().contains(projeto)){
				usuario.getProjetos_participantes().remove(projeto);

				if (usuario instanceof Aluno) {
					alunoDAO.update((Aluno) usuario);
				} else if (usuario instanceof Professor) {
					profDAO.update((Professor) usuario);
				}
				
				projeto.getUsuarios_participantes().remove(usuario);
				projDAO.update(projeto);
			}
		}
		
		turma.getProjetos().remove(projeto);
		turmaDAO.update(turma);
		
		projeto.getTurmas().remove(turma);
		projDAO.update(projeto);
	}
	
	public static void RemoveUsuarioTurma(int id_participante, int id_turma ) {
		
		
		System.out.println("\n\n AQUi 1!");
		try {
			Usuario user = alunoDAO.getAlunoById(id_participante);
			System.out.println("\n\n AQUi 2!");
			
			System.out.println("\n\n AQUi 3!");
			Turma turma = turmaDAO.getTurmaById(id_turma);
			
			System.out.println("\n\n AQUi 4!");
			System.out.println("\n\n\nA turma tem o usuario: " + turma.getUsuarios().contains(user));
			System.out.println("\n\n\n Turma usuarios ->" +turma.getUsuarios().size());
			
			for (Projeto projeto : turma.getProjetos()) {
				System.out.println("\n\n O projeto: " + projeto.getId() + "possui o usuario - >" + projeto.getUsuarios_participantes().contains(user));

				if (projeto.getUsuarios_participantes().contains(user)) {
					System.out.println("\n\n AQUi 5!");
					projeto.getUsuarios_participantes().remove(user);
					projDAO.update(projeto);
					
					user.getProjetos_participantes().remove(projeto);
					
					if (user instanceof Aluno) {
						alunoDAO.update((Aluno) user);
						System.out.println("\n\n AQUi 6!");
					} else if (user instanceof Professor) {
						profDAO.update((Professor) user);
						System.out.println("\n\n AQUi 7!");
					}
				}
			}

			System.out.println("Cheguei aqui! 8\n\n\n");
			turma.getUsuarios().remove(user);
			System.out.println("Cheguei aqui 9!\n\n\n");
			turmaDAO.update(turma);
			System.out.println("Cheguei aqui 10!\n\n\n");
			
			user.getTurmas().remove(turma);
			System.out.println("Cheguei aqui 11!\n\n\n");
			
				alunoDAO.update((Aluno) user);
			System.out.println("Cheguei aqui 12!\n\n\n");
		} catch (Exception e) {
			Usuario user = profDAO.getProfessorById(id_participante);
			System.out.println("\n\n AQUi 2!");
			
			System.out.println("\n\n AQUi 3!");
			Turma turma = turmaDAO.getTurmaById(id_turma);
			
			System.out.println("\n\n\n Turma usuarios ->" +turma.getUsuarios().size());
			
			for (Usuario usuario : turma.getUsuarios()) {
				System.out.println();
			}
			
			for (Projeto projeto : turma.getProjetos()) {
				System.out.println("\n\n O projeto: " + projeto.getId() + "possui o usuario - >" + projeto.getUsuarios_participantes().contains(user));

				if (projeto.getUsuarios_participantes().contains(user)) {
					System.out.println("\n\n AQUi 5!");
					projeto.getUsuarios_participantes().remove(user);
					projDAO.update(projeto);
					
					user.getProjetos_participantes().remove(projeto);
					
						profDAO.update((Professor) user);
						System.out.println("\n\n AQUi 7!");
				}
			}

			System.out.println("Cheguei aqui! 8\n\n\n");
			turma.getUsuarios().remove(user);
			System.out.println("Cheguei aqui 9!\n\n\n");
			turmaDAO.update(turma);
			System.out.println("Cheguei aqui 10!\n\n\n");
			
			user.getTurmas().remove(turma);
			System.out.println("Cheguei aqui 11!\n\n\n");
			
			if (user instanceof Aluno) {
				alunoDAO.update((Aluno) user);
			} else if (user instanceof Professor) {
				profDAO.update((Professor) user);
			}
			System.out.println("Cheguei aqui 12!\n\n\n");
		}
		
		
	}

	public static void main(String[] args) {
		Projeto proj = new Projeto();
		Aluno aluno = new Aluno();
		Turma turma = new Turma();
		Professor prof = new Professor();

//		 AdicionarAlunos(10);
//		 AdicionarProfessores(10);
//		 AdicionarPeojetos(4);
//		 adicionarRequisitoProjeto(8);

		// Adicionar criadorr a um projeto
//		 aluno = alunoDAO.getAlunoById(1);
////		 prof = profDAO.getProfessorById(11);
//		 proj = projDAO.getProjetoById(31);
//		 AdicionarCriadoProjeto(aluno, proj);

//		 AdicionarUsuarioProjeto
//		for (int i = 376; i <= 381; i++) {
//			aluno = alunoDAO.getAlunoById(i);
//			prof = profDAO.getProfessorById(11);
//			proj = projDAO.getProjetoById(i);
//			AdicionarUsuarioProjeto(prof, proj);
//		}

		
//		prof = profDAO.getProfessorById();
//		aluno = alunoDAO.getAlunoById(1);
//		proj = projDAO.getProjetoById(32);
//		AdicionarUsuarioProjeto(aluno, proj);
		
//		 RemoveProjeto(22, 11);
//		RemoveProjetoTurma(0,0);
//		 RemoveUsuarioTurma(13,709);
		
		// Adicionar Turmas
//		 AdicionarTurmas(5);

		// Adicionar professor em turma
//		 prof = profDAO.getProfessorById(11);
//		 turma = turmaDAO.getTurmaById(326);
//		 AdicionarProfessorTurma(prof, turma);

		//
		// Adicionar projeto numa turma
//		for (int i = 26; i <= 32; i++) {
//			proj = projDAO.getProjetoById(i);
//			turma = turmaDAO.getTurmaById(326);
//			AdicionarProjetoTurma(proj, turma);
//		}

		// adicionar akluno a uma turma
//		for (int i = 11; i <= 14; i++) {
//			aluno = alunoDAO.getAlunoById(i);
//			prof = profDAO.getProfessorById(i);
//			turma = turmaDAO.getTurmaById(326);
//			AdicionarUsuarioTurma(prof, turma);
//		}

//		aluno = alunoDAO.getAlunoById(5);
//		prof = profDAO.getProfessorById(13);
//		turma = turmaDAO.getTurmaById(712);
//		AdicionarUsuarioTurma(aluno, turma);
//		System.out.println("Temrinou!");
	}

}
