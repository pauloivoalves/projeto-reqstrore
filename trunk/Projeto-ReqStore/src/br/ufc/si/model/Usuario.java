package br.ufc.si.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;

	@Column(name = "Nome", nullable = false, length = 60)
	private String nome;

	@Column(name = "Email", nullable = false, length = 40)
	private String email;

	@Column(name = "Senha", nullable = false, length = 10)
	private String senha;

	@Column(name = "Confirmado", nullable = false)
	private boolean confirmado;

	@Column(name = "Confirmacao", nullable = false)
	private int numero;

	@ManyToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "Usuario_Projeto", joinColumns = @JoinColumn(name = "Usuario_id"), inverseJoinColumns = @JoinColumn(name = "Projeto_id"))
	private List<Projeto> projetos_participantes;

	@OneToMany(mappedBy = "criador")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Projeto> projetos;

	@ManyToMany(mappedBy = "usuarios")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Turma> turmas;

	/* Getter and Setters */
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public List<Projeto> getProjetos_participantes() {
		return projetos_participantes;
	}

	public void setProjetos_participantes(List<Projeto> projetos_participantes) {
		this.projetos_participantes = projetos_participantes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + (confirmado ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numero;
		result = prime * result
				+ ((projetos == null) ? 0 : projetos.hashCode());
		result = prime
				* result
				+ ((projetos_participantes == null) ? 0
						: projetos_participantes.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((turmas == null) ? 0 : turmas.hashCode());
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
		Usuario other = (Usuario) obj;
		if (Id != other.Id)
			return false;
		if (confirmado != other.confirmado)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero != other.numero)
			return false;
		if (projetos == null) {
			if (other.projetos != null)
				return false;
		} else if (!projetos.equals(other.projetos))
			return false;
		if (projetos_participantes == null) {
			if (other.projetos_participantes != null)
				return false;
		} else if (!projetos_participantes.equals(other.projetos_participantes))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (turmas == null) {
			if (other.turmas != null)
				return false;
		} else if (!turmas.equals(other.turmas))
			return false;
		return true;
	}

}
