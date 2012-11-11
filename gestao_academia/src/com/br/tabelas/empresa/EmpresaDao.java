package com.br.tabelas.empresa;

import java.util.List;
import com.br.tabelas.empresa.Empresa;

public interface EmpresaDao {
	public void salvar(Empresa empresa);
	public void atualizar(Empresa empresa);
	public void excluir(Empresa empresa);
	public Empresa carregar(Integer id_empresa);
	public Empresa buscarPorCnpj(String cnpj);
	public List<Empresa> listar();

}
