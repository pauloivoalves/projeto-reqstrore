package br.ufc.si.Controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.ufc.si.model.Usuario;
import br.ufc.si.util.Public;
import br.ufc.si.util.UserSession;
import br.ufc.si.util.UsuarioBusiness;

@Resource
public class LoginController {
	private Result result;
	private UserSession userSession;
	private UsuarioBusiness business;

	public LoginController(Result result, UserSession userSession,
			UsuarioBusiness business) {
		this.result = result;
		this.userSession = userSession;
		this.business = business;
	}

	public LoginController() {
		super();
	}

	@Public
	@Path("/login")
	public void login() {

	}

	@Public
	@Post("/autenticar")
	public void autenticar(Usuario usuario, int tipo_usuario) {
		Usuario user = business.autenticar(usuario.getEmail(),
				usuario.getSenha(), tipo_usuario);

		if (user != null) {
			userSession.setUser(user);

			// result.redirectTo(this).login();
		} else {
			result.include("error", "E-mail ou senha incorreta!")
					.redirectTo(this).login();
		}
	}

	@Get("/logout")
	public void logout() {
		userSession.logout();
		result.redirectTo(this).login();
	}

}
