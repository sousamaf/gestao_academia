package com.br.tabelas.frequencia;

import java.util.Calendar;
import java.util.List;
import com.br.tabelas.frequencia.Frequencia;

public interface FrequenciaDao {
	public void salvar(Frequencia frequencia);
	public void atualizar(Frequencia frequencia);
	public void excluir(Frequencia frequencia);
	public Frequencia carregar(Calendar data_inicio);
	public Frequencia buscarPorHorario(Calendar horario);
	public List<Frequencia> listar();

}
