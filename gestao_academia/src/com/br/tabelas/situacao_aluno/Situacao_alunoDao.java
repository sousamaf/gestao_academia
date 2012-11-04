package com.br.tabelas.situacao_aluno;

import java.util.List;

import com.br.tabelas.situacao_aluno.Situacao_aluno;

public interface Situacao_alunoDao {
	public void salvar(Situacao_aluno situacao_aluno);
	public void atualizar(Situacao_aluno situacao_aluno);
	public void excluir(Situacao_aluno situacao_aluno);
	public Situacao_aluno carregar(int id_situacao);
	public List<Situacao_aluno> listar();

}
