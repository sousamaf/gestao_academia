package com.br.tabelasbeans;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import com.br.tabelas.Aluno;
import com.br.tabelas.AlunoDao;


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
	private Boolean edicao = false;
	

	public String novo() {
		this.aluno = new Aluno();
		this.aluno.setAtivo(true);
		return "usuario";
	}
	
	public String editar(){
		this.confirmasenha = this.aluno.getSenha();
		return "cadastro_edicao";
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		if(!this.aluno.getSenha().equals(this.confirmasenha))
		{
			context.addMessage("confirmasenha", new FacesMessage(FacesMessage.SEVERITY_INFO, "Senha confirmada incorretamente", ""));
			return null;
		}
		AlunoDao alunoDao = new AlunoDao();
		Integer user_id = this.aluno.getCodigo(); System.out.println(user_id);
		alunoDao.salvar(this.aluno);
		return "mostracadastro";
	}
	
	public String excluir()
	{
		AlunoDao alunoDao = new AlunoDao();
		alunoDao.excluir(this.aluno);
		this.lista = null;
		this.lista = this.getLista();
		return null;
	}
	
	public String ativar(){
		if(this.aluno.isAtivo())
			this.aluno.setAtivo(false);
		else
			this.aluno.setAtivo(true);
		
		AlunoDao alunoDao = new AlunoDao();
		alunoDao.salvar(this.aluno);
		return null;
	}
	
	public List<Aluno> getLista(){
		if(this.lista == null){
			AlunoDao alunoDao = new AlunoDao();
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
