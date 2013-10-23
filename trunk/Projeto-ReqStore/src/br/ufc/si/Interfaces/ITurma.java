package br.ufc.si.Interfaces;

import java.util.List;

import br.ufc.si.model.Turma;

public interface ITurma {

	public abstract void save(Turma turma);

	public abstract void delete(Turma turma);

	public abstract void update(Turma turma);

	public abstract Turma getTurmaById(Integer id);

	public abstract List<Turma> List();

	public abstract List<Turma> SearchByName(String name);

}