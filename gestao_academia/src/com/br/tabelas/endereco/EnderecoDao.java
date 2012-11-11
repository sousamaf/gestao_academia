package com.br.tabelas.endereco;

import java.util.List;
import com.br.tabelas.endereco.Endereco;

public interface EnderecoDao {
	public void salvar(Endereco endereco);
	public void atualizar(Endereco endereco);
	public void excluir(Endereco endereco);
	public Endereco carregar(String rua);
	public Endereco buscarPorBairro(String bairro);
	public List<Endereco> listar();

}
