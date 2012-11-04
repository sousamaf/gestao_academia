package com.br.tabelas.frequencia;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import bd.beans.Aluno;

@Entity
@Table(name = "frequencia")
public class Frequencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9136700060041052537L;

	@Id
	@GeneratedValue
	@Column(name = "id_frequencia")
	private Integer id_frequencia;
	private Calendar data_inicio;
	private Calendar data_final;
	private Calendar horario;
	private String observacao;
	@OneToOne
	@JoinColumn(name = "aluno")
	private Aluno id_aluno;

	public Integer getId_frequencia() {
		return id_frequencia;
	}

	public void setId_frequencia(Integer id_frequencia) {
		this.id_frequencia = id_frequencia;
	}

	public Calendar getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Calendar data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Calendar getData_final() {
		return data_final;
	}

	public void setData_final(Calendar data_final) {
		this.data_final = data_final;
	}

	public Calendar getHorario() {
		return horario;
	}

	public void setHorario(Calendar horario) {
		this.horario = horario;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Aluno getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(Aluno id_aluno) {
		this.id_aluno = id_aluno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((data_final == null) ? 0 : data_final.hashCode());
		result = prime * result
				+ ((data_inicio == null) ? 0 : data_inicio.hashCode());
		result = prime * result + ((horario == null) ? 0 : horario.hashCode());
		result = prime * result
				+ ((id_aluno == null) ? 0 : id_aluno.hashCode());
		result = prime * result
				+ ((id_frequencia == null) ? 0 : id_frequencia.hashCode());
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
		Frequencia other = (Frequencia) obj;
		if (data_final == null) {
			if (other.data_final != null)
				return false;
		} else if (!data_final.equals(other.data_final))
			return false;
		if (data_inicio == null) {
			if (other.data_inicio != null)
				return false;
		} else if (!data_inicio.equals(other.data_inicio))
			return false;
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		if (id_aluno == null) {
			if (other.id_aluno != null)
				return false;
		} else if (!id_aluno.equals(other.id_aluno))
			return false;
		if (id_frequencia == null) {
			if (other.id_frequencia != null)
				return false;
		} else if (!id_frequencia.equals(other.id_frequencia))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		return true;
	}
}
