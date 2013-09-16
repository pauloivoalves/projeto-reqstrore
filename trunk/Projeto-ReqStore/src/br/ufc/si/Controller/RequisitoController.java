package br.ufc.si.Controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.ufc.si.DAO.RequisitoDAO;
import br.ufc.si.Interfaces.IRequisito;
import br.ufc.si.model.Projeto;
import br.ufc.si.model.Requisito;

@Resource
public class RequisitoController {
	private final IRequisito requisitoDAO;

	public RequisitoController(RequisitoDAO requisitoDAO) {
		super();
		this.requisitoDAO = requisitoDAO;
	}

	@Path("/Requisito/novo")
	public void AdicionaRequisito(Requisito requisito) {
		this.requisitoDAO.save(requisito);
	}

	@Path("/Requisito/remove")
	public void RemoveRequisito(Requisito requisito) {
		this.requisitoDAO.delete(requisito);
	}

	@Path("/Requisito/update")
	public void AtualizaRequisito(Requisito requisito) {
		this.requisitoDAO.update(requisito);
	}

	@Path("/Requisito/busca/{requisito.Id}")
	public Requisito BuscaRequisitoPorId(Requisito requisito) {
		return this.requisitoDAO.getRequisitoById(requisito.getId());
	}

	@Path("/Requisito/lista/{projeto.Id}")
	public List<Requisito> ListaRequisitos(Projeto projeto) {
		return this.requisitoDAO.List(projeto);
	}
	
	
	@Path("/Requisito/DetalhesRequisito")
	public Requisito DetalhesRequisito(int id){
		return requisitoDAO.getRequisitoById(id);
	}

}
