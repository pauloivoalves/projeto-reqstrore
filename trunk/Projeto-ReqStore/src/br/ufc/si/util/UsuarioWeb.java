package br.ufc.si.util;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.ufc.si.model.Turma;
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
	
	public List<Usuario> getUsuarios(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		for (Turma turma : logado.getTurmas()) {
			for (Usuario usuario : turma.getUsuarios()) {
				if(!usuarios.contains(usuario)){
					usuarios.add(usuario);
				}
			}
		}
		
		System.out.println("\n\n\n\n\n\n Tamanaho -> " + usuarios.size());
		
		return usuarios;
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