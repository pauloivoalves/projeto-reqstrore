package br.ufc.si.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Turma {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int Id;

	@Column(name = "Nome", nullable = false, length = 100)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "Professor_Responsavel")
	private Professor responsavel;

	@Column(name = "Descricao", nullable = false, length = 1000)
	private String Descricao;

	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "Turma_Projeto", joinColumns = @JoinColumn(name = "Turma_id"), inverseJoinColumns = @JoinColumn(name = "Projeto_id"))
	List<Projeto> projetos;

	@ManyToMany()
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "Turma_Usuario", joinColumns = @JoinColumn(name = "Turma_id"), inverseJoinColumns = @JoinColumn(name = "Usuario_id"))
	List<Usuario> usuarios;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public Professor getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Professor responsavel) {
		this.responsavel = responsavel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Descricao == null) ? 0 : Descricao.hashCode());
		result = prime * result + Id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((projetos == null) ? 0 : projetos.hashCode());
		result = prime * result
				+ ((responsavel == null) ? 0 : responsavel.hashCode());
		result = prime * result
				+ ((usuarios == null) ? 0 : usuarios.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		if (Descricao == null) {
			if (other.Descricao != null)
				return false;
		} else if (!Descricao.equals(other.Descricao))
			return false;
		if (Id != other.Id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (projetos == null) {
			if (other.projetos != null)
				return false;
		} else if (!projetos.equals(other.projetos))
			return false;
		if (responsavel == null) {
			if (other.responsavel != null)
				return false;
		} else if (!responsavel.equals(other.responsavel))
			return false;
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		return true;
	}

}
