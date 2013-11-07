package br.ufc.si.Controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.ufc.si.DAO.AlunoDAO;
import br.ufc.si.DAO.ProfessorDAO;
import br.ufc.si.DAO.ProjetoDAO;
import br.ufc.si.DAO.TurmaDAO;
import br.ufc.si.Interfaces.IAluno;
import br.ufc.si.Interfaces.IProfessor;
import br.ufc.si.Interfaces.IProjeto;
import br.ufc.si.Interfaces.ITurma;
import br.ufc.si.model.Aluno;
import br.ufc.si.model.Professor;
import br.ufc.si.model.Projeto;
import br.ufc.si.model.Turma;
import br.ufc.si.model.Usuario;

@Resource
public class TurmaController {

	private final ITurma turmaDAO;
	private final Result result;
	private final IAluno alunoDAO;
	private final IProfessor profDAO;
	private final IProjeto projDAO;

	public TurmaController(TurmaDAO turmaDAO, Result result, AlunoDAO alunoDAO,
			ProfessorDAO profDAO, ProjetoDAO projDAO) {
		super();
		this.turmaDAO = turmaDAO;
		this.result = result;
		this.alunoDAO = alunoDAO;
		this.profDAO = profDAO;
		this.projDAO = projDAO;
	}

	@Post("/Turma/AdicionaTurma")
	public void AdicionaTurma(Turma turma, int id_usuario) {
		Professor prof = profDAO.getProfessorById(id_usuario);
		
		turma.setResponsavel(prof);
		this.turmaDAO.save(turma);

		List<Turma> turmas = prof.getTurmas();
		turmas.add(turma);
		prof.setTurmas(turmas);
		profDAO.update(prof);
		
		result.redirectTo(this).MinhasTurmas(id_usuario);
	}
	
	@Path("/Turma/TurmaForm")
	public void TurmaForm() {
		
	}

	@Path("/Turma/removeTurma")
	public void RemoverTurma(Turma turma) {
		this.turmaDAO.delete(turma);
	}

	@Path("/Turma/updateTurma")
	public void AtualizaTurma(Turma turma) {
		this.turmaDAO.update(turma);
		result.redirectTo(this.ListarTurmas());
	}

	@Path("/Turma/busca/{turma.Id}")
	public Turma BuscaTurmaPorId(Turma turma) {
		return this.turmaDAO.getTurmaById(turma.getId());
	}

	@Path("/Turma/DetalhesTurma")
	public Turma DetalhesTurma(int id) {
		return this.turmaDAO.getTurmaById(id);
	}

	@Path("/Turma/lista")
	public List<Turma> ListarTurmas() {
		return this.turmaDAO.List();
	}

	@Path("/Turma/busca/{nome}")
	public List<Turma> BuscarTurmaPorNome(String nome) {
		return this.turmaDAO.SearchByName(nome);
	}

	@Get("/Turma/MinhasTurmas")
	public List<Turma> MinhasTurmas(int id) {
		System.out.println("Id - " + id);
		Usuario usuario = new Usuario();
		usuario.setId(id);
		return turmaDAO.MinhasTurmas(usuario);
	}

	@Path("/Turma/RemoverTurma")
	public void RemoverTurma(int id_turma, int id_usuario) {
		System.out.println("Usuario : " + id_usuario);

		Turma turma = turmaDAO.getTurmaById(id_turma);
		for (Usuario usuario : turma.getUsuarios()) {
			usuario.getTurmas().remove(turma);

			if (usuario instanceof Aluno) {
				alunoDAO.update((Aluno) usuario);
			} else if (usuario instanceof Professor) {
				profDAO.update((Professor) usuario);
			}
		}
		turma.getUsuarios().clear();
		turma.setResponsavel(null);

		for (Projeto proj : turma.getProjetos()) {
			proj.getTurmas().remove(turma);
			projDAO.update(proj);
		}
		turmaDAO.update(turma);

		try {
			Aluno user = alunoDAO.getAlunoById(id_usuario);
			user.getTurmas().remove(turma);
			alunoDAO.update(user);
		} catch (Exception e) {
			Professor user = profDAO.getProfessorById(id_usuario);
			user.getTurmas().remove(turma);
			profDAO.update(user);
		}

		this.turmaDAO.delete(turma);
		result.redirectTo(this).MinhasTurmas(id_usuario);
	}
	
	@Path("/Turma/RemoveUsuarioTurma")
	public void RemoveUsuarioTurma(int id_participante, int id_turma, int id_usuario) {
		Usuario user;
		
		System.out.println("\n\n AQUi 1!");
		try {
			user = this.alunoDAO.getAlunoById(id_participante);
			System.out.println("\n\n AQUi 2!");
		} catch (Exception e) {
			user = this.profDAO.getProfessorById(id_participante);
			System.out.println("\n\n AQUi 3!");
		}
		
		System.out.println("\n\n AQUi 4!");
		Turma turma = this.turmaDAO.getTurmaById(id_turma);
		System.out.println("\n\n AQUi 5!");
		System.out.println("\n\n\nA turma tem o usuario: " + turma.getUsuarios().contains(user));
		for (Projeto projeto : turma.getProjetos()) {
			System.out.println("\n\n O projeto: " + projeto.getId() + "possui o usuario - >" + projeto.getUsuarios_participantes().contains(user));

			if (projeto.getUsuarios_participantes().contains(user)) {
				System.out.println("\n\n AQUi 6!");
				projeto.getUsuarios_participantes().remove(user);
				this.projDAO.update(projeto);
				
				user.getProjetos_participantes().remove(projeto);
				
				if (user instanceof Aluno) {
					this.alunoDAO.update((Aluno) user);
					System.out.println("\n\n AQUi 7!");
				} else if (user instanceof Professor) {
					this.profDAO.update((Professor) user);
					System.out.println("\n\n AQUi 8!");
				}
			}
		}

		System.out.println("Cheguei aqui!\n\n\n");
		turma.getUsuarios().remove(user);
		System.out.println("Cheguei aqui 2!\n\n\n");
		this.turmaDAO.update(turma);
		System.out.println("Cheguei aqui 3!\n\n\n");
		
		user.getTurmas().remove(turma);
		System.out.println("Cheguei aqui 4!\n\n\n");
		
		if (user instanceof Aluno) {
			this.alunoDAO.update((Aluno) user);
		} else if (user instanceof Professor) {
			this.profDAO.update((Professor) user);
		}
		System.out.println("Cheguei aqui 5!\n\n\n");
		result.redirectTo(TurmaController.class).DetalhesTurma(id_turma);
	}
}
