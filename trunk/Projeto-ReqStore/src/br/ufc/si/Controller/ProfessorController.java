package br.ufc.si.Controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.ufc.si.DAO.ProfessorDAO;
import br.ufc.si.Interfaces.IProfessor;
import br.ufc.si.model.Professor;

@Resource
public class ProfessorController {
	private final IProfessor professorDAO;
	private final Result result;

	public ProfessorController(ProfessorDAO professor, Result result) {
		super();
		this.professorDAO = professor;
		this.result = result;
	}
	
	@Path("/Professor/ProfessorHome")
	public void ProfessorHome(){
		
	}

	@Path("/Professor/novo")
	public void AdicionaProfessor(Professor professor) {
		this.professorDAO.save(professor);
		result.redirectTo(this.ListaProfessores());
	}

	@Path("/Professor/remove")
	public void RemoveProfessor(Professor professor) {
		this.professorDAO.delete(professor);
	}

	@Path("/Professor/update")
	public void AtualizaProfessor(Professor professor) {
		this.professorDAO.update(professor);
	}

	@Path("/Professor/busca/{professor.Id}")
	public Professor BuscaProfessorPorId(Professor professor) {
		return this.professorDAO.getProfessorById(professor.getId());
	}

	@Path("/Professor/lista")
	public List<Professor> ListaProfessores() {
		return this.professorDAO.List();
	}

	@Path("/Professor/busca/{nome}")
	public List<Professor> BuscaProfessorPorNome(String nome) {
		return this.professorDAO.SearchByName(nome);
	}
}
