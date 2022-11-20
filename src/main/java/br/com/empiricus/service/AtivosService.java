package br.com.empiricus.service;

import br.com.empiricus.model.Ativos;
import br.com.empiricus.model.ClientePJ;
import br.com.empiricus.model.Indicadores;
import br.com.empiricus.repository.AtivosRepository;
import br.com.empiricus.repository.IndicadoresRepository;
import br.com.empiricus.repository.UserPJRepository;
import br.com.empiricus.springboot.exception.ResourceNotFoundException;
import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Data
@Service
@Transactional
public class AtivosService {
    @Autowired
    private AtivosRepository ativosRepository;

    @Autowired
    private UserPJRepository userPJRepository;

    @Autowired
    private IndicadoresRepository indicadoresRepository;

    public List<Ativos> getAllAtivos(String username) {
        ClientePJ pj = userPJRepository.findByCnpj(username).orElseThrow(RuntimeException::new);
        return pj.getAtivos();
    }

    public Ativos saveAtivos(Ativos ativos, String username) {
        ClientePJ pj = userPJRepository.findByCnpj(username).orElseThrow(RuntimeException::new);

        Indicadores indicadores = new Indicadores();

        indicadores.setNome(ativos.getNome());
        indicadores.setPl(Indicadores.plResult(ativos.getPrecoAcao(),ativos.getLucroPorAcao()));
        indicadores.setRoe(Indicadores.roeResult(ativos.getLucroLiquido(),ativos.getPatrimonioLiquido()));
        indicadores.setPvpa(Indicadores.pvpaResult(ativos.getPrecoAcao(),ativos.getValorPatrimonialPorAcao()));
        indicadores.setEv(Indicadores.evResult(ativos.getCotacaoAcao(),ativos.getAcoesTotais(),ativos.getDividaTotal(),ativos.getCaixaEEquivalentes()));
        indicadores.setEbitda(Indicadores.ebitdaResult(ativos.getLucroOperacionalLiquido(),ativos.getJuros(),ativos.getImpostos(),ativos.getDepreciacao(),ativos.getAmortizacao()));
        indicadores.setEvebitda(Indicadores.evebitdaResult(ativos.getCotacaoAcao(),ativos.getAcoesTotais(),ativos.getDividaTotal(),ativos.getCaixaEEquivalentes(),ativos.getLucroOperacionalLiquido(),ativos.getJuros(),ativos.getImpostos(),ativos.getDepreciacao(),ativos.getAmortizacao()));
        indicadores.setDividendYield(Indicadores.dividendYieldResult(ativos.getDividendo(),ativos.getPrecoAcao()));
        indicadores.setLpa(Indicadores.lpaResult(ativos.getLucroLiquido(),ativos.getAcoesTotais()));

        indicadoresRepository.save(indicadores);

        ativos.setUserLoginPJ(pj);
        return ativosRepository.save(ativos);
    }

    public Ativos getAtivosById(long id) {
        return ativosRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Ativos", "Id", id));
    }

    public List<Ativos> getAtivosByNome(String nome) {
        return ativosRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Ativos updateAtivosByNome(Ativos ativos, String nome) {

        Ativos existingAtivos = ativosRepository.findByNome(nome);

        Indicadores indicadores = indicadoresRepository.findByNome(nome);

        existingAtivos.setNome(ativos.getNome());
        existingAtivos.setLucroPorAcao(ativos.getLucroPorAcao());
        existingAtivos.setDividaTotal(ativos.getDividaTotal());
        existingAtivos.setCaixaEEquivalentes(ativos.getCaixaEEquivalentes());
        existingAtivos.setReceitaLiquida(ativos.getReceitaLiquida());
        existingAtivos.setLucroLiquido(ativos.getLucroLiquido());
        existingAtivos.setLucroOperacionalLiquido(ativos.getLucroOperacionalLiquido());
        existingAtivos.setAcoesTotais(ativos.getAcoesTotais());
        existingAtivos.setCotacaoAcao(ativos.getCotacaoAcao());
        existingAtivos.setPrecoAcao(ativos.getPrecoAcao());
        existingAtivos.setValorPatrimonialPorAcao(ativos.getValorPatrimonialPorAcao());
        existingAtivos.setPatrimonioLiquido(ativos.getPatrimonioLiquido());
        existingAtivos.setImpostos(ativos.getImpostos());
        existingAtivos.setJuros(ativos.getJuros());
        existingAtivos.setDepreciacao(ativos.getDepreciacao());
        existingAtivos.setAmortizacao(ativos.getAmortizacao());
        existingAtivos.setDividendo(ativos.getDividendo());

        indicadores.setNome(ativos.getNome());
        indicadores.setPl(Indicadores.plResult(ativos.getPrecoAcao(),ativos.getLucroPorAcao()));
        indicadores.setRoe(Indicadores.roeResult(ativos.getLucroLiquido(),ativos.getPatrimonioLiquido()));
        indicadores.setPvpa(Indicadores.pvpaResult(ativos.getPrecoAcao(),ativos.getValorPatrimonialPorAcao()));
        indicadores.setEv(Indicadores.evResult(ativos.getCotacaoAcao(),ativos.getAcoesTotais(),ativos.getDividaTotal(),ativos.getCaixaEEquivalentes()));
        indicadores.setEbitda(Indicadores.ebitdaResult(ativos.getLucroOperacionalLiquido(),ativos.getJuros(),ativos.getImpostos(),ativos.getDepreciacao(),ativos.getAmortizacao()));
        indicadores.setEvebitda(Indicadores.evebitdaResult(ativos.getCotacaoAcao(),ativos.getAcoesTotais(),ativos.getDividaTotal(),ativos.getCaixaEEquivalentes(),ativos.getLucroOperacionalLiquido(),ativos.getJuros(),ativos.getImpostos(),ativos.getDepreciacao(),ativos.getAmortizacao()));
        indicadores.setDividendYield(Indicadores.dividendYieldResult(ativos.getDividendo(),ativos.getPrecoAcao()));
        indicadores.setLpa(Indicadores.lpaResult(ativos.getLucroLiquido(),ativos.getAcoesTotais()));

        indicadoresRepository.save(indicadores);


        ativosRepository.save(existingAtivos);
        return existingAtivos;
    }

    public void deleteAtivos(String nome) {
        indicadoresRepository.findByNome(nome);
        ativosRepository.findByNome(nome);

        indicadoresRepository.deleteByNome(nome);
        ativosRepository.deleteByNome(nome);
    }
}