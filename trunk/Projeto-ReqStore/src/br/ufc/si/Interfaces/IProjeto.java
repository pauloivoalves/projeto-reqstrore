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

	public Projeto getProjetoById(int id);

	public List<Projeto> MeusProjetos(Usuario user);

	public List<Projeto> BuscaDificuldadeTipo(int id_usuario, int dificuldade, TipoProjeto tipo);

	List<Projeto> SearchByName(int id_usuario, String name);
}
