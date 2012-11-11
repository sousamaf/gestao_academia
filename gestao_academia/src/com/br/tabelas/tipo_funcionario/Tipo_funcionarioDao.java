package com.br.tabelas.tipo_funcionario;

import java.util.List;
import com.br.tabelas.tipo_funcionario.Tipo_funcionario;

public interface Tipo_funcionarioDao {
	public void salvar(Tipo_funcionario tp_funcionario);
	public void atualizar(Tipo_funcionario tp_funcionario);
	public void excluir(Tipo_funcionario tp_funcionario);
	public Tipo_funcionario carregar(Integer id_tipofuncionario);
	public Tipo_funcionario buscarPorCargo(String cargo);
	public List<Tipo_funcionario> listar();

}
