package com.br.tabelas.funcionario;

import java.sql.Date;
import java.util.List;


public interface FuncionarioDao {

	public void salvar(Funcionario funcionaio);
	public void atualizar(Funcionario funcionaio);
	public void excluir(Funcionario funcionaio);
	public Funcionario carregar(Integer id_funcionario);
	public Funcionario buscarPorData(Date data_entrada);
	public Funcionario buscarPorSalario(int salario);
	public List<Funcionario> listar();
}
