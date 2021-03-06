package br.ufc.si.Interfaces;

import java.util.List;

import br.ufc.si.model.Requisito;
import br.ufc.si.model.VersaoRequisito;

public interface IVersaoRequisito {

	public void save(VersaoRequisito versao);

	public void update(VersaoRequisito versao);

	public void delete(VersaoRequisito versao);

	public VersaoRequisito SearchById(int id);

	public List<VersaoRequisito> List(Requisito requisito);
}
