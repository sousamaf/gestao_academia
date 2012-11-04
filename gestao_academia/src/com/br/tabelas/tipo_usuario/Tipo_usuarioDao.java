package com.br.tabelas.tipo_usuario;

import java.util.List;
import com.br.tabelas.tipo_usuario.Tipo_usuario;

public interface Tipo_usuarioDao {
	public void salvar(Tipo_usuario tipo_usuario);
	public void atualizar(Tipo_usuario tipo_usuario);
	public void excluir(Tipo_usuario tipo_usuario);
	public Tipo_usuario carregar(Integer id_tipousuario);
	public Tipo_usuario buscarPorPrivilegio(String privilegio);
	public List<Tipo_usuario> listar();
}
