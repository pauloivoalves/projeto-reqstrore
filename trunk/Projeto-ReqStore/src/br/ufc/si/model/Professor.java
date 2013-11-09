package br.ufc.si.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Professor extends Usuario {

	@OneToMany(mappedBy = "responsavel")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Turma> turmas_proprietarias;

	public List<Turma> getTurmas_proprietarias() {
		return turmas_proprietarias;
	}

	public void setTurmas_proprietarias(List<Turma> turmas_proprietarias) {
		this.turmas_proprietarias = turmas_proprietarias;
	}

}
