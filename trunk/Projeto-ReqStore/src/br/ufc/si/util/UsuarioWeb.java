package br.ufc.si.util;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.ufc.si.model.Aluno;

@Component
@SessionScoped
public class UsuarioWeb {

	private Aluno logado;

	public void login(Aluno usuario) {
		this.logado = usuario;
	}

	public String getNome() {
		return logado.getNome();
	}

	public boolean isLogado() {
		return logado != null;
	}
	
	public void logout() {
	    this.logado = null;
	  }
}