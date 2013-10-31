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

}
