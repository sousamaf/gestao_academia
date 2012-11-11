package com.br.tabelas.estado;

import java.util.List;
import com.br.tabelas.estado.Estado;

public interface EstadoDao {
	public void salvar(Estado estado);
	public void atualizar(Estado estado);
	public void excluir(Estado estado);
	public Estado carregar(String estado);
	public List<Estado> listar();

}
