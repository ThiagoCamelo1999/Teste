package br.com.empiricus.repository;

import br.com.empiricus.model.Ativos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtivosRepository extends JpaRepository <Ativos, Long>{

    public List<Ativos> findByNomeContainingIgnoreCase(String nome);
    public Ativos findByNome(String nome);

    void deleteByNome(String nome);
}
