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
import br.ufc.si.model.Aluno;
import br.ufc.si.util.UsuarioWeb;
import br.ufc.si.util.AutorizacaoInterceptor.Liberado;

@Resource
public class UsuariosController {

	private final UsuarioWeb usuarioWeb;
	private AlunoDAO alunoDAO;
	private Validator validator;
	private Result result;

	public UsuariosController(AlunoDAO dao, Result result, Validator validator,
			UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
		this.alunoDAO = dao;
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
	public void login(Aluno aluno) {
		System.out.println("aqui");
		System.out.println("email - " + aluno.getEmail());
		System.out.println("senha - " + aluno.getSenha());
		Aluno carregado = alunoDAO.carrega(aluno);
		
		if (carregado == null) {
			validator.add(new ValidationMessage("Login e/ou senha inv&aacute;lidos", ""));
			validator.onErrorUsePageOf(UsuariosController.class).loginForm();
		}else if(!carregado.isConfirmado()){
			System.out.println("numero : " + aluno.getNumero());
			if(aluno.getNumero() == carregado.getNumero()){
				carregado.setConfirmado(true);
				alunoDAO.update(carregado);
			}else{
				validator.add(new ValidationMessage("O email informado ainda n&atilde;o foi confirmado", ""));
				validator.onErrorUsePageOf(UsuariosController.class).loginForm();
			}
		}
		
		usuarioWeb.login(carregado);
		result.redirectTo(AlunoController.class).AlunoHome();
	}
}