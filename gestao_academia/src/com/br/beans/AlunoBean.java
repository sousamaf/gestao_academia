package com.br.beans;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import com.br.tabelas.aluno.Aluno;
import com.br.tabelas.aluno.AlunoDaoHibernate;
import com.br.tabelas.situacao_aluno.Situacao_aluno;
import com.br.tabelas.usuario.Usuario;


@ManagedBean(name = "alunoBean")
@RequestScoped
public class AlunoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5345291895087424588L;

	private Aluno aluno = new Aluno();
	private String confirmasenha;
	private List<Aluno> lista;
	private Situacao_aluno ativo;
	private Usuario senha;
	private Boolean edicao = false;
	
 
	public String novo() {
		this.aluno = new Aluno();
		this.aluno.setId_situacao(ativo);
		return "usuario";
	}

	public String editar(){
		this.confirmasenha = this.senha.getSenha();
		return "cadastro_edicao";
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		if(!this.senha.getSenha().equals(this.confirmasenha))
		{
			context.addMessage("confirmasenha", new FacesMessage(FacesMessage.SEVERITY_INFO, "Senha confirmada incorretamente", ""));
			return null;
		}
		AlunoDaoHibernate alunoDao = new AlunoDaoHibernate();
		if(this.aluno != null) {
			Integer user_id = this.aluno.getId_aluno(); System.out.println(user_id);
		}
		alunoDao.salvar(this.aluno);
		return "mostracadastro";
	}
	
	public String excluir()
	{
		AlunoDaoHibernate alunoDao = new AlunoDaoHibernate();
		alunoDao.excluir(this.aluno);
		this.lista = null;
		this.lista = this.getLista();
		return null;
	}
	


	public List<Aluno> getLista(){
		if(this.lista == null){
			AlunoDaoHibernate alunoDao = new AlunoDaoHibernate();
			this.lista = alunoDao.listar();
		}
		return this.lista;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public String getConfirmasenha() {
		return confirmasenha;
	}

	public void setConfirmasenha(String confirmasenha) {
		this.confirmasenha = confirmasenha;
	}
	
	public Usuario getSenha() {
		return senha;
	}

	public void setSenha(Usuario senha) {
		this.senha = senha;
	}

	public Situacao_aluno getAtivo() {
		return ativo;
	}

	public void setAtivo(Situacao_aluno ativo) {
		this.ativo = ativo;
	}

	public Boolean getEdicao() {
		return edicao;
	}

	public void setEdicao(Boolean edicao) {
		this.edicao = edicao;
	}

	public void setLista(List<Aluno> lista) {
		this.lista = lista;
	}
}
