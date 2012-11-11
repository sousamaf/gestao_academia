package com.br.beans;

import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import financeiro.usuario.Usuario;
import financeiro.usuario.UsuarioDAOHibernate;


@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private String confirmarSenha;
	private List<Usuario> lista;
	private String destinoSalvar;
	private String permissao;
	

	public String novo() {
		this.destinoSalvar = "usuarioSucesso";
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
		return "usuario";
	}

	public String editar() {
		this.confirmarSenha = this.usuario.getSenha();
		return "/publico/usuario";
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();

		String senha = this.usuario.getSenha();
		if (!senha.equals(this.confirmarSenha)) {
			FacesMessage facesMessage = new FacesMessage(
					"A senha não foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null;
		}

		UsuarioDAOHibernate usuariodao = new UsuarioDAOHibernate();
		usuariodao.salvar(this.usuario);

		return this.destinoSalvar;
	}

	public String excluir() {
		UsuarioDAOHibernate usuariodao = new UsuarioDAOHibernate();
		usuariodao.salvar(this.usuario);
		this.lista = null;
		return null;
	}

	public String ativar() {
		if (this.usuario.isAtivo())
			this.usuario.setAtivo(false);
		else
			this.usuario.setAtivo(true);

		UsuarioDAOHibernate usuariodao = new UsuarioDAOHibernate();
		usuariodao.salvar(this.usuario);
		return null;
	}

	public String atribuiPermissao(Usuario usuario, String permissao) {

		this.usuario = usuario;

		Set<String> permissoes = this.usuario.getPermissao();

		if (permissoes.contains(permissao)) {
			permissoes.remove(permissao);
		} else {
			permissoes.add(permissao);
		}
		return null;
	}

	public List<Usuario> getLista() {
		if (this.lista == null) {
			UsuarioDAOHibernate usuariodao = new UsuarioDAOHibernate();		
			this.lista = usuariodao.listar();
		}
		return this.lista;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

}
