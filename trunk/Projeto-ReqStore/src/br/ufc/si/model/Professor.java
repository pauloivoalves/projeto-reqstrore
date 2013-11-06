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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((turmas_proprietarias == null) ? 0 : turmas_proprietarias
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (turmas_proprietarias == null) {
			if (other.turmas_proprietarias != null)
				return false;
		} else if (!turmas_proprietarias.equals(other.turmas_proprietarias))
			return false;
		return true;
	}

}
