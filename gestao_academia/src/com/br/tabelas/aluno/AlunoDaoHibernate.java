package com.br.tabelas.aluno;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.br.conexao.HibernateUtil;
import com.br.tabelas.aluno.Aluno;

public class AlunoDaoHibernate {
	private Session sessao;
	private Transaction transacao;
	
	public AlunoDaoHibernate()
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

	public void salvar(Aluno aluno) {
		try {
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.save(aluno);
			this.transacao.commit();
		} catch (HibernateException e){
			System.out.println("Nao foi possivel inserir o aluno. Erro: " + e.getMessage());
		} finally {
			try {
				if(this.sessao.isConnected())
					this.sessao.close();
			} catch (Throwable e1) {
				System.out.println("Erro ao fechar operacao de salvar. Msg: " + e1.getMessage());			
			}
		}
		
	}
	public void atualizar(Aluno aluno) {
		try 
		{
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.merge(aluno);
			this.transacao.commit();
		} catch (HibernateException e)
		{
			System.out.println("Nao foi possivel atualizar o aluno. Erro: " + e.getMessage());
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
	
	public void excluir(Aluno aluno) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		this.sessao.delete(aluno);
		this.transacao.commit();
	}	
	
	public Aluno carregar(Integer codigo) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		Aluno aluno = (Aluno) this.sessao.get(Aluno.class, codigo);
		this.transacao.commit();
		this.sessao.close();
		return aluno;
	}
	
	public Aluno buscarPorLogin(String login) {
		String hql = "select u from Aluno u where u.login = :login";
		this.transacao = (Transaction) this.sessao.beginTransaction();
		org.hibernate.Query consulta = this.sessao.createQuery(hql);
		consulta.setString("login", login);
		Aluno aluno = (Aluno) consulta.uniqueResult();
		this.transacao.commit();
		this.sessao.close();
		return aluno;
	}

	public Aluno buscarPorEmail(String email) {
		String hql = "select u from Aluno u where u.email = :email";
		this.transacao = (Transaction) this.sessao.beginTransaction();
		org.hibernate.Query consulta = this.sessao.createQuery(hql);
		consulta.setString("email", email);
		Aluno aluno = (Aluno) consulta.uniqueResult();
		this.transacao.commit();
		this.sessao.close();
		
		return aluno;
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> listar() {
		this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
		this.transacao = (Transaction) this.sessao.beginTransaction();
		List<Aluno> alunos = this.sessao.createCriteria(Aluno.class).list();
		this.transacao.commit();
		this.sessao.close();
		
		return alunos;
	}
}
