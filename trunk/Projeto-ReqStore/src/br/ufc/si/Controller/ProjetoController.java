package br.ufc.si.Controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.ufc.si.DAO.ProjetoDAO;
import br.ufc.si.Interfaces.IProjeto;
import br.ufc.si.model.Projeto;
import br.ufc.si.model.Requisito;
import br.ufc.si.model.VersaoProjeto;

public class ProjetoController {
	private final IProjeto projetoDAO;
	private final Result result;

	public ProjetoController(ProjetoDAO projetoDAO, Result result) {
		super();
		this.projetoDAO = projetoDAO;
		this.result = result;
	}

	@Path("/Projeto/novo")
	public void AdicionaProjeto(Projeto projeto) {
		this.projetoDAO.save(projeto);
		result.redirectTo(this.ListaProjetos());
	}
	
	@Path("/Projeto/novaVersao")
	public void AdicionaVersao(Projeto projeto, String decricao_versao){
		List<VersaoProjeto> versoes = projeto.getVersoesProjeto();
		
		VersaoProjeto nova_versao = new VersaoProjeto(decricao_versao, projeto);
		versoes.add(nova_versao);
		projeto.setVersoesProjeto(versoes);
		projetoDAO.update(projeto);
				
	}

	@Path("/Projeto/novoRequisito")
	public void AdicionaRequisitoProjeto(Projeto projeto, List<Requisito> requisitos) {
		projeto.setRequisitos(requisitos);
		projetoDAO.update(projeto);
	}

	@Path("/Projeto/remove")
	public void RemoveProjeto(Projeto projeto) {
		this.projetoDAO.delete(projeto);
	}

	@Path("/Projeto/update")
	public void AtualizaProjeto(Projeto projeto) {
		this.projetoDAO.update(projeto);
	}

	@Path("/Projeto/busca/{projeto.Id}")
	public Projeto BuscaProjetoPorId(Projeto projeto) {
		return this.projetoDAO.getProjetoById(projeto.getId());
	}

	@Path("/Projeto/lista")
	public List<Projeto> ListaProjetos() {
		return this.projetoDAO.List();
	}

	@Path("/Projeto/busca/{nome}")
	public List<Projeto> BuscaProjetoPorNome(String nome) {
		return this.projetoDAO.SearchByName(nome);
	}
}
