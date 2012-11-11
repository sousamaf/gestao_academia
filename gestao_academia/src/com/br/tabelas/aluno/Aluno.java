package com.br.tabelas.aluno;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.br.tabelas.matricula.Matricula;
import com.br.tabelas.pessoa.Pessoa;
import com.br.tabelas.situacao_aluno.Situacao_aluno;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {
	

	private static final long serialVersionUID = 2471765773806278661L;
	@Id
	@GeneratedValue
	@Column(name = "id_aluno")
	private Integer id_aluno;
	private Calendar data_entrada;
	private Calendar data_saida;
	private String observacao;
	@OneToOne
	@JoinColumn(name="pessoa")
	private Pessoa cpf;
	@ManyToOne
	@JoinColumn(name="situacao_aluno")
	private Situacao_aluno id_situacao;
	@OneToOne
	@JoinColumn(name="matricula")
	private Matricula id_matricula;
	
	
	
	public Integer getId_aluno() {
		return id_aluno;
	}
	public void setId_aluno(Integer id_aluno) {
		this.id_aluno = id_aluno;
	}
	public Calendar getData_entrada() {
		return data_entrada;
	}
	public void setData_entrada(Calendar data_entrada) {
		this.data_entrada = data_entrada;
	}
	public Calendar getData_saida() {
		return data_saida;
	}
	public void setData_saida(Calendar data_saida) {
		this.data_saida = data_saida;
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
	public Situacao_aluno getId_situacao() {
		return id_situacao;
	}
	public void setId_situacao(Situacao_aluno id_situacao) {
		this.id_situacao = id_situacao;
	}
	public Matricula getId_matricula() {
		return id_matricula;
	}
	public void setId_matricula(Matricula id_matricula) {
		this.id_matricula = id_matricula;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result
				+ ((data_entrada == null) ? 0 : data_entrada.hashCode());
		result = prime * result
				+ ((data_saida == null) ? 0 : data_saida.hashCode());
		result = prime * result
				+ ((id_aluno == null) ? 0 : id_aluno.hashCode());
		result = prime * result
				+ ((id_matricula == null) ? 0 : id_matricula.hashCode());
		result = prime * result
				+ ((id_situacao == null) ? 0 : id_situacao.hashCode());
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
		Aluno other = (Aluno) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (data_entrada == null) {
			if (other.data_entrada != null)
				return false;
		} else if (!data_entrada.equals(other.data_entrada))
			return false;
		if (data_saida == null) {
			if (other.data_saida != null)
				return false;
		} else if (!data_saida.equals(other.data_saida))
			return false;
		if (id_aluno == null) {
			if (other.id_aluno != null)
				return false;
		} else if (!id_aluno.equals(other.id_aluno))
			return false;
		if (id_matricula == null) {
			if (other.id_matricula != null)
				return false;
		} else if (!id_matricula.equals(other.id_matricula))
			return false;
		if (id_situacao == null) {
			if (other.id_situacao != null)
				return false;
		} else if (!id_situacao.equals(other.id_situacao))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		return true;
	}	
}
