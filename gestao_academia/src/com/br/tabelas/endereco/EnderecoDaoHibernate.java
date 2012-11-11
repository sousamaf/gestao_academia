package com.br.tabelas.endereco;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.br.conexao.HibernateUtil;
import com.br.tabelas.endereco.Endereco;

public class EnderecoDaoHibernate {
	
	private Session sessao;
	private Transaction transacao;
	
	public EnderecoDaoHibernate()
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
	
	public void salvar(Endereco endereco) {
		try {
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.save(endereco);
			this.transacao.commit();
		} catch (HibernateException e){
			System.out.println("Nao foi possivel inserir o endereco. Erro: " + e.getMessage());
		} finally {
			try {
				if(this.sessao.isConnected())
					this.sessao.close();
			} catch (Throwable e1) {
				System.out.println("Erro ao fechar operacao de salvar. Msg: " + e1.getMessage());			
			}
		}
		
	}

	
	public void atualizar(Endereco endereco){
		try 
		{
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.update(endereco);
			this.sessao.merge(endereco);
			this.transacao.commit();
		} catch (HibernateException e)
		{
			System.out.println("Nao foi possivel atualizar o endereco. Erro: " + e.getMessage());
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

	
	public void excluir(Endereco endereco) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		this.sessao.delete(endereco);
		this.transacao.commit();
	}


	public Endereco carregar(String rua) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		Endereco endereco = (Endereco) this.sessao.get(Endereco.class, rua);
		this.transacao.commit();
		this.sessao.close();
		return endereco;
		
	}
	
	public Endereco buscarPorBairro(String bairro) {
		String hql = "select u from Endereco u where u.bairro = :bairro";
		this.transacao = (Transaction) this.sessao.beginTransaction();
		org.hibernate.Query consulta = this.sessao.createQuery(hql);
		consulta.setString("bairro", bairro);
		Endereco endereco = (Endereco) consulta.uniqueResult();
		this.transacao.commit();
		this.sessao.close();
		return endereco;
	}

	
	
	public List<Endereco> listar() {
		this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
		this.transacao = (Transaction) this.sessao.beginTransaction();
		List<Endereco> enderecos = this.sessao.createCriteria(Endereco.class).list();
		this.transacao.commit();
		this.sessao.close();
		return enderecos;
	}

}
