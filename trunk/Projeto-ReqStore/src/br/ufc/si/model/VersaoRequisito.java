package br.ufc.si.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class VersaoRequisito {
	@Id
	@GeneratedValue
	private int Id;

	@Column(name = "Descricao_Versao", nullable = false)
	private String descricaoVersao;

	@ManyToOne
	@JoinColumn(name = "Id_Requisito")
	private Requisito idRequisito;

	public VersaoRequisito() {
		super();
	}

	public VersaoRequisito(String descricaoVersao, Requisito idRequisito) {
		super();
		this.descricaoVersao = descricaoVersao;
		this.idRequisito = idRequisito;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDescricaoVersao() {
		return descricaoVersao;
	}

	public void setDescricaoVersao(String descricaoVersao) {
		this.descricaoVersao = descricaoVersao;
	}

	public Requisito getIdRequisito() {
		return idRequisito;
	}

	public void setIdRequisito(Requisito idRequisito) {
		this.idRequisito = idRequisito;
	}

}
