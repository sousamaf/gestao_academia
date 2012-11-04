package com.br.tabelas.tipo_usuario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_usuario")
public class Tipo_usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id_tipousuario")
	private Integer id_tipousuario;
	private String privilegio;
	private String descricao;
	
	
	public Integer getId_tipousuario() {
		return id_tipousuario;
	}
	public void setId_tipousuario(Integer id_tipousuario) {
		this.id_tipousuario = id_tipousuario;
	}
	public String getPrivilegio() {
		return privilegio;
	}
	public void setPrivilegio(String privilegio) {
		this.privilegio = privilegio;
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
		result = prime * result
				+ ((id_tipousuario == null) ? 0 : id_tipousuario.hashCode());
		result = prime * result
				+ ((privilegio == null) ? 0 : privilegio.hashCode());
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
		Tipo_usuario other = (Tipo_usuario) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id_tipousuario == null) {
			if (other.id_tipousuario != null)
				return false;
		} else if (!id_tipousuario.equals(other.id_tipousuario))
			return false;
		if (privilegio == null) {
			if (other.privilegio != null)
				return false;
		} else if (!privilegio.equals(other.privilegio))
			return false;
		return true;
	}
}
