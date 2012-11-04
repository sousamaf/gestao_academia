package com.br.tabelas.usuario;

import java.util.List;
import com.br.tabelas.usuario.Usuario;

public interface UsuarioDao {
	public void salvar(Usuario usuairo);
	public void atualizar(Usuario usuairo);
	public void excluir(Usuario usuairo);
	public Usuario carregar(String login);
	public Usuario buscarPorPrivilegio(String privilegio);
	public List<Usuario> listar();
}
