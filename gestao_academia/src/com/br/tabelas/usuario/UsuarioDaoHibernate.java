package com.br.tabelas.usuario;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.br.conexao.HibernateUtil;
import com.br.tabelas.usuario.Usuario;

public class UsuarioDaoHibernate {
	
	private Session sessao;
	private Transaction transacao;
	
	public UsuarioDaoHibernate()
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
	
	public void salvar(Usuario usuario) {
		try {
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.save(usuario);
			this.transacao.commit();
		} catch (HibernateException e){
			System.out.println("Nao foi possivel inserir o usuario. Erro: " + e.getMessage());
		} finally {
			try {
				if(this.sessao.isConnected())
					this.sessao.close();
			} catch (Throwable e1) {
				System.out.println("Erro ao fechar operacao de salvar. Msg: " + e1.getMessage());			
			}
		}
		
	}

	
	public void atualizar(Usuario usuario){
		try 
		{
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.update(usuario);
			this.sessao.merge(usuario);
			this.transacao.commit();
		} catch (HibernateException e)
		{
			System.out.println("Nao foi possivel atualizar o usuario. Erro: " + e.getMessage());
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

	
	public void excluir(Usuario usuario) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		this.sessao.delete(usuario);
		this.transacao.commit();
	}


	public Usuario carregar(String login) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		Usuario usuario = (Usuario) this.sessao.get(Usuario.class, login);
		this.transacao.commit();
		this.sessao.close();
		return usuario;
		
	}
	
	public Usuario buscarPorPrivilegio(String privilegio) {
		String hql = "select u from Usuario u where u.privilegio = :privilegio";
		this.transacao = (Transaction) this.sessao.beginTransaction();
		org.hibernate.Query consulta = this.sessao.createQuery(hql);
		consulta.setString("privilegio", privilegio);
		Usuario usuario = (Usuario) consulta.uniqueResult();
		this.transacao.commit();
		this.sessao.close();
		return usuario;
	}

	
	
	public List<Usuario> listar() {
		this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
		this.transacao = (Transaction) this.sessao.beginTransaction();
		List<Usuario> funcionarios = this.sessao.createCriteria(Usuario.class).list();
		this.transacao.commit();
		this.sessao.close();
		return funcionarios;
	}
}
