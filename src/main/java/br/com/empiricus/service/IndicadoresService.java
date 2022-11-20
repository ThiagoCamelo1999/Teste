package br.com.empiricus.service;


import br.com.empiricus.model.Indicadores;

import java.util.List;

public interface IndicadoresService {


    List<Indicadores> getAllIndicadores();
    List<Indicadores> getIndicadoresByNome(String nome);
    Indicadores getIndicadoresById(long id);
    Indicadores saveIndicadores(Indicadores indicadores);
    Indicadores updateIndicadores(Indicadores indicadores, long id);
    void deleteIndicadores(long id);
	void deleteIndicadores(String nome);
}
