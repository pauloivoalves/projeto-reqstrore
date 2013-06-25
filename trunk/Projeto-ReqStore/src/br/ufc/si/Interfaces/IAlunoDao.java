package br.ufc.si.Interfaces;

import java.util.List;

import br.ufc.si.model.Aluno;

public interface IAlunoDao {

	public void save(Aluno aluno);

	public void update(Aluno aluno);

	public void delete(Aluno aluno);

	public List<Aluno> List();

	public List<Aluno> SearchByName(String name);

}
