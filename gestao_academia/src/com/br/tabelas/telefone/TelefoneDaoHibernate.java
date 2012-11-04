package com.br.tabelas.telefone;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.br.conexao.HibernateUtil;
import com.br.tabelas.telefone.Telefone;

public class TelefoneDaoHibernate {
	private Session sessao;
	private Transaction transacao;
	
	public TelefoneDaoHibernate()
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
	
	public void salvar(Telefone telefone) {
		try {
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.save(telefone);
			this.transacao.commit();
		} catch (HibernateException e){
			System.out.println("Nao foi possivel inserir o telefone. Erro: " + e.getMessage());
		} finally {
			try {
				if(this.sessao.isConnected())
					this.sessao.close();
			} catch (Throwable e1) {
				System.out.println("Erro ao fechar operacao de salvar. Msg: " + e1.getMessage());			
			}
		}
		
	}

	
	public void atualizar(Telefone telefone){
		try 
		{
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.update(telefone);
			this.sessao.merge(telefone);
			this.transacao.commit();
		} catch (HibernateException e)
		{
			System.out.println("Nao foi possivel atualizar o telefone. Erro: " + e.getMessage());
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

	
	public void excluir(Telefone telefone) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		this.sessao.delete(telefone);
		this.transacao.commit();
	}


	public Telefone carregar(int telefone_residencial) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		Telefone telefone = (Telefone) this.sessao.get(Telefone.class, telefone_residencial);
		this.transacao.commit();
		this.sessao.close();
		return telefone;
		
	}
	
	public Telefone buscarPorTelefone(int telefone_comercial) {
		String hql = "select u from Telefone u where u.telefone_comercial = :telefone_comercial";
		this.transacao = (Transaction) this.sessao.beginTransaction();
		org.hibernate.Query consulta = this.sessao.createQuery(hql);
		consulta.setFloat("telefone_comercial", telefone_comercial);
		Telefone telefone = (Telefone) consulta.uniqueResult();
		this.transacao.commit();
		this.sessao.close();
		return telefone;
	}

	
	
	public List<Telefone> listar() {
		this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
		this.transacao = (Transaction) this.sessao.beginTransaction();
		List<Telefone> telefones = this.sessao.createCriteria(Telefone.class).list();
		this.transacao.commit();
		this.sessao.close();
		return telefones;
	}

}
