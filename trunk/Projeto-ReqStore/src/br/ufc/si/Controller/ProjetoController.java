package br.ufc.si.Controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.ufc.si.DAO.AlunoDAO;
import br.ufc.si.DAO.ProfessorDAO;
import br.ufc.si.DAO.ProjetoDAO;
import br.ufc.si.Interfaces.IAluno;
import br.ufc.si.Interfaces.IProfessor;
import br.ufc.si.Interfaces.IProjeto;
import br.ufc.si.Tipos.TipoProjeto;
import br.ufc.si.model.Aluno;
import br.ufc.si.model.Professor;
import br.ufc.si.model.Projeto;
import br.ufc.si.model.Usuario;

@Resource
public class ProjetoController {
	private final IProjeto projetoDAO;
	private final IAluno alunoDAO;
	private final IProfessor profDAO;
	private final Result result;

	public ProjetoController(ProjetoDAO projetoDAO, AlunoDAO alunoDAO,
			ProfessorDAO profDAO, Result result) {
		super();
		this.projetoDAO = projetoDAO;
		this.alunoDAO = alunoDAO;
		this.profDAO = profDAO;
		this.result = result;
	}

	@Post("/Projeto/AdicionaProjeto")
	public void AdicionaProjeto(Projeto projeto, int id_criador) {
		
		try {
			Aluno aluno = alunoDAO.getAlunoById(id_criador);
			projeto.setCriador(aluno);
			projetoDAO.update(projeto);

			List<Projeto> projetos = aluno.getProjetos();
			projetos.add(projeto);
			aluno.setProjetos(projetos);
			alunoDAO.update(aluno);
		} catch (Exception e) {
			Professor professor = profDAO.getProfessorById(id_criador);
			projeto.setCriador(professor);
			projetoDAO.update(projeto);

			List<Projeto> projetos = professor.getProjetos();
			projetos.add(projeto);
			professor.setProjetos(projetos);
			profDAO.update(professor);
		}
		
		System.out.println("Nome - " + projeto.getNome());
		System.out.println("Dificuldade - " + projeto.getDificuldade());
		this.projetoDAO.save(projeto);
		result.redirectTo(this).ListaProjetos();
	}
	
	@Path("/Projeto/NovoProjeto")
	public void NovoProjeto() {
		
	}

	@Path("/Projeto/responsavel")
	public void AdicionaResponsavel(Projeto projeto, Usuario usuario) {
		projeto.setCriador(usuario);
		projetoDAO.update(projeto);

		List<Projeto> projetos = usuario.getProjetos();
		projetos.add(projeto);
		usuario.setProjetos(projetos);
		if (usuario instanceof Aluno) {
			alunoDAO.update((Aluno) usuario);
		} else if (usuario instanceof Professor) {
			profDAO.update((Professor) usuario);
		}
	}

	@Path("/Projeto/Remover")
	public void RemoveProjeto(int id_projeto, int id_usuario) {
		System.out.println("Usuario : " + id_usuario);
		
		Projeto projeto = projetoDAO.getProjetoById(id_projeto);
		
		for (Usuario usuario : projeto.getUsuarios_participantes()) {
			usuario.getProjetos_participantes().remove(projeto);
			if (usuario instanceof Aluno) {
				alunoDAO.update((Aluno) usuario);
			} else if (usuario instanceof Professor) {
				profDAO.update((Professor) usuario);
			}
		}
		projeto.getUsuarios_participantes().clear();

		projeto.setCriador(null);
		
		projeto.getTurmas().clear();
		projetoDAO.update(projeto);
		
		try {
			Aluno user = alunoDAO.getAlunoById(id_usuario);
			user.getProjetos().remove(projeto);
			alunoDAO.update(user);
		} catch (Exception e) {
			Professor user = profDAO.getProfessorById(id_usuario);
			user.getProjetos().remove(projeto);
			profDAO.update(user);
		}
		
		this.projetoDAO.delete(projeto);
		result.redirectTo(this).MeusProjetos(id_usuario);
	}

	@Path("/Projeto/update")
	public void AtualizaProjeto(Projeto projeto) {
		this.projetoDAO.update(projeto);
	}

	@Path("/Projeto/Detalhes")
	public Projeto Detalhes(int id) {
		return this.projetoDAO.getProjetoById(id);
	}

	@Path("/Projeto/lista")
	public List<Projeto> ListaProjetos() {
		return this.projetoDAO.List();
	}

	@Get("/Projeto/Busca")
	public List<Projeto> Busca(String nomeProjeto, String dificuldadeProjeto,
			String tipoProjeto) {
		if ((nomeProjeto == null) && (dificuldadeProjeto == null)
				&& (tipoProjeto == null)) {

			return null;

		} else if ((dificuldadeProjeto != null && tipoProjeto != null)
				&& nomeProjeto == null) {

			List<Projeto> projetos = projetoDAO.BuscaDificuldadeTipo(
					Integer.parseInt(dificuldadeProjeto),
					TipoProjeto.valueOf(tipoProjeto));
			return projetos;

		} else if (dificuldadeProjeto != null && tipoProjeto != null
				&& nomeProjeto != null) {
			List<Projeto> projetos = projetoDAO.SearchByName(nomeProjeto);

			if (projetos.size() != 0) {
				List<Projeto> listRetorno = new ArrayList<Projeto>();

				for (Projeto projeto : projetos) {
					if (projeto.getDificuldade() <= Integer
							.parseInt(dificuldadeProjeto)
							&& projeto
									.getTipoProjeto()
									.toString()
									.equals(TipoProjeto.valueOf(tipoProjeto)
											.toString())) {
						Hibernate.initialize(projeto);
						listRetorno.add(projeto);
					}
				}
				return listRetorno;
			}
		}
		return null;
	}

	@Get("/Projeto/MeusProjetos")
	public List<Projeto> MeusProjetos(int id) {
		System.out.println("Id - " + id);
		Usuario usuario = new Usuario();
		usuario.setId(id);
		return projetoDAO.MeusProjetos(usuario);
	}

}
