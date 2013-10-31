package br.ufc.si.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int Id;

	@Column(name = "Nome", nullable = false, length = 100)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "Professor_Responsavel")
	private Professor responsavel;

	@Column(name = "Descricao", nullable = false, length = 1000)
	private String Descricao;

	@ManyToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "Turma_Projeto", joinColumns = @JoinColumn(name = "Turma_id"), inverseJoinColumns = @JoinColumn(name = "Projeto_id"))
	List<Projeto> projetos;

	@ManyToMany(cascade = CascadeType.ALL)
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

}
