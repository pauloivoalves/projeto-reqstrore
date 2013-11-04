package br.ufc.si.Controller;

import java.util.List;
import java.util.Random;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.blank.IndexController;
import br.ufc.si.DAO.AlunoDAO;
import br.ufc.si.Interfaces.IAluno;
import br.ufc.si.model.Aluno;
import br.ufc.si.util.AutorizacaoInterceptor.Liberado;
import br.ufc.si.util.SendMail;

@Resource
public class AlunoController {

	private final IAluno alunoDAO;
	private final Result result;

	public AlunoController(AlunoDAO alunoDAO, Result result) {
		super();
		this.alunoDAO = alunoDAO;
		this.result = result;
	}

	@Path("/Aluno/home")
	public void AlunoHome() {

	}

	@Path("/Aluno/DetalhesAluno")
	public Aluno DetalhesAluno(int id) {
		System.out.println("ID: " + id);
		if (this.alunoDAO.getAlunoById(id) == null) {
			result.redirectTo(ProfessorController.class).DetalhesProfessor(id);	
		}else{
			return this.alunoDAO.getAlunoById(id);
		}
		return null;
	}

	@Path("/Aluno/AlunoProjetos")
	public void AlunoProjetos() {

	}

	@Path("/Aluno/novo")
	public void AdicionaAluno(Aluno aluno) {
		this.alunoDAO.save(aluno);
		result.redirectTo(this.ListarAlunos());
	}

	@Path("/Aluno/remove")
	public void RemoverAluno(Aluno aluno) {
		this.alunoDAO.delete(aluno);
	}

	@Path("/Aluno/update")
	public void AtualizaAluno(Aluno aluno) {
		this.alunoDAO.update(aluno);
	}

	@Path("/Aluno/busca/{aluno.Id}")
	public Aluno BuscaAlunoPorId(Aluno aluno) {
		return this.alunoDAO.getAlunoById(aluno.getId());
	}

	@Post("/Aluno/cadastrarAluno")
	@Liberado
	public void cadastrarAluno(Aluno aluno) {
		Random random = new Random();
		aluno.setNumero(random.nextInt(801));
		aluno.setConfirmado(false);

		String msg = "Bem vindo ao ReqStore!"
				+ "\nSeu email : "
				+ aluno.getEmail()
				+ "\nSua senha: "
				+ aluno.getSenha()
				+ "\nSeu n�mero de confirma�a� �: "
				+ aluno.getNumero()
				+ "\n Volte � tela de Login do ReqStore e utilize o seu n�mero de confirma��o para validar o seu email."
				+ "\nS� � necess�rio utilizar esse n�mero 1 vez. Ap�s a confirma��o, seu permanecer� validado. Bons estudos!";

		try {
			if (alunoDAO.buscaPorEmail(aluno) != null) {
				result.redirectTo(IndexController.class).ops();
			} else {
				SendMail.enviarEmail(aluno.getEmail(),
						"Cria��o de Conta no ReqStore", msg);
				alunoDAO.save(aluno);
				result.redirectTo(IndexController.class).ok();
			}
		} catch (Exception e) {
			result.redirectTo(IndexController.class).ops();
		}
	}

	@Path("/Aluno/cadastro")
	@Liberado
	public void cadastro(Aluno aluno) {

	}

	@Path("/Alunos/lista")
	public List<Aluno> ListarAlunos() {
		return this.alunoDAO.List();
	}

	@Path("/Aluno/busca/{nome}")
	public List<Aluno> BuscarAlunoPorNome(String nome) {
		return this.alunoDAO.SearchByName(nome);
	}

}
