package br.ufc.si.Controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.ufc.si.DAO.VersaoRequisitoDAO;
import br.ufc.si.Interfaces.IVersaoRequisito;
import br.ufc.si.model.Requisito;
import br.ufc.si.model.VersaoRequisito;

@Resource
public class VersaoRequisitoController {
	private final IVersaoRequisito requisitoDAO;

	public VersaoRequisitoController(VersaoRequisitoDAO requisitoDAO) {
		super();
		this.requisitoDAO = requisitoDAO;
	}

	@Path("/VersaoRequisito/novo")
	public void AdicionaVersaoRequisito(VersaoRequisito requisito) {
		this.requisitoDAO.save(requisito);
	}

	@Path("/VersaoRequisito/remove")
	public void RemoveVersaoRequisito(VersaoRequisito requisito) {
		this.requisitoDAO.delete(requisito);
	}

	@Path("/VersaoRequisito/update")
	public void AtualizaVersaoRequisito(VersaoRequisito requisito) {
		this.requisitoDAO.update(requisito);
	}

	@Path("/VersaoRequisito/busca/{requisito.id}")
	public VersaoRequisito BuscaVersaoPorId(Requisito requisito) {
		return this.requisitoDAO.SearchById(requisito.getId());
	}

	@Path("/VersaoRequisito/lista/{requisito.Id}")
	public List<VersaoRequisito> ListaVersoesRequisito(Requisito requisito) {
		return this.requisitoDAO.List(requisito);
	}
}
