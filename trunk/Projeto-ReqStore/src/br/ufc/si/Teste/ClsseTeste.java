package br.ufc.si.Teste;

import java.util.ArrayList;
import java.util.List;

import antlr.collections.impl.LList;
import br.ufc.si.DAO.AlunoDAO;
import br.ufc.si.DAO.ProjetoDAO;
import br.ufc.si.DAO.RequisitoDAO;
import br.ufc.si.DAO.VersaoProjetoDAO;
import br.ufc.si.DAO.VersaoRequisitoDAO;
import br.ufc.si.Interfaces.IAluno;
import br.ufc.si.Interfaces.IProjeto;
import br.ufc.si.Interfaces.IRequisito;
import br.ufc.si.Interfaces.IVersaoProjeto;
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

		Projeto proj = new Projeto();
		IProjeto projDAO = new ProjetoDAO();
		IVersaoProjeto versaoDAO = new VersaoProjetoDAO();
		
		proj = projDAO.getProjetoById(38);
				
		//versaoDAO.save(Vproj);
		//-------------------------------------------------------------------
		
		//projDAO.save(proj);
		
		
		System.out.println("Proj > Nome do projeto > " + proj.getNome() );
		System.out.println("\nProj > Versao > Nome do projeto > " + proj.getVersoesProjeto().get(0).getIdProjeto().getNome());
		
		proj.setNome("Nome diferente");
		System.out.println("\nProj > Novo nome > " + proj.getNome());
		
		VersaoProjeto versao = proj.getVersoesProjeto().get(0);
		
		
		System.out.println("\n\tRecuperando versao");
		proj = versao.getIdProjeto();
		
		System.out.println("versao recuperada > nome > " + proj.getNome() + "\nVersao recuperada > id > " + proj.getId());
		
		
		
		
		System.out.println("Temrinou!");
	}

}
