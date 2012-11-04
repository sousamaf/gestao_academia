package com.br.tabelas.tipo_usuario;

import java.sql.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.br.conexao.HibernateUtil;
import com.br.tabelas.tipo_usuario.Tipo_usuario;

public class Tipo_usuarioDaoHibernate {
	
	private Session sessao;
	private Transaction transacao;
	
	public Tipo_usuarioDaoHibernate()
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
	
	public void salvar(Tipo_usuario tipo_usuario) {
		try {
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.save(tipo_usuario);
			this.transacao.commit();
		} catch (HibernateException e){
			System.out.println("Nao foi possivel inserir o tipo de usuario. Erro: " + e.getMessage());
		} finally {
			try {
				if(this.sessao.isConnected())
					this.sessao.close();
			} catch (Throwable e1) {
				System.out.println("Erro ao fechar operacao de salvar. Msg: " + e1.getMessage());			
			}
		}
		
	}

	
	public void atualizar(Tipo_usuario tipo_usuario) {
		try 
		{
			this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
			this.transacao = (Transaction) this.sessao.beginTransaction();
			this.sessao.update(tipo_usuario);
			this.sessao.merge(tipo_usuario);
			this.transacao.commit();
		} catch (HibernateException e)
		{
			System.out.println("Nao foi possivel atualizar o tipo de usuario. Erro: " + e.getMessage());
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

	
	public void excluir(Tipo_usuario tipo_usuario) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		this.sessao.delete(tipo_usuario);
		this.transacao.commit();
	}


	public Tipo_usuario carregar(Integer id_tipousuario) {
		this.transacao = (Transaction) this.sessao.beginTransaction();
		Tipo_usuario tp_usuario = (Tipo_usuario) this.sessao.get(Tipo_usuario.class, id_tipousuario);
		this.transacao.commit();
		this.sessao.close();
		return tp_usuario;
		
	}
	
	public Tipo_usuario buscarPorPrivilegio(String privilegio) {
		String hql = "select u from Tipo_usuario u where u.privilegio = :privilegio";
		this.transacao = (Transaction) this.sessao.beginTransaction();
		org.hibernate.Query consulta = this.sessao.createQuery(hql);
		consulta.setString("privilegio", privilegio);
		Tipo_usuario tp_usuario = (Tipo_usuario) consulta.uniqueResult();
		this.transacao.commit();
		this.sessao.close();
		return tp_usuario;
	}
	
	public List<Tipo_usuario> listar() {
		this.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
		this.transacao = (Transaction) this.sessao.beginTransaction();
		List<Tipo_usuario> tipo_usuarios = this.sessao.createCriteria(Tipo_usuario.class).list();
		this.transacao.commit();
		this.sessao.close();
		return tipo_usuarios;
	}
}
