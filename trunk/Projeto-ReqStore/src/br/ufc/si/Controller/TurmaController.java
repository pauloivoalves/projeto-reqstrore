package br.ufc.si.Controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.ufc.si.DAO.TurmaDAO;
import br.ufc.si.Interfaces.ITurma;
import br.ufc.si.model.Turma;
import br.ufc.si.util.AutorizacaoInterceptor.Liberado;

@Resource
public class TurmaController {

	private final ITurma turmaDAO;
	private final Result result;

	public TurmaController(TurmaDAO turmaDAO, Result result) {
		super();
		this.turmaDAO = turmaDAO;
		this.result = result;
	}

	@Post("/Turma/novo")
	public void AdicionaTurma(Turma turma) {
		this.turmaDAO.save(turma);
		result.redirectTo(this.ListarTurmas());
	}

	@Path("/Turma/remove")
	public void RemoverTurma(Turma turma) {
		this.turmaDAO.delete(turma);
	}

	@Path("/Turma/update")
	public void AtualizaTurma(Turma turma) {
		this.turmaDAO.update(turma);
	}

	@Path("/Turma/busca/{turma.Id}")
	public Turma BuscaTurmaPorId(Turma turma) {
		return this.turmaDAO.getTurmaById(turma.getId());
	}

	@Path("/Turma/AdicionaTurma")
	@Liberado
	public void AdicionaTurma() {

	}

	@Path("/Turma/lista")
	public List<Turma> ListarTurmas() {
		return this.turmaDAO.List();
	}

	@Path("/Turma/busca/{nome}")
	public List<Turma> BuscarTurmaPorNome(String nome) {
		return this.turmaDAO.SearchByName(nome);
	}
}