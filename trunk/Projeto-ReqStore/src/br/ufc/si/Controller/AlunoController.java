package br.ufc.si.Controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.ufc.si.DAO.AlunoDAO;
import br.ufc.si.Interfaces.IAluno;
import br.ufc.si.model.Aluno;

@Resource
public class AlunoController {

	private final IAluno alunoDAO;
	private final Result result;

	public AlunoController(AlunoDAO alunoDAO, Result result) {
		super();
		this.alunoDAO = alunoDAO;
		this.result = result;
	}

	@Path("/Aluno/home")
	public void AlunoHome(){
		
	}
	
	@Path("/Aluno/novo")
	public void AdicionaAluno(Aluno aluno) {
		this.alunoDAO.save(aluno);
		result.redirectTo(this.ListarAlunos());
	}

	@Path("/Aluno/remove")
	public void RemoverAluno(Aluno aluno) {
		this.alunoDAO.delete(aluno);
	}

	@Path("/Aluno/update")
	public void AtualizaAluno(Aluno aluno) {
		this.alunoDAO.update(aluno);
	}

	@Path("/Aluno/busca/{aluno.Id}")
	public Aluno BuscaAlunoPorId(Aluno aluno) {
		return this.alunoDAO.getAlunoById(aluno.getId());
	}

	@Path("/Alunos/lista")
	public List<Aluno> ListarAlunos() {
		return this.alunoDAO.List();
	}

	@Path("/Aluno/busca/{nome}")
	public List<Aluno> BuscarAlunoPorNome(String nome) {
		return this.alunoDAO.SearchByName(nome);
	}

}
