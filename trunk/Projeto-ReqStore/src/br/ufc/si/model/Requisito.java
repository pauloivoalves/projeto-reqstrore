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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import br.ufc.si.Tipos.PrioridadeRequisito;
import br.ufc.si.Tipos.TipoRequisito;

@Entity
public class Requisito {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "idRequisito")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((foco_requisito == null) ? 0 : foco_requisito.hashCode());
		result = prime
				* result
				+ ((prioridadeRequisito == null) ? 0 : prioridadeRequisito
						.hashCode());
		result = prime * result + ((projeto == null) ? 0 : projeto.hashCode());
		result = prime * result
				+ ((tipoRequisito == null) ? 0 : tipoRequisito.hashCode());
		result = prime
				* result
				+ ((versoesRequisito == null) ? 0 : versoesRequisito.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (getClass() != obj.getClass())
			return false;
		Requisito other = (Requisito) obj;
		if (Id == other.Id)
			return true;
		
		return false;
	}

}
