package br.ufc.si.Controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.ufc.si.DAO.VersaoProjetoDAO;
import br.ufc.si.Interfaces.IVersaoProjeto;
import br.ufc.si.model.Projeto;
import br.ufc.si.model.VersaoProjeto;

@Resource
public class VersaoProjetoController {
	private final IVersaoProjeto versaoDAO;
	Result result;

	public VersaoProjetoController(VersaoProjetoDAO versaoDAO, Result result) {
		super();
		this.versaoDAO = versaoDAO;
		this.result = result;
	}

	@Path("/VersaoProjeto/novo")
	public void AdicionaVersaoProjeto(VersaoProjeto versao) {
		this.versaoDAO.save(versao);
		result.redirectTo(this.ListaProjetos(versao.getIdProjeto()));
	}

	@Path("/VersaoProjeto/remove")
	public void RemoveVersaoProjeto(VersaoProjeto versao) {
		this.versaoDAO.delete(versao);
	}

	@Path("/VersaoProjeto/update")
	public void AtualizaVersaoProjeto(VersaoProjeto versao) {
		this.versaoDAO.update(versao);
	}

	@Path("/VersaoProjeto/busca/{versao.id}")
	public VersaoProjeto BuscaVersaoPorId(VersaoProjeto versao) {
		return this.versaoDAO.getVersaoById(versao.getId());
	}

	@Path("/VersaoProjeto/lista/{projeto.id}")
	public List<VersaoProjeto> ListaProjetos(Projeto projeto) {
		return this.versaoDAO.List(projeto);
	}
}
