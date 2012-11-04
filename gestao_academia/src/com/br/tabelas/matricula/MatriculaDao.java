package com.br.tabelas.matricula;

import java.sql.Date;
import java.util.List;
import com.br.tabelas.matricula.Matricula;

public interface MatriculaDao {
	public void salvar(Matricula matricula);
	public void atualizar(Matricula matricula);
	public void excluir(Matricula matricula);
	public Matricula carregar(Integer id_matricula);
	public Matricula buscarPorData(Date data_matricula);
	public Matricula buscarPorSituacao(Boolean situacao);
	public List<Matricula> listar();

}
