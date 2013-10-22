package br.ufc.si.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import br.ufc.si.Tipos.TipoProjeto;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Usuario {

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

	@OneToMany(mappedBy = "criador")
	private List<Projeto> projetos;

	public abstract List<Projeto> Buscarprojetos(String nomeProjeto);

	public abstract List<Projeto> ListarProjetos();

	public abstract void SolicitarRestauracaoRequisito(int idRequisito,
			int idProjeto);

	public abstract void SolicitarRestauracaoProjeto(int idProjeto);

	public abstract List<Projeto> BuscarProjetos(String nomeProjeto,
			TipoProjeto tipo, String nomeResponsavel, int dificuldade);

	public abstract List<Usuario> BuscarUsuario(String Nome);

	public abstract void SugerirProjetos(String descricaoProjeto);

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

}
