package br.ufc.si.Controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.blank.IndexController;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.ufc.si.DAO.AlunoDAO;
import br.ufc.si.DAO.ProfessorDAO;
import br.ufc.si.Interfaces.IAluno;
import br.ufc.si.Interfaces.IProfessor;
import br.ufc.si.model.Aluno;
import br.ufc.si.model.Professor;
import br.ufc.si.model.Usuario;
import br.ufc.si.util.AutorizacaoInterceptor.Liberado;
import br.ufc.si.util.UsuarioWeb;

@Resource
public class UsuariosController {

	private final UsuarioWeb usuarioWeb;
	private IAluno alunoDAO;
	private IProfessor professorDAO;
	private Validator validator;
	private Result result;
	
	public UsuariosController(UsuarioWeb usuarioWeb, AlunoDAO alunoDAO,
			ProfessorDAO professorDAO, Validator validator, Result result) {
		super();
		this.usuarioWeb = usuarioWeb;
		this.alunoDAO = alunoDAO;
		this.professorDAO = professorDAO;
		this.validator = validator;
		this.result = result;
	}

	@Liberado
	@Get("/login")
	public void loginForm() {

	}
	
	@Path("/logout")
	  public void logout() {
	    usuarioWeb.logout();
	    result.redirectTo(IndexController.class).index();
	  }

	
	@Liberado
	@Post("/login")
	public void login(Usuario usuario, String tipo_usuario) {
		System.out.println("aqui");
		System.out.println("email - " + usuario.getEmail());
		System.out.println("senha - " + usuario.getSenha());
		System.out.println("tipo: " + tipo_usuario);
		
		if(tipo_usuario.equals("1")){
			Aluno aluno = new Aluno();
			aluno.setEmail(usuario.getEmail());
			aluno.setSenha(usuario.getSenha());
			aluno.setNumero(usuario.getNumero());
			
			Aluno carregado = alunoDAO.carrega(aluno);
			
			if (carregado == null) {
				validator.add(new ValidationMessage("Login e/ou senha inv&aacute;lidos", ""));
				validator.onErrorUsePageOf(UsuariosController.class).loginForm();
			}else if(!carregado.isConfirmado()){
				System.out.println("numero : " + usuario.getNumero());
				if(usuario.getNumero() == carregado.getNumero()){
					carregado.setConfirmado(true);
					alunoDAO.update(carregado);
				}else{
					validator.add(new ValidationMessage("O email informado ainda n&atilde;o foi confirmado", ""));
					validator.onErrorUsePageOf(UsuariosController.class).loginForm();
				}
			}
			usuarioWeb.login(carregado);
			result.redirectTo(AlunoController.class).AlunoHome();
		}else if(tipo_usuario.equals("2")){
			
			Professor professor = new Professor();
			professor.setEmail(usuario.getEmail());
			professor.setSenha(usuario.getSenha());
			professor.setNumero(usuario.getNumero());
			
			Professor carregado = professorDAO.carrega(professor);
			
			if (carregado == null) {
				validator.add(new ValidationMessage("Login e/ou senha inv&aacute;lidos", ""));
				validator.onErrorUsePageOf(UsuariosController.class).loginForm();
			}else if(!carregado.isConfirmado()){
				System.out.println("numero : " + usuario.getNumero());
				if(usuario.getNumero() == carregado.getNumero()){
					carregado.setConfirmado(true);
					professorDAO.update(carregado);
				}else{
					validator.add(new ValidationMessage("O email informado ainda n&atilde;o foi confirmado", ""));
					validator.onErrorUsePageOf(UsuariosController.class).loginForm();
				}
			}
			usuarioWeb.login(carregado);
			result.redirectTo(ProfessorController.class).ProfessorHome();
		}
		
	}
}