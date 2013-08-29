package br.ufc.si.Controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.ufc.si.DAO.AdministradorDAO;
import br.ufc.si.Interfaces.IAdministrador;
import br.ufc.si.model.Administrador;

@Resource
public class AdministradorController {
	private final IAdministrador adminDAO;
	private final Result result;

	public AdministradorController(AdministradorDAO admin, Result result) {
		super();
		this.adminDAO = admin;
		this.result = result;
	}

	@Path("/Administrador/novo")
	public void AdicionaAdministrador(Administrador admin) {
		this.adminDAO.save(admin);
		result.redirectTo(this.ListaAdministradores());
	}

	@Path("/Administrador/remove")
	public void RemoveAdministrador(Administrador admin) {
		this.adminDAO.delete(admin);
	}

	@Path("/Administrador/update")
	public void AtualizaAdministrador(Administrador admin) {
		this.adminDAO.update(admin);
	}

	@Path("/Administrador/busca/{admin.Id}")
	public Administrador BuscaAdministradorPorId(Administrador admin) {
		return this.adminDAO.getAdministradorById(admin.getId());
	}

	@Path("/Administrador/lista")
	public List<Administrador> ListaAdministradores() {
		return this.adminDAO.List();
	}

	@Path("/Administrador/busca/{nome}")
	public List<Administrador> BuscaAdministradorPorNome(String nome) {
		return this.adminDAO.SearchByName(nome);
	}
}
