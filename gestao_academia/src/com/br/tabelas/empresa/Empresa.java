package com.br.tabelas.empresa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.br.tabelas.endereco.Endereco;


@Entity
@Table(name = "empresa")
public class Empresa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5870217531117632118L;

	@Id
	@GeneratedValue
	@Column(name = "id_empresa")
	private Integer id_empresa;
	private String cnpj;
	@OneToOne
	@JoinColumn(name="endereco")
	private Endereco id_endereco;
	
	
	
	public Integer getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(Integer id_empresa) {
		this.id_empresa = id_empresa;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Endereco getId_endereco() {
		return id_endereco;
	}
	public void setId_endereco(Endereco id_endereco) {
		this.id_endereco = id_endereco;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result
				+ ((id_empresa == null) ? 0 : id_empresa.hashCode());
		result = prime * result
				+ ((id_endereco == null) ? 0 : id_endereco.hashCode());
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
		Empresa other = (Empresa) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (id_empresa == null) {
			if (other.id_empresa != null)
				return false;
		} else if (!id_empresa.equals(other.id_empresa))
			return false;
		if (id_endereco == null) {
			if (other.id_endereco != null)
				return false;
		} else if (!id_endereco.equals(other.id_endereco))
			return false;
		return true;
	}
}
