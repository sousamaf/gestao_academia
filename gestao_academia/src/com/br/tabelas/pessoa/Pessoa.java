package com.br.tabelas.pessoa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.NaturalId;
import com.br.tabelas.cidade.Cidade;
import com.br.tabelas.empresa.Empresa;
import com.br.tabelas.endereco.Endereco;


@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7132175581437971867L;
	
	@Id
	@NaturalId
	@Column(name = "cpf")
	private Integer cpf;
	private String nome; 
	private String sexo;
	private String foto;
	@ManyToOne
	@JoinColumn(name="cidade")
	private Cidade id_cidade;
	@ManyToOne
	@JoinColumn(name="empresa")
	private Empresa id_empresa;
	@ManyToOne
	@JoinColumn(name="endereco")
	private Endereco id_endereço;
	
	
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Cidade getId_cidade() {
		return id_cidade;
	}
	public void setId_cidade(Cidade id_cidade) {
		this.id_cidade = id_cidade;
	}
	public Empresa getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(Empresa id_empresa) {
		this.id_empresa = id_empresa;
	}
	public Endereco getId_endereço() {
		return id_endereço;
	}
	public void setId_endereço(Endereco id_endereço) {
		this.id_endereço = id_endereço;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
		result = prime * result
				+ ((id_cidade == null) ? 0 : id_cidade.hashCode());
		result = prime * result
				+ ((id_empresa == null) ? 0 : id_empresa.hashCode());
		result = prime * result
				+ ((id_endereço == null) ? 0 : id_endereço.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (foto == null) {
			if (other.foto != null)
				return false;
		} else if (!foto.equals(other.foto))
			return false;
		if (id_cidade == null) {
			if (other.id_cidade != null)
				return false;
		} else if (!id_cidade.equals(other.id_cidade))
			return false;
		if (id_empresa == null) {
			if (other.id_empresa != null)
				return false;
		} else if (!id_empresa.equals(other.id_empresa))
			return false;
		if (id_endereço == null) {
			if (other.id_endereço != null)
				return false;
		} else if (!id_endereço.equals(other.id_endereço))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		return true;
	}
}
