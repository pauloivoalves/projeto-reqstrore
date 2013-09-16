package br.ufc.si.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.ufc.si.Tipos.PrioridadeRequisito;
import br.ufc.si.Tipos.TipoRequisito;

@Entity
public class Requisito {
	@Id
	@GeneratedValue
	private int Id;

	@ManyToOne
	@JoinColumn(name = "Id_Projeto")
	private Projeto projeto;

	@Column(name = "Tipo_Requisito", nullable = false)
	private TipoRequisito tipoRequisito;

	@Column(name = "Descricao_Requisio", nullable = false, length = 600)
	private String descricao;

	@Column(name = "Foco_Requisio", nullable = false, length = 600)
	private String foco_requisito;

	@Column(name = "Prioridade_Requisito", nullable = false)
	private PrioridadeRequisito prioridadeRequisito;

	@OneToMany(mappedBy = "idRequisito", fetch = FetchType.EAGER)
	private List<VersaoRequisito> versoesRequisito;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public TipoRequisito getTipoRequisito() {
		return tipoRequisito;
	}

	public void setTipoRequisito(TipoRequisito tipoRequisito) {
		this.tipoRequisito = tipoRequisito;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public PrioridadeRequisito getPrioridadeRequisito() {
		return prioridadeRequisito;
	}

	public void setPrioridadeRequisito(PrioridadeRequisito prioridadeRequisito) {
		this.prioridadeRequisito = prioridadeRequisito;
	}

	public List<VersaoRequisito> getVersoesRequisito() {
		return versoesRequisito;
	}

	public void setVersoesRequisito(List<VersaoRequisito> versoesRequisito) {
		this.versoesRequisito = versoesRequisito;
	}

	public String getFoco_requisito() {
		return foco_requisito;
	}

	public void setFoco_requisito(String foco_requisito) {
		this.foco_requisito = foco_requisito;
	}

}
