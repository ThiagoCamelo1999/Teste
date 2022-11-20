package br.com.empiricus.repository;

import br.com.empiricus.model.Indicadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IndicadoresRepository extends JpaRepository <Indicadores, String>{

    public List<Indicadores> findByNomeContainingIgnoreCase(String nome);

	public Optional<Indicadores> findById(long id);

	public void deleteById(long id);

	public Indicadores findByNome(String nome);

	public void deleteByNome(String nome);

}
