package com.br.tabelas.aluno;

import java.util.List;

public interface AlunoDao {
	public void salvar(Aluno contato);

	public void atualizar(Aluno contato);

	public void excluir(Aluno contato);

	public Aluno carregar(Integer id);

	public Aluno buscarPorLogin(String login);

	public Aluno buscarPorEmail(String email);

	public List<Aluno> listar();

}
