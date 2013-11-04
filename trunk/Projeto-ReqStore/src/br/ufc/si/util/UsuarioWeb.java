package br.ufc.si.util;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.ufc.si.model.Usuario;

@Component
@SessionScoped
public class UsuarioWeb {

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
	
	public int getId() {
		return logado.getId();
	}

	public boolean isLogado() {
		return logado != null;
	}

	public void logout() {
		this.logado = null;
	}
}