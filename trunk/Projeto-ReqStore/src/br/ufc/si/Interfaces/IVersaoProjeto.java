package br.ufc.si.Interfaces;

import java.util.List;

import br.ufc.si.model.VersaoProjeto;

public interface IVersaoProjeto {
	public void save(VersaoProjeto versao);

	public void update(VersaoProjeto versao);

	public void delete(VersaoProjeto versao);

	public List<VersaoProjeto> List(String idProjeto);

	public VersaoProjeto SearchById(int id);
}
