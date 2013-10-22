package br.ufc.si.model;

import java.util.List;

import javax.persistence.Entity;

import br.ufc.si.Tipos.TipoProjeto;

@Entity
public class Aluno extends Usuario {

	@Override
	public List<Projeto> ListarProjetos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void SolicitarRestauracaoRequisito(int idRequisito, int idProjeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SolicitarRestauracaoProjeto(int idProjeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Projeto> BuscarProjetos(String nomeProjeto, TipoProjeto tipo,
			String nomeResponsavel, int dificuldade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> BuscarUsuario(String Nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void SugerirProjetos(String descricaoProjeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Projeto> Buscarprojetos(String nomeProjeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
