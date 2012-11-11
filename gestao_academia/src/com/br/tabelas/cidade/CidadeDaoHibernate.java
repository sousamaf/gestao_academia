package com.br.tabelas.cidade;


import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.br.conexao.HibernateUtil;
import com.br.tabelas.cidade.Cidade;

public class CidadeDaoHibernate {
	
	private Session sessao;
	private Transaction transacao;
	
	public CidadeDaoHibernate()
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
	
	public void salvar(Cidade cidade) {
		try {
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.save(cidade);
			this.transacao.commit();
		} catch (HibernateException e){
			System.out.println("Nao foi possivel inserir a cidade. Erro: " + e.getMessage());
		} finally {
			try {
				if(this.sessao.isConnected())
					this.sessao.close();
			} catch (Throwable e1) {
				System.out.println("Erro ao fechar operacao de salvar. Msg: " + e1.getMessage());			
			}
		}
		
	}

	
	public void atualizar(Cidade cidade) {
		try 
		{
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.update(cidade);
			this.sessao.merge(cidade);
			this.transacao.commit();
		} catch (HibernateException e)
		{
			System.out.println("Nao foi possivel atualizar a cidade. Erro: " + e.getMessage());
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

	
	public void excluir(Cidade cidade) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		this.sessao.delete(cidade);
		this.transacao.commit();
	}


	public Cidade carregar(Integer id_cidade) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		Cidade cidade = (Cidade) this.sessao.get(Cidade.class, id_cidade);
		this.transacao.commit();
		this.sessao.close();
		return cidade;
	}
	
	public Cidade buscarPorCidade(String cidade) {
		String hql = "select u from Cidade u where u.cidade = :cidade";
		this.transacao = (Transaction) this.sessao.beginTransaction();
		org.hibernate.Query consulta = this.sessao.createQuery(hql);
		consulta.setString("cidade", cidade);
		Cidade cid = (Cidade) consulta.uniqueResult();
		this.transacao.commit();
		this.sessao.close();
		return cid;
	}

	public List<Cidade> listar() {
		this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
		this.transacao = (Transaction) this.sessao.beginTransaction();
		List<Cidade> cidades = this.sessao.createCriteria(Cidade.class).list();
		this.transacao.commit();
		this.sessao.close();
		return cidades;
	}

}
