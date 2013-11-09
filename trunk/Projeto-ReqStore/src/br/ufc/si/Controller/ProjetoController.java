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
import br.ufc.si.DAO.RequisitoDAO;
import br.ufc.si.DAO.TurmaDAO;
import br.ufc.si.Interfaces.IAluno;
import br.ufc.si.Interfaces.IProfessor;
import br.ufc.si.Interfaces.IProjeto;
import br.ufc.si.Interfaces.IRequisito;
import br.ufc.si.Interfaces.ITurma;
import br.ufc.si.Tipos.TipoProjeto;
import br.ufc.si.model.Aluno;
import br.ufc.si.model.Professor;
import br.ufc.si.model.Projeto;
import br.ufc.si.model.Requisito;
import br.ufc.si.model.Turma;
import br.ufc.si.model.Usuario;

@Resource
public class ProjetoController {
	private final IProjeto projetoDAO;
	private final IAluno alunoDAO;
	private final IProfessor profDAO;
	private final IRequisito reqDAO;
	private final ITurma turmaDAO;
	private final Result result;

	public ProjetoController(ProjetoDAO projetoDAO, AlunoDAO alunoDAO,
			ProfessorDAO profDAO, RequisitoDAO reqDAO, TurmaDAO turmaDAO,
			Result result) {
		super();
		this.projetoDAO = projetoDAO;
		this.alunoDAO = alunoDAO;
		this.profDAO = profDAO;
		this.reqDAO = reqDAO;
		this.turmaDAO = turmaDAO;
		this.result = result;
	}

	@Post("/Projeto/AdicionaProjeto")
	public void AdicionaProjeto(Projeto projeto, int id_criador) {

		try {
			Aluno aluno = alunoDAO.getAlunoById(id_criador);
			projeto.setCriador(aluno);
			this.projetoDAO.update(projeto);

			List<Projeto> projetos = aluno.getProjetos();
			projetos.add(projeto);
			aluno.setProjetos(projetos);
			this.alunoDAO.update(aluno);
		} catch (Exception e) {
			Professor professor = this.profDAO.getProfessorById(id_criador);
			projeto.setCriador(professor);
			this.projetoDAO.update(projeto);

			List<Projeto> projetos = professor.getProjetos();
			projetos.add(projeto);
			professor.setProjetos(projetos);
			this.profDAO.update(professor);
		}

		System.out.println("Nome - " + projeto.getNome());
		System.out.println("Dificuldade - " + projeto.getDificuldade());
		this.projetoDAO.save(projeto);
		result.redirectTo(this).MeusProjetos(id_criador);
	}

	@Path("/Projeto/NovoRequisito")
	public void AdicionarRequisitoProjeto(Requisito requisito, int id_projeto) {

		Projeto proj = this.projetoDAO.getProjetoById(id_projeto);

		proj.getRequisitos().add(requisito);
		this.projetoDAO.update(proj);

		requisito.setProjeto(proj);
		this.reqDAO.update(requisito);
		result.redirectTo(this).Detalhes(id_projeto);
	}
	
	@Path("/Projeto/RemoverRequisito")
	public void RemoverRequisitoProjeto(int id_requisito, int id_projeto){
		Projeto proj = this.projetoDAO.getProjetoById(id_projeto);
		Requisito requisito = this.reqDAO.getRequisitoById(id_requisito);
		
		proj.getRequisitos().remove(requisito);
		this.projetoDAO.update(proj);

		requisito.setProjeto(null);
		this.reqDAO.update(requisito);
		this.reqDAO.delete(requisito);
		
		result.redirectTo(this).Detalhes(id_projeto);
	}
	
	@Path("/Projeto/RemoverUsuario")
	public Projeto RemoverUsuario(int id_projeto){
		return this.projetoDAO.getProjetoById(id_projeto);
	}
	
	@Path("/Projeto/RemoverUsuarioProjeto")
	public void RemoverUsuarioProjeto(int id_usuario, int id_projeto){
		
		System.out.println("\n\n\n Id projeto" + id_projeto);
		System.out.println("\n\n\n Id usuario" + id_usuario);
		Usuario usuario;
		
		try {
			usuario = alunoDAO.getAlunoById(id_usuario);
			System.out.println("AQUI! 1");
		} catch (Exception e) {
			usuario = this.profDAO.getProfessorById(id_usuario);
			System.out.println("AQUI! 2");
		}
		
		System.out.println("AQUI! 3");
		Projeto proj = this.projetoDAO.getProjetoById(id_projeto);
		System.out.println("AQUI! 4");
		
		proj.getUsuarios_participantes().remove(usuario);
		System.out.println("AQUI! 5");
		this.projetoDAO.update(proj);
		System.out.println("AQUI! 6");
		
		usuario.getProjetos_participantes().remove(proj);
				
		if (usuario instanceof Aluno) {
			this.alunoDAO.update((Aluno) usuario);
		} else if (usuario instanceof Professor) {
			this.profDAO.update((Professor) usuario);
		}
		
		System.out.println("AQUI! 7");
		result.redirectTo(this).RemoverUsuario(id_projeto);
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

	@Path("/Projeto/RemoveProjetoTurma")
	public void RemoveProjetoTurma(int id_projeto, int id_turma, int id_usuario) {
		Projeto projeto = this.projetoDAO.getProjetoById(id_projeto);
		Turma turma = this.turmaDAO.getTurmaById(id_turma);

		System.out.println("\n\nA turma tem o projeto: "
				+ turma.getProjetos().contains(projeto));
		for (Usuario usuario : turma.getUsuarios()) {
			System.out.println("\n\n O usuario: " + usuario.getId()
					+ "possui o projeto - >"
					+ usuario.getProjetos_participantes().contains(projeto));

			if (usuario.getProjetos_participantes().contains(projeto)) {
				usuario.getProjetos_participantes().remove(projeto);

				if (usuario instanceof Aluno) {
					this.alunoDAO.update((Aluno) usuario);
				} else if (usuario instanceof Professor) {
					this.profDAO.update((Professor) usuario);
				}

				projeto.getUsuarios_participantes().remove(usuario);
				this.projetoDAO.update(projeto);
			}
		}

		System.out.println("Cheguei aqui!\n\n\n");
		turma.getProjetos().remove(projeto);
		System.out.println("Cheguei aqui 2!\n\n\n");
		this.turmaDAO.update(turma);
		System.out.println("Cheguei aqui 3!\n\n\n");

		projeto.getTurmas().remove(turma);
		System.out.println("Cheguei aqui 4!\n\n\n");
		this.projetoDAO.update(projeto);
		System.out.println("Cheguei aqui 5!\n\n\n");
		result.redirectTo(TurmaController.class).DetalhesTurma(id_turma);
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
	public List<Projeto> ListaProjetos(int id_usuario) {
		try {
			Aluno aluno = this.alunoDAO.getAlunoById(id_usuario);
			List<Projeto> projetos = new ArrayList<Projeto>();

			projetos.addAll(aluno.getProjetos_participantes());
			projetos.addAll(aluno.getProjetos());
			return projetos;
		} catch (Exception e) {
			Professor professor = this.profDAO.getProfessorById(id_usuario);

			List<Projeto> projetos = new ArrayList<Projeto>();
			projetos.addAll(professor.getProjetos());
			projetos.addAll(professor.getProjetos_participantes());
			return projetos;
		}
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
		
		System.out.println("\n\nTamanho: 5 - " + projeto.getUsuarios_participantes().size());
		projeto.getUsuarios_participantes().clear();
		System.out.println("\n\nTamanho: 4 - " + projeto.getUsuarios_participantes().size());

		projeto.setCriador(null);
		
		System.out.println("\n\nTamanho: " + projeto.getTurmas().size());
		
		for (Turma turma : projeto.getTurmas()) {
			turma.getProjetos().remove(projeto);
			turmaDAO.update(turma);
		}
		
		projeto.getTurmas().clear();
		System.out.println("\n\nTamanho: 2 -> " + projeto.getTurmas().size());
		
		projetoDAO.update(projeto);
		
		try {
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
		} catch (Exception e) {
			result.redirectTo(this).MeusProjetos(id_usuario);
		}
	}

}
