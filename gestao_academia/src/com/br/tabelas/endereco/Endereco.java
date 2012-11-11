package com.br.tabelas.endereco;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.br.tabelas.cidade.Cidade;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2799795395531106767L;
	
	@Id
	@GeneratedValue
	@Column(name = "endereco")
	private Integer id_endereco;
	private String rua;
	private int numero;
	private String bairro;
	private String complemento;
	private int cep;
	@ManyToOne
	@JoinColumn(name="cidade")
	private Cidade id_cidade;
	
	
	
	public Integer getId_endereco() {
		return id_endereco;
	}
	public void setId_endereco(Integer id_endereco) {
		this.id_endereco = id_endereco;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public Cidade getId_cidade() {
		return id_cidade;
	}
	public void setId_cidade(Cidade id_cidade) {
		this.id_cidade = id_cidade;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + cep;
		result = prime * result
				+ ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result
				+ ((id_cidade == null) ? 0 : id_cidade.hashCode());
		result = prime * result
				+ ((id_endereco == null) ? 0 : id_endereco.hashCode());
		result = prime * result + numero;
		result = prime * result + ((rua == null) ? 0 : rua.hashCode());
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
		Endereco other = (Endereco) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep != other.cep)
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (id_cidade == null) {
			if (other.id_cidade != null)
				return false;
		} else if (!id_cidade.equals(other.id_cidade))
			return false;
		if (id_endereco == null) {
			if (other.id_endereco != null)
				return false;
		} else if (!id_endereco.equals(other.id_endereco))
			return false;
		if (numero != other.numero)
			return false;
		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua))
			return false;
		return true;
	}
}
