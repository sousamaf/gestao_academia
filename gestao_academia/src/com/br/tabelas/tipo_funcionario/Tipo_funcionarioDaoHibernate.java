package com.br.tabelas.tipo_funcionario;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.br.conexao.HibernateUtil;
import com.br.tabelas.tipo_funcionario.Tipo_funcionario;

public class Tipo_funcionarioDaoHibernate {
	
	private Session sessao;
	private Transaction transacao;
	
	public Tipo_funcionarioDaoHibernate()
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
	
	public void salvar(Tipo_funcionario tp_funcionario) {
		try {
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.save(tp_funcionario);
			this.transacao.commit();
		} catch (HibernateException e){
			System.out.println("Nao foi possivel inserir o tipo de funcionario. Erro: " + e.getMessage());
		} finally {
			try {
				if(this.sessao.isConnected())
					this.sessao.close();
			} catch (Throwable e1) {
				System.out.println("Erro ao fechar operacao de salvar. Msg: " + e1.getMessage());			
			}
		}
		
	}

	
	public void atualizar(Tipo_funcionario tp_funcionario){
		try 
		{
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.update(tp_funcionario);
			this.sessao.merge(tp_funcionario);
			this.transacao.commit();
		} catch (HibernateException e)
		{
			System.out.println("Nao foi possivel atualizar o tipo de funcionario. Erro: " + e.getMessage());
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

	
	public void excluir(Tipo_funcionario tp_funcionario) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		this.sessao.delete(tp_funcionario);
		this.transacao.commit();
	}


	public Tipo_funcionario carregar(Integer id_tipofuncionario) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		Tipo_funcionario tp_funcionario = (Tipo_funcionario) this.sessao.get(Tipo_funcionario.class, id_tipofuncionario);
		this.transacao.commit();
		this.sessao.close();
		return tp_funcionario;
		
	}
	
	public Tipo_funcionario buscarPorCargo(String cargo) {
		String hql = "select u from Tipo_funcionario u where u.cargo = :cargo";
		this.transacao = (Transaction) this.sessao.beginTransaction();
		org.hibernate.Query consulta = this.sessao.createQuery(hql);
		consulta.setString("cargo", cargo);
		Tipo_funcionario tp_funcionario = (Tipo_funcionario) consulta.uniqueResult();
		this.transacao.commit();
		this.sessao.close();
		return tp_funcionario;
	}

	public List<Tipo_funcionario> listar() {
		this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
		this.transacao = (Transaction) this.sessao.beginTransaction();
		List<Tipo_funcionario> tps_funcionarios = this.sessao.createCriteria(Tipo_funcionario.class).list();
		this.transacao.commit();
		this.sessao.close();
		return tps_funcionarios;
	}

}
