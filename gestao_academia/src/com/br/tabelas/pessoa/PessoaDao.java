package com.br.tabelas.pessoa;

import java.util.List;

import com.br.tabelas.pessoa.Pessoa;

public interface PessoaDao {
	public void salvar(Pessoa pessoa);
	public void atualizar(Pessoa pessoa);
	public void excluir(Pessoa pessoa);
	public List<Pessoa> listar();

}
