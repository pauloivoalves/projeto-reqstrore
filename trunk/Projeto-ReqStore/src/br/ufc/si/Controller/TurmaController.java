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
}
