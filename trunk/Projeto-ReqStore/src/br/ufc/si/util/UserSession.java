package br.ufc.si.util;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.ufc.si.model.Usuario;

@Component
@SessionScoped
public class UserSession {
	private Usuario user;

	public boolean isLogged() {
		return user != null;
	}

	public void logout() {
		user = null;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

}
