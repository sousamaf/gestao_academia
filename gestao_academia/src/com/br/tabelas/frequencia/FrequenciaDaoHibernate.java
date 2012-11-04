package com.br.tabelas.frequencia;

import java.util.Calendar;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.br.conexao.HibernateUtil;
import com.br.tabelas.frequencia.Frequencia;

public class FrequenciaDaoHibernate {
	private Session sessao;
	private Transaction transacao;
	
	public FrequenciaDaoHibernate()
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
	
	public void salvar(Frequencia frequencia) {
		try {
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.save(frequencia);
			this.transacao.commit();
		} catch (HibernateException e){
			System.out.println("Nao foi possivel inserir a frequencia. Erro: " + e.getMessage());
		} finally {
			try {
				if(this.sessao.isConnected())
					this.sessao.close();
			} catch (Throwable e1) {
				System.out.println("Erro ao fechar operacao de salvar. Msg: " + e1.getMessage());			
			}
		}
		
	}

	
	public void atualizar(Frequencia frequencia){
		try 
		{
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.update(frequencia);
			this.sessao.merge(frequencia);
			this.transacao.commit();
		} catch (HibernateException e)
		{
			System.out.println("Nao foi possivel atualizar a frequencia. Erro: " + e.getMessage());
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

	
	public void excluir(Frequencia frequencia) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		this.sessao.delete(frequencia);
		this.transacao.commit();
	}


	public Frequencia carregar(Calendar data_inicio) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		Frequencia frequencia = (Frequencia) this.sessao.get(Frequencia.class, data_inicio);
		this.transacao.commit();
		this.sessao.close();
		return frequencia;
		
	}
	
	public Frequencia buscarPorHorario(Calendar horario) {
		String hql = "select u from Frequencia u where u.horario = :horario";
		this.transacao = (Transaction) this.sessao.beginTransaction();
		org.hibernate.Query consulta = this.sessao.createQuery(hql);
		consulta.setCalendar("horario", horario);
		Frequencia frequencia = (Frequencia) consulta.uniqueResult();
		this.transacao.commit();
		this.sessao.close();
		return frequencia;
	}

	
	
	public List<Frequencia> listar() {
		this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
		this.transacao = (Transaction) this.sessao.beginTransaction();
		List<Frequencia> frequencias = this.sessao.createCriteria(Frequencia.class).list();
		this.transacao.commit();
		this.sessao.close();
		return frequencias;
	}
}
