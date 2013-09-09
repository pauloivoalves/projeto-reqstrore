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

@Resource
public class UsuariosController {

	private final UsuarioWeb usuarioWeb;
	private AlunoDAO dao;
	private Validator validator;
	private Result result;

	public UsuariosController(AlunoDAO dao, Result result, Validator validator,
			UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
		this.dao = dao;
		this.validator = validator;
		this.result = result;
	}

	@Get("/login")
	public void loginForm() {

	}
	
	@Path("/logout")
	  public void logout() {
	    usuarioWeb.logout();
	    result.redirectTo(IndexController.class).index();
	  }

	@Post("/login")
	public void login(Aluno aluno) {
		Aluno carregado = dao.carrega(aluno);
		if (carregado == null) {
			validator.add(new ValidationMessage("Login e/ou senha inválidos",
					"usuario.login"));
			validator.onErrorUsePageOf(UsuariosController.class).loginForm();
		}
		
		usuarioWeb.login(carregado);

		result.redirectTo(AlunoController.class).AlunoHome();
	}
}