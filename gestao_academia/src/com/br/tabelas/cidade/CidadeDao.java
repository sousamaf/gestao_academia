package com.br.tabelas.cidade;

import java.util.List;
import com.br.tabelas.cidade.Cidade;

public interface CidadeDao {
	public void salvar(Cidade cidade);
	public void atualizar(Cidade cidade);
	public void excluir(Cidade cidade);
	public Cidade carregar(Integer id_cidade);
	public Cidade buscarPorCidade(String cidade);
	public List<Cidade> listar();
}
