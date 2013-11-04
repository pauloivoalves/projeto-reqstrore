package br.ufc.si.Interfaces;

import java.util.List;

import br.ufc.si.Tipos.TipoProjeto;
import br.ufc.si.model.Projeto;
import br.ufc.si.model.Usuario;

public interface IProjeto {

	public void save(Projeto projeto);

	public void update(Projeto projeto);

	public void delete(Projeto projeto);

	public List<Projeto> List();

	public List<Projeto> SearchByName(String name);
	
	public Projeto getProjetoById(int id);

	public List<Projeto> BuscaDificuldadeTipo(int dificuldade, TipoProjeto tipo);

	List<Projeto> MeusProjetos(Usuario user);
}
