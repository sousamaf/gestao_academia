package com.br.tabelas.tipo_funcionario;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tipo_funcionario")
public class Tipo_funcionario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 214615901366213922L;
	
	@Id
	@GeneratedValue
	@Column(name="id_tpfuncionario")
	private Integer id_tipofuncionario;
	private String cargo;
	private String observacao;
	
	
	
	public Integer getId_tipofuncionario() {
		return id_tipofuncionario;
	}
	public void setId_tipofuncionario(Integer id_tipofuncionario) {
		this.id_tipofuncionario = id_tipofuncionario;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime
				* result
				+ ((id_tipofuncionario == null) ? 0 : id_tipofuncionario
						.hashCode());
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
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
		Tipo_funcionario other = (Tipo_funcionario) obj;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (id_tipofuncionario == null) {
			if (other.id_tipofuncionario != null)
				return false;
		} else if (!id_tipofuncionario.equals(other.id_tipofuncionario))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		return true;
	}
}
