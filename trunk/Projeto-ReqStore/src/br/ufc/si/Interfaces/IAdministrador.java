package br.ufc.si.Interfaces;

import java.util.List;

import br.ufc.si.model.Administrador;

public interface IAdministrador {
	
	public void save(Administrador admin);

	public void update(Administrador admin);

	public void delete(Administrador admin);

	public List<Administrador> List();

	public List<Administrador> SearchByName(String name);

	public Administrador getAdministradorById(Integer id);
}
