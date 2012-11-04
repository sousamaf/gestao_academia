package com.br.tabelas.matricula;

import java.sql.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.br.conexao.HibernateUtil;
import com.br.tabelas.matricula.Matricula;



public class MatriculaDaoHibernate {

	private Session sessao;
	private Transaction transacao;
	
	public MatriculaDaoHibernate()
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
	
	public void salvar(Matricula matricula) {
		try {
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.save(matricula);
			this.transacao.commit();
		} catch (HibernateException e){
			System.out.println("Nao foi possivel inserir a matricula. Erro: " + e.getMessage());
		} finally {
			try {
				if(this.sessao.isConnected())
					this.sessao.close();
			} catch (Throwable e1) {
				System.out.println("Erro ao fechar operacao de salvar. Msg: " + e1.getMessage());			
			}
		}
		
	}

	
	public void atualizar(Matricula matricula) {
		try 
		{
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.update(matricula);
			this.sessao.merge(matricula);
			this.transacao.commit();
		} catch (HibernateException e)
		{
			System.out.println("Nao foi possivel atualizar a matricula. Erro: " + e.getMessage());
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

	
	public void excluir(Matricula matricula) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		this.sessao.delete(matricula);
		this.transacao.commit();
	}


	public Matricula carregar(Integer id_matricula) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		Matricula matricula = (Matricula) this.sessao.get(Matricula.class, id_matricula);
		this.transacao.commit();
		this.sessao.close();
		return matricula;
		
	}
	
	public Matricula buscarPorData(Date data_matricula) {
		String hql = "select u from Matricula u where u.data_matricula = :data_matricula";
		this.transacao = (Transaction) this.sessao.beginTransaction();
		org.hibernate.Query consulta = this.sessao.createQuery(hql);
		consulta.setDate("data_matricula", data_matricula);
		Matricula matricula = (Matricula) consulta.uniqueResult();
		this.transacao.commit();
		this.sessao.close();
		return matricula;
	}

	
	
	public List<Matricula> listar() {
		this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
		this.transacao = (Transaction) this.sessao.beginTransaction();
		List<Matricula> funcionarios = this.sessao.createCriteria(Matricula.class).list();
		this.transacao.commit();
		this.sessao.close();
		return funcionarios;
	}
}
