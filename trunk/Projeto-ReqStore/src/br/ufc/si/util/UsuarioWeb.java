package br.ufc.si.util;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.ufc.si.DAO.AlunoDAO;
import br.ufc.si.DAO.ProfessorDAO;
import br.ufc.si.DAO.ProjetoDAO;
import br.ufc.si.DAO.TurmaDAO;
import br.ufc.si.Interfaces.IAluno;
import br.ufc.si.Interfaces.IProfessor;
import br.ufc.si.Interfaces.IProjeto;
import br.ufc.si.Interfaces.ITurma;
import br.ufc.si.model.Aluno;
import br.ufc.si.model.Professor;
import br.ufc.si.model.Projeto;
import br.ufc.si.model.Turma;
import br.ufc.si.model.Usuario;

@Component
@SessionScoped
public class UsuarioWeb {

	private final ITurma turmaDAO;
	private final IAluno alunoDAO;
	private final IProfessor profDAO;
	private final IProjeto projDAO;

	public UsuarioWeb(TurmaDAO turmaDAO, AlunoDAO alunoDAO,
			ProfessorDAO profDAO, ProjetoDAO projDAO) {
		super();
		this.turmaDAO = turmaDAO;
		this.alunoDAO = alunoDAO;
		this.profDAO = profDAO;
		this.projDAO = projDAO;
	}

	private Usuario logado;
	private int tipo;

	public Usuario getUsuario() {
		return logado;
	}

	public void setLogado(Usuario logado) {
		this.logado = logado;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void login(Usuario usuario) {
		this.logado = usuario;
	}

	public String getNome() {
		return logado.getNome();
	}

	public List<Usuario> getUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		ITurma turmaDAO = new TurmaDAO();
		List<Turma> turmas = turmaDAO.List();

		for (Turma turma : turmas) {
			if ((turma.getResponsavel().getId() == logado.getId())
					|| turma.getUsuarios().contains(logado)) {
				usuarios.addAll(turma.getUsuarios());
			}
		}

		System.out.println("\n\n\n\n\n\n Tamanaho -> " + usuarios.size());

		return usuarios;
	}

	public int getId() {
		return logado.getId();
	}

	public List<Projeto> getProjetos() {
		return this.projDAO.List();
	}

	public List<Aluno> getAlunos() {
		return this.alunoDAO.List();
	}

	public List<Professor> getProfessores() {
		return this.profDAO.List();
	}

	public List<Turma> getTurmas() {
		return this.turmaDAO.List();
	}

	public boolean isLogado() {
		return logado != null;
	}

	public void logout() {
		this.logado = null;
	}

}