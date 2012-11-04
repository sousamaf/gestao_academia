package com.br.tabelas.matricula;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id_matricula")
	private Integer id_matricula;
	private Date data_matricula;
	private Boolean situacao_matricula;
	private Date data_cancelamento;
	private String motivo_cancelamento;
	
	public Integer getId_matricula() {
		return id_matricula;
	}
	public void setId_matricula(Integer id_matricula) {
		this.id_matricula = id_matricula;
	}
	public Date getData_matricula() {
		return data_matricula;
	}
	public void setData_matricula(Date data_matricula) {
		this.data_matricula = data_matricula;
	}
	public Boolean getSituacao_matricula() {
		return situacao_matricula;
	}
	public void setSituacao_matricula(Boolean situacao_matricula) {
		this.situacao_matricula = situacao_matricula;
	}
	public Date getData_cancelamento() {
		return data_cancelamento;
	}
	public void setData_cancelamento(Date data_cancelamento) {
		this.data_cancelamento = data_cancelamento;
	}
	public String getMotivo_cancelamento() {
		return motivo_cancelamento;
	}
	public void setMotivo_cancelamento(String motivo_cancelamento) {
		this.motivo_cancelamento = motivo_cancelamento;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((data_cancelamento == null) ? 0 : data_cancelamento
						.hashCode());
		result = prime * result
				+ ((data_matricula == null) ? 0 : data_matricula.hashCode());
		result = prime * result
				+ ((id_matricula == null) ? 0 : id_matricula.hashCode());
		result = prime
				* result
				+ ((motivo_cancelamento == null) ? 0 : motivo_cancelamento
						.hashCode());
		result = prime
				* result
				+ ((situacao_matricula == null) ? 0 : situacao_matricula
						.hashCode());
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
		Matricula other = (Matricula) obj;
		if (data_cancelamento == null) {
			if (other.data_cancelamento != null)
				return false;
		} else if (!data_cancelamento.equals(other.data_cancelamento))
			return false;
		if (data_matricula == null) {
			if (other.data_matricula != null)
				return false;
		} else if (!data_matricula.equals(other.data_matricula))
			return false;
		if (id_matricula == null) {
			if (other.id_matricula != null)
				return false;
		} else if (!id_matricula.equals(other.id_matricula))
			return false;
		if (motivo_cancelamento == null) {
			if (other.motivo_cancelamento != null)
				return false;
		} else if (!motivo_cancelamento.equals(other.motivo_cancelamento))
			return false;
		if (situacao_matricula == null) {
			if (other.situacao_matricula != null)
				return false;
		} else if (!situacao_matricula.equals(other.situacao_matricula))
			return false;
		return true;
	}

}
