package br.ufc.si.Controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.ufc.si.DAO.ProjetoDAO;
import br.ufc.si.DAO.RequisitoDAO;
import br.ufc.si.Interfaces.IProjeto;
import br.ufc.si.Interfaces.IRequisito;
import br.ufc.si.model.Projeto;
import br.ufc.si.model.Requisito;

@Resource
public class RequisitoController {
	private final IRequisito requisitoDAO;
	private final Result result;
	private final IProjeto projetoDAO;

	

	public RequisitoController(RequisitoDAO requisitoDAO, Result result,
			ProjetoDAO projetoDAO) {
		super();
		this.requisitoDAO = requisitoDAO;
		this.result = result;
		this.projetoDAO = projetoDAO;
	}

	@Path("/Requisito/NovoRequisito")
	public Projeto NovoRequisito(int id_projeto){
		return projetoDAO.getProjetoById(id_projeto);
	}
	
	@Path("/Requisito/AdicionaRequisito")
	public void AdicionaRequisito(Requisito requisito, int id_projeto) {
		try {
			Projeto proj = projetoDAO.getProjetoById(id_projeto);
			requisito.setProjeto(proj);
			this.requisitoDAO.save(requisito);
			result.redirectTo(ProjetoController.class).Detalhes(id_projeto);
		} catch (Exception e) {
			result.redirectTo(ProjetoController.class).Detalhes(id_projeto);
		}
		
		
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
