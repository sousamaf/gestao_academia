package com.br.tabelas.situacao_aluno;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.br.conexao.HibernateUtil;
import com.br.tabelas.situacao_aluno.Situacao_aluno;

public class Situacao_alunoDaoHibernate {
	private Session sessao;
	private Transaction transacao;
	
	public Situacao_alunoDaoHibernate()
	{
		sessao = HibernateUtil.getSessionFactory().getCurrentSession();
		transacao = (Transaction) sessao.beginTransaction();
		
	}

	public Session getSessao() {
		return sessao;
	}

	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

	public Transaction getTransacao() {
		return transacao;
	}

	public void setTransacao(Transaction transacao) {
		this.transacao = transacao;
	}
	
	public void salvar(Situacao_aluno situacao_aluno) {
		try {
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.save(situacao_aluno);
			this.transacao.commit();
		} catch (HibernateException e){
			System.out.println("Nao foi possivel inserir  a situacao. Erro: " + e.getMessage());
		} finally {
			try {
				if(this.sessao.isConnected())
					this.sessao.close();
			} catch (Throwable e1) {
				System.out.println("Erro ao fechar operacao de salvar. Msg: " + e1.getMessage());			
			}
		}
		
	}

	
	public void atualizar(Situacao_aluno situacao_aluno){
		try 
		{
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.update(situacao_aluno);
			this.sessao.merge(situacao_aluno);
			this.transacao.commit();
		} catch (HibernateException e)
		{
			System.out.println("Nao foi possivel atualizar a situacao. Erro: " + e.getMessage());
		}
		finally
		{
			try
			{
				if(this.sessao.isConnected())
					this.sessao.close();
			} catch(Throwable e1)
			{
				;
			}
		}
	}

	
	public void excluir(Situacao_aluno situacao_aluno) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		this.sessao.delete(situacao_aluno);
		this.transacao.commit();
	}


	public Situacao_aluno carregar(int id_situacao) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		Situacao_aluno situacao_aluno = (Situacao_aluno) this.sessao.get(Situacao_aluno.class, id_situacao);
		this.transacao.commit();
		this.sessao.close();
		return situacao_aluno;
		
	}
	
	public List<Situacao_aluno> listar() {
		this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
		this.transacao = (Transaction) this.sessao.beginTransaction();
		List<Situacao_aluno> funcionarios = this.sessao.createCriteria(Situacao_aluno.class).list();
		this.transacao.commit();
		this.sessao.close();
		return funcionarios;
	}
}
