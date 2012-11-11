package com.br.tabelas.cidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.br.tabelas.estado.Estado;



@Entity
@Table(name = "cidade")
public class Cidade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3613768810474674148L;
	
	@Id
	@GeneratedValue
	@Column(name = "cidade")
	private Integer id_cidade;
	private String cidade;
	@ManyToOne
	@JoinColumn(name="estado")
	private Estado id_estado;
	
	
	public Integer getId_cidade() {
		return id_cidade;
	}
	public void setId_cidade(Integer id_cidade) {
		this.id_cidade = id_cidade;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Estado getId_estado() {
		return id_estado;
	}
	public void setId_estado(Estado id_estado) {
		this.id_estado = id_estado;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result
				+ ((id_cidade == null) ? 0 : id_cidade.hashCode());
		result = prime * result
				+ ((id_estado == null) ? 0 : id_estado.hashCode());
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
		Cidade other = (Cidade) obj;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (id_cidade == null) {
			if (other.id_cidade != null)
				return false;
		} else if (!id_cidade.equals(other.id_cidade))
			return false;
		if (id_estado == null) {
			if (other.id_estado != null)
				return false;
		} else if (!id_estado.equals(other.id_estado))
			return false;
		return true;
	}
}
