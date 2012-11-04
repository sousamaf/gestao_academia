package com.br.tabelas.situacao_aluno;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "situacao_aluno")
public class Situacao_aluno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8191298575349476415L;

	@Id
	@GeneratedValue
	@Column(name = "id_situacao")
	private int id_situacao;
	private String descricao;
	
	public int getId_situacao() {
		return id_situacao;
	}
	public void setId_situacao(int id_situacao) {
		this.id_situacao = id_situacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + id_situacao;
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
		Situacao_aluno other = (Situacao_aluno) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id_situacao != other.id_situacao)
			return false;
		return true;
	}

}
