package br.ufc.si.Controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.ufc.si.DAO.ProjetoDAO;
import br.ufc.si.Interfaces.IProjeto;
import br.ufc.si.Tipos.TipoProjeto;
import br.ufc.si.model.Projeto;
import br.ufc.si.model.Usuario;

@Resource
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

	@Path("/Projeto/responsavel")
	public void AdicionaResponsavel(Projeto projeto, Usuario usuario) {
		projeto.setCriador(usuario);
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

	@Path("/Projeto/Detalhes")
	public Projeto Detalhes(int id) {
		return this.projetoDAO.getProjetoById(id);
	}
	

	@Path("/Projeto/lista")
	public List<Projeto> ListaProjetos() {
		return this.projetoDAO.List();
	}
	
	@Get("/Projeto/Busca")
	public List<Projeto> Busca(String nomeProjeto, String dificuldadeProjeto, String tipoProjeto) {
		if ((nomeProjeto == null) && (dificuldadeProjeto == null) && (tipoProjeto == null)) {
			
			return null;
			
		} else if ((dificuldadeProjeto != null && tipoProjeto !=null) && nomeProjeto == null){
			
			List<Projeto> projetos = projetoDAO.BuscaDificuldadeTipo(Integer.parseInt(dificuldadeProjeto), TipoProjeto.valueOf(tipoProjeto));
			return projetos;
			
		}else if(dificuldadeProjeto != null && tipoProjeto !=null && nomeProjeto != null){
			List<Projeto> projetos = projetoDAO.SearchByName(nomeProjeto);
			
			if(projetos.size() != 0){
				List<Projeto> listRetorno = new ArrayList<Projeto>();
				
				for (Projeto projeto : projetos) {
					if(projeto.getDificuldade() <= Integer.parseInt(dificuldadeProjeto) && projeto.getTipoProjeto().toString().equals(TipoProjeto.valueOf(tipoProjeto).toString())){
						Hibernate.initialize(projeto);
						listRetorno.add(projeto);
					}
				}
				return listRetorno;
			}
		}
		return null;
	}
	
	@Get("/Projeto/MeusProjetos")
	public List<Projeto> MeusProjetos(int id){
		System.out.println("Id - " + id);
		Usuario usuario = new Usuario();
		usuario.setId(id);
		return projetoDAO.MeusProjetos(usuario);
	}
	
}
