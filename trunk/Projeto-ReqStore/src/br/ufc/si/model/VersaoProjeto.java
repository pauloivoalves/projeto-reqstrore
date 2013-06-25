package br.ufc.si.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class VersaoProjeto {
	@Id
	@GeneratedValue
	private int Id;
	@Column(name = "Descricao_Versao", nullable = false, length = 200)
	private String descricaoVersao;

	@ManyToOne
	@JoinColumn(name = "Id_Projeto")
	private Projeto idProjeto;

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

	public Projeto getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(Projeto idProjeto) {
		this.idProjeto = idProjeto;
	}

}
