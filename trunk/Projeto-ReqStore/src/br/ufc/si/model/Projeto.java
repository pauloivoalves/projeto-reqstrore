package br.ufc.si.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.ufc.si.Tipos.TipoProjeto;

@Entity
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;

	@Column(name = "Nome_Projeto", nullable = false, length = 30)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "Criador")
	private Usuario criador;

	@Column(name = "Tipo_Projeto", nullable = false)
	private TipoProjeto tipoProjeto;

	@Column(name = "Descricao_Projeto", nullable = false, length = 1000)
	private String descricao;

	@Column(name = "Foco_Projeto", nullable = false, length = 1000)
	private String Foco_projeto;

	@Column(name = "Pontuacao", nullable = false)
	private int pontuacao;

	@OneToMany(mappedBy = "projeto")
	private List<Requisito> requisitos;

	@OneToMany(mappedBy = "idProjeto")
	private List<VersaoProjeto> versoesProjeto;

	public int getId() {
		return Id;
	}

	public Usuario getCriador() {
		return criador;
	}

	public void setCriador(Usuario criador) {
		this.criador = criador;
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

	public String getFoco_projeto() {
		return Foco_projeto;
	}

	public void setFoco_projeto(String foco_projeto) {
		Foco_projeto = foco_projeto;
	}

	public TipoProjeto getTipoProjeto() {
		return tipoProjeto;
	}

	public void setTipoProjeto(TipoProjeto tipoProjeto) {
		this.tipoProjeto = tipoProjeto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public List<Requisito> getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(List<Requisito> requisitos) {
		this.requisitos = requisitos;
	}

	public List<VersaoProjeto> getVersoesProjeto() {
		return versoesProjeto;
	}

	public void setVersoesProjeto(List<VersaoProjeto> versoesProjeto) {
		this.versoesProjeto = versoesProjeto;
	}

}
