package br.ufc.si.Interfaces;

import java.util.List;

import br.ufc.si.model.Professor;

public interface IProfessor {
	
	public void save(Professor professor);

	public void update(Professor professor);

	public void delete(Professor professor);

	public List<Professor> List();

	public List<Professor> SearchByName(String name);

	public Professor getProfessorById(Integer id);
}
