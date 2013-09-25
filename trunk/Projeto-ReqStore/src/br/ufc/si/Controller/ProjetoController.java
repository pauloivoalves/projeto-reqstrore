package br.ufc.si.Controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;

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
	
	@Path("/Projeto/busca")
	public void Busca(){
		
	}

	@Path("/Projeto/lista")
	public List<Projeto> ListaProjetos() {
		return this.projetoDAO.List();
	}
	
	@Path("/Projeto/buscaFiltrada")
	public List<Projeto> BuscaFiltrada(int dificuldade, TipoProjeto tipo,  int numReq, String nome){
		IProjeto dao = new ProjetoDAO(); 
		List<Projeto> projetos  = dao.BuscaDificuldadeTipo(dificuldade,  tipo);
		
		if((numReq > 0) && (!nome.equalsIgnoreCase(""))){
			List<Projeto> list = new ArrayList<Projeto>();
			
			for (Projeto projeto : projetos) {
				Hibernate.initialize(projeto.getRequisitos());

				if((projeto.getNome().equals(nome)) && (projeto.getRequisitos().size() <= numReq)){
					list.add(projeto);
				}
			}
			return list;

		}else if(!nome.equalsIgnoreCase("")){

			List<Projeto> list = new ArrayList<Projeto>();
			
			for (Projeto projeto : projetos) {
				Hibernate.initialize(projeto.getRequisitos());
				
				if((projeto.getNome().equals(nome))){
					list.add(projeto);
				}
			}
			return list;
			
		}else if(numReq > 0){
			List<Projeto> list = new ArrayList<Projeto>();
			
			for (Projeto projeto : projetos) {
				Hibernate.initialize(projeto.getRequisitos());
				
				if(projeto.getRequisitos().size() <= numReq){
					list.add(projeto);
				}
			}
			return list;
		}
		return projetos;
	}
}
