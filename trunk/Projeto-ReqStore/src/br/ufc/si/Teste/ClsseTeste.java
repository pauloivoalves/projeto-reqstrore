package br.ufc.si.Teste;

import java.util.ArrayList;
import java.util.List;

import antlr.collections.impl.LList;
import br.ufc.si.DAO.AlunoDAO;
import br.ufc.si.DAO.ProjetoDAO;
import br.ufc.si.DAO.RequisitoDAO;
import br.ufc.si.DAO.VersaoRequisitoDAO;
import br.ufc.si.Interfaces.IAlunoDao;
import br.ufc.si.Interfaces.IProjeto;
import br.ufc.si.Interfaces.IRequisito;
import br.ufc.si.Interfaces.IVersaoRequisito;
import br.ufc.si.Tipos.PrioridadeRequisito;
import br.ufc.si.Tipos.TipoProjeto;
import br.ufc.si.Tipos.TipoRequisito;
import br.ufc.si.model.Aluno;
import br.ufc.si.model.Projeto;
import br.ufc.si.model.Requisito;
import br.ufc.si.model.VersaoProjeto;
import br.ufc.si.model.VersaoRequisito;

@SuppressWarnings("unused")
public class ClsseTeste {
		
	public static void main(String[] args) {
//		Aluno aluno = new Aluno();
//		IAlunoDao alunoDAO = new AlunoDAO();
		IRequisito reqDAO = new RequisitoDAO();
		Projeto proj = new Projeto();
		IProjeto projDAO = new ProjetoDAO();
		Requisito req = new Requisito();
		
		VersaoRequisito Vreq = new VersaoRequisito();
		IVersaoRequisito VreqDao = new VersaoRequisitoDAO();
		
		
		VersaoProjeto Vproj = new VersaoProjeto();
		
		//-------------------------------------------------------------------
		
		
		List<Projeto> proList = projDAO.List();
		
		proj = proList.get(0);
		
		for (Requisito requsito : proj.getRequisitos()) {
			System.out.println("Requisito: " + requsito.getId());
				for (VersaoRequisito versao : requsito.getVersoesRequisito()) {
					System.out.println("\t Versao do requisito " + versao.getDescricaoVersao());
				}
		}
		
		
		
		
		
		
		System.out.println("Temrinou!");
	}

}
