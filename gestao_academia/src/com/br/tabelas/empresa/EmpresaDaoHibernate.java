package com.br.tabelas.empresa;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.br.conexao.HibernateUtil;
import com.br.tabelas.empresa.Empresa;

public class EmpresaDaoHibernate {
	
	private Session sessao;
	private Transaction transacao;
	
	public EmpresaDaoHibernate()
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
	
	public void salvar(Empresa empresa) {
		try {
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.save(empresa);
			this.transacao.commit();
		} catch (HibernateException e){
			System.out.println("Nao foi possivel inserir a empresa. Erro: " + e.getMessage());
		} finally {
			try {
				if(this.sessao.isConnected())
					this.sessao.close();
			} catch (Throwable e1) {
				System.out.println("Erro ao fechar operacao de salvar. Msg: " + e1.getMessage());			
			}
		}
		
	}

	
	public void atualizar(Empresa empresa){
		try 
		{
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.update(empresa);
			this.sessao.merge(empresa);
			this.transacao.commit();
		} catch (HibernateException e)
		{
			System.out.println("Nao foi possivel atualizar a empresa. Erro: " + e.getMessage());
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

	
	public void excluir(Empresa empresa) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		this.sessao.delete(empresa);
		this.transacao.commit();
	}


	public Empresa carregar(Integer id_empresa) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		Empresa empresa = (Empresa) this.sessao.get(Empresa.class, id_empresa);
		this.transacao.commit();
		this.sessao.close();
		return empresa;
		
	}
	
	public Empresa buscarPorCnpj(String cnpj) {
		String hql = "select u from Empresa u where u.cnpj = :cnpj";
		this.transacao = (Transaction) this.sessao.beginTransaction();
		org.hibernate.Query consulta = this.sessao.createQuery(hql);
		consulta.setString("cnpj", cnpj);
		Empresa empresa = (Empresa) consulta.uniqueResult();
		this.transacao.commit();
		this.sessao.close();
		return empresa;
	}

	
	public List<Empresa> listar() {
		this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
		this.transacao = (Transaction) this.sessao.beginTransaction();
		List<Empresa> empresas = this.sessao.createCriteria(Empresa.class).list();
		this.transacao.commit();
		this.sessao.close();
		return empresas;
	}

}
