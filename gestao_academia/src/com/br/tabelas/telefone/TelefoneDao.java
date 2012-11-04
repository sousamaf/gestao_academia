package com.br.tabelas.telefone;

import java.util.List;
import com.br.tabelas.telefone.Telefone;

public interface TelefoneDao {
	public void salvar(Telefone telefone);
	public void atualizar(Telefone telefone);
	public void excluir(Telefone telefone);
	public Telefone carregar(int telefone_residencial);
	public Telefone buscarPorTelefone(int telefone_comercial);
	public List<Telefone> listar();
}
