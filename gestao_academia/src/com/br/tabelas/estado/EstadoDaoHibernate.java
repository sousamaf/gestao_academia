package com.br.tabelas.estado;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.br.conexao.HibernateUtil;
import com.br.tabelas.estado.Estado;

public class EstadoDaoHibernate {
	
	private Session sessao;
	private Transaction transacao;
	
	public EstadoDaoHibernate()
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
	
	public void salvar(Estado estado) {
		try {
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.save(estado);
			this.transacao.commit();
		} catch (HibernateException e){
			System.out.println("Nao foi possivel inserir o estado. Erro: " + e.getMessage());
		} finally {
			try {
				if(this.sessao.isConnected())
					this.sessao.close();
			} catch (Throwable e1) {
				System.out.println("Erro ao fechar operacao de salvar. Msg: " + e1.getMessage());			
			}
		}
		
	}

	
	public void atualizar(Estado estado){
		try 
		{
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.update(estado);
			this.sessao.merge(estado);
			this.transacao.commit();
		} catch (HibernateException e)
		{
			System.out.println("Nao foi possivel atualizar o estado. Erro: " + e.getMessage());
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

	
	public void excluir(Estado estado) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		this.sessao.delete(estado);
		this.transacao.commit();
	}


	public Estado carregar(String estado) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		Estado uf = (Estado) this.sessao.get(Estado.class, estado);
		this.transacao.commit();
		this.sessao.close();
		return uf;
		
	}
	
	
	public List<Estado> listar() {
		this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
		this.transacao = (Transaction) this.sessao.beginTransaction();
		List<Estado> estados = this.sessao.createCriteria(Estado.class).list();
		this.transacao.commit();
		this.sessao.close();
		return estados;
	}

}
