package com.br.tabelas.telefone;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import bd.beans.Pessoa;
import com.br.tabelas.telefone.Telefone;

@Entity
@Table(name = "telefone")
public class Telefone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3324709129036520584L;

	@Id
	@GeneratedValue
	@Column(name = "id_telefone")
	private int id_telefone;
	private int telefone_comercial;
	private int telefone_residencial;
	private int celular;
	private String observacao;
	@ManyToOne
	@JoinColumn(name="pessoa")
	private Pessoa cpf;
	public int getId_telefone() {
		return id_telefone;
	}
	public void setId_telefone(int id_telefone) {
		this.id_telefone = id_telefone;
	}
	public int getTelefone_comercial() {
		return telefone_comercial;
	}
	public void setTelefone_comercial(int telefone_comercial) {
		this.telefone_comercial = telefone_comercial;
	}
	public int getTelefone_residencial() {
		return telefone_residencial;
	}
	public void setTelefone_residencial(int telefone_residencial) {
		this.telefone_residencial = telefone_residencial;
	}
	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Pessoa getCpf() {
		return cpf;
	}
	public void setCpf(Pessoa cpf) {
		this.cpf = cpf;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + celular;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + id_telefone;
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + telefone_comercial;
		result = prime * result + telefone_residencial;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		if (celular != other.celular)
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (id_telefone != other.id_telefone)
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (telefone_comercial != other.telefone_comercial)
			return false;
		if (telefone_residencial != other.telefone_residencial)
			return false;
		return true;
	}
}
