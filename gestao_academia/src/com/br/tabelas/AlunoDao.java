package com.br.tabelas;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import com.br.conexao.HibernateUtil;

public class AlunoDao {
	private Session sessao;
	private Transaction transacao;

	public void salvar(Aluno aluno)
	{
		try{
			this.sessao = HibernateUtil.getSessionFactory().openSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.save(aluno);
			this.transacao.commit();
		} catch (HibernateException e) {
			System.out.println("Nao foi possivel inserir o contato. Erro: " + e.getMessage());
		} finally {
			try{
				this.sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operacao de insercao. Mensagem: " + e.getMessage());
			}
		}		
	}
	public void atualizar(Aluno aluno)
	{
		try
		{
			this.sessao = HibernateUtil.getSessionFactory().openSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.update(aluno);
			this.transacao.commit();
		} catch (HibernateException e)
		{
			System.out.println("Nao foi possivel alterar o contato. Erro: " + e.getMessage());
		} finally
		{
			try
			{
				if(this.sessao.isOpen())
				{
					this.sessao.close();
				}
			}
			catch(Throwable e)
			{
					System.out.println("Erro ao fechar a operacao de atualizacao. Erro: " + e.getMessage());

			}
		}
		
	}
	
	public void excluir(Aluno aluno) 
	{
		try
		{
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(aluno);
			transacao.commit();
		}
		catch(HibernateException e)
		{
			System.out.println("Nao foi possivel excluir o contato. Erro: " + e.getMessage());
		}
		finally
		{
			try
			{
				if(this.sessao.isOpen())
				{
					this.sessao.close();
				}
			}
			catch(Throwable e)
			{
				System.out.println("Erro ao fechar operacao de exclusao. Mensagem: " + e.getMessage());
			}
		}
	}
	
	public Aluno getAluno(Integer codigo)
	{
		Aluno aluno = null;
		try
		{	
			this.sessao = HibernateUtil.getSessionFactory().openSession();
			this.transacao = this.sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Aluno.class);
			filtro.add(Restrictions.eq("codigo", codigo));
			aluno = (Aluno) filtro.uniqueResult();
			this.transacao.commit();
		}catch(Throwable e)
		{
			if(this.transacao.isActive())
			{
				this.transacao.rollback();
			}
		} finally
		{
			try
			{ 
				if(this.sessao.isOpen())
				{ 
					this.sessao.close();
				}
			}catch(Throwable e)
			{
				System.out.println("Erro ao fechar operacao de busca. Erro: " + e.getMessage());
			}
			
		}
		return aluno;
	}
	
	
	public Aluno buscaAluno(String dado,String campo) {
		Aluno aluno = null;

		try {
			this.sessao = HibernateUtil.getSessionFactory().openSession();
			this.transacao = this.sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Aluno.class);
			filtro.add(Restrictions.eq(dado, campo));
			aluno = (Aluno) filtro.uniqueResult();
			this.transacao.commit();
		} catch (Throwable e) {
			if (this.transacao.isActive()) {
				this.transacao.rollback();
			}
		} finally {
			try {
				if (this.sessao.isOpen()) {
					this.sessao.close();
				}
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operação de busca de usuario. Mensagem: " + e.getMessage());
			}
		}
		return aluno;
	}
	

	public List<Aluno> listar()
	{
		List<Aluno> aluno = null;
		try
		{
			this.sessao = HibernateUtil.getSessionFactory().openSession();
			this.transacao = this.sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Aluno.class);
			aluno = (List<Aluno>) filtro.list();
			this.transacao.commit();
		} catch (Throwable e)
		{
			if(this.transacao.isActive())
				this.transacao.rollback();
		} finally
		{
			try
			{
				if(this.sessao.isOpen())
					this.sessao.close();
			}catch(Throwable e)
			{
				System.out.println("Erro ao fechar operacao de busca de contato. Erro: " + e.getMessage());
			}
		}
		return aluno;
	}
}
