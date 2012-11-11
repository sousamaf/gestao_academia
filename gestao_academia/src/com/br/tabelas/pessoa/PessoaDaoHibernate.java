package com.br.tabelas.pessoa;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.br.conexao.HibernateUtil;
import com.br.tabelas.pessoa.Pessoa;

public class PessoaDaoHibernate {
	
	private Session sessao;
	private Transaction transacao;
	
	public PessoaDaoHibernate()
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
	
	public void salvar(Pessoa pessoa) {
		try {
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.save(pessoa);
			this.transacao.commit();
		} catch (HibernateException e){
			System.out.println("Nao foi possivel inserir a pessoa. Erro: " + e.getMessage());
		} finally {
			try {
				if(this.sessao.isConnected())
					this.sessao.close();
			} catch (Throwable e1) {
				System.out.println("Erro ao fechar operacao de salvar. Msg: " + e1.getMessage());			
			}
		}
		
	}

	
	public void atualizar(Pessoa pessoa){
		try 
		{
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.update(pessoa);
			this.sessao.merge(pessoa);
			this.transacao.commit();
		} catch (HibernateException e)
		{
			System.out.println("Nao foi possivel atualizar a pessoa. Erro: " + e.getMessage());
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

	
	public void excluir(Pessoa pesoa) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		this.sessao.delete(pesoa);
		this.transacao.commit();
	}

	public List<Pessoa> listar() {
		this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
		this.transacao = (Transaction) this.sessao.beginTransaction();
		List<Pessoa> pessoas = this.sessao.createCriteria(Pessoa.class).list();
		this.transacao.commit();
		this.sessao.close();
		return pessoas;
	}

}
