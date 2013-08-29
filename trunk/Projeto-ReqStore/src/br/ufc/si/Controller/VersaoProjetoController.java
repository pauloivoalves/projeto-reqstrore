package br.ufc.si.Controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.ufc.si.DAO.VersaoProjetoDAO;
import br.ufc.si.Interfaces.IVersaoProjeto;
import br.ufc.si.model.Projeto;
import br.ufc.si.model.VersaoProjeto;

@Resource
public class VersaoProjetoController {
	private final IVersaoProjeto versaoDAO;

	public VersaoProjetoController(VersaoProjetoDAO versaoDAO) {
		super();
		this.versaoDAO = versaoDAO;
	}

	@Path("/VersaoProjeto/novo")
	public void AdicionaVersaoProjeto(VersaoProjeto versao) {
		this.versaoDAO.save(versao);
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
