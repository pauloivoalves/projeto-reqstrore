package br.ufc.si.Interfaces;

import java.util.List;

import br.ufc.si.model.Projeto;
import br.ufc.si.model.Requisito;

public interface IRequisito {
	public void save(Requisito requisito);

	public void update(Requisito requisito);

	public void delete(Requisito requisito);

	public Requisito getRequisitoById(int id);

	public List<Requisito> List(Projeto projeto);

}
