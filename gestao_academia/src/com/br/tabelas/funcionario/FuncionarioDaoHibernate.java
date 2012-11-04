package com.br.tabelas.funcionario;

import java.sql.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.br.conexao.HibernateUtil;
import com.br.tabelas.funcionario.Funcionario;

public class FuncionarioDaoHibernate {
	private Session sessao;
	private Transaction transacao;
	
	public FuncionarioDaoHibernate()
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
	
	public void salvar(Funcionario funcionario) {
		try {
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.save(funcionario);
			this.transacao.commit();
		} catch (HibernateException e){
			System.out.println("Nao foi possivel inserir o funcionario. Erro: " + e.getMessage());
		} finally {
			try {
				if(this.sessao.isConnected())
					this.sessao.close();
			} catch (Throwable e1) {
				System.out.println("Erro ao fechar operacao de salvar. Msg: " + e1.getMessage());			
			}
		}
		
	}

	
	public void atualizar(Funcionario funcionario) {
		try 
		{
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.update(funcionario);
			this.sessao.merge(funcionario);
			this.transacao.commit();
		} catch (HibernateException e)
		{
			System.out.println("Nao foi possivel atualizar o funcionario. Erro: " + e.getMessage());
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

	
	public void excluir(Funcionario funcionario) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		this.sessao.delete(funcionario);
		this.transacao.commit();
	}


	public Funcionario carregar(Integer id_funcionario) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		Funcionario funcionario = (Funcionario) this.sessao.get(Funcionario.class, id_funcionario);
		this.transacao.commit();
		this.sessao.close();
		return funcionario;
	}
	
	public Funcionario buscarPorData(Date data_entrada) {
		String hql = "select u from Funcionario u where u.data_entrada = :data_entrada";
		this.transacao = (Transaction) this.sessao.beginTransaction();
		org.hibernate.Query consulta = this.sessao.createQuery(hql);
		consulta.setDate("data_entrada", data_entrada);
		Funcionario funcionario = (Funcionario) consulta.uniqueResult();
		this.transacao.commit();
		this.sessao.close();
		return funcionario;
	}

	
	
	public List<Funcionario> listar() {
		this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
		this.transacao = (Transaction) this.sessao.beginTransaction();
		List<Funcionario> funcionarios = this.sessao.createCriteria(Funcionario.class).list();
		this.transacao.commit();
		this.sessao.close();
		return funcionarios;
	}
}
