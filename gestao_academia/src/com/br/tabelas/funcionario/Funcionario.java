package com.br.tabelas.funcionario;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.br.tabelas.empresa.Empresa;
import com.br.tabelas.pessoa.Pessoa;
import com.br.tabelas.matricula.Matricula;
import com.br.tabelas.tipo_funcionario.Tipo_funcionario;

@Entity
@Table(name = "funcionairo")
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id_funcionario")
	private Integer id_funcionario;
	private Calendar data_entrada;
	private Calendar data_saida;
	private Boolean situacao;
	private int rg;
	private String observacao;
	private int salario;
	@ManyToOne
	@JoinColumn(name = "empresa", nullable = false)
	private Empresa id_empresa;
	@ManyToOne
	@JoinColumn(name = "tipo_funcionario", nullable = false)
	private Tipo_funcionario id_tipofuncionario;
	@OneToOne
	@JoinColumn(name = "matricula", nullable = false)
	private Matricula id_matricula;
	@OneToOne
	@JoinColumn(name = "pessoa", nullable = false)
	private Pessoa cpf;
	
	
	
	public Integer getId_funcionario() {
		return id_funcionario;
	}
	public void setId_funcionario(Integer id_funcionario) {
		this.id_funcionario = id_funcionario;
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
	public Boolean getSituacao() {
		return situacao;
	}
	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}
	public int getRg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	public Empresa getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(Empresa id_empresa) {
		this.id_empresa = id_empresa;
	}
	public Tipo_funcionario getId_tipofuncionario() {
		return id_tipofuncionario;
	}
	public void setId_tipofuncionario(Tipo_funcionario id_tipofuncionario) {
		this.id_tipofuncionario = id_tipofuncionario;
	}
	public Matricula getId_matricula() {
		return id_matricula;
	}
	public void setId_matricula(Matricula id_matricula) {
		this.id_matricula = id_matricula;
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
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result
				+ ((data_entrada == null) ? 0 : data_entrada.hashCode());
		result = prime * result
				+ ((data_saida == null) ? 0 : data_saida.hashCode());
		result = prime * result
				+ ((id_empresa == null) ? 0 : id_empresa.hashCode());
		result = prime * result
				+ ((id_funcionario == null) ? 0 : id_funcionario.hashCode());
		result = prime * result
				+ ((id_matricula == null) ? 0 : id_matricula.hashCode());
		result = prime
				* result
				+ ((id_tipofuncionario == null) ? 0 : id_tipofuncionario
						.hashCode());
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + rg;
		result = prime * result + salario;
		result = prime * result
				+ ((situacao == null) ? 0 : situacao.hashCode());
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
		Funcionario other = (Funcionario) obj;
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
		if (id_empresa == null) {
			if (other.id_empresa != null)
				return false;
		} else if (!id_empresa.equals(other.id_empresa))
			return false;
		if (id_funcionario == null) {
			if (other.id_funcionario != null)
				return false;
		} else if (!id_funcionario.equals(other.id_funcionario))
			return false;
		if (id_matricula == null) {
			if (other.id_matricula != null)
				return false;
		} else if (!id_matricula.equals(other.id_matricula))
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
		if (rg != other.rg)
			return false;
		if (salario != other.salario)
			return false;
		if (situacao == null) {
			if (other.situacao != null)
				return false;
		} else if (!situacao.equals(other.situacao))
			return false;
		return true;
	}
	
}
