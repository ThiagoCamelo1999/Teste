package br.com.empiricus.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Ativos")
public class Ativos {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    @Column(unique = true)
    private String nome;
    @NotNull
    private Double lucroPorAcao;
    @NotNull
    private Double dividaTotal;
    @NotNull
    private Double caixaEEquivalentes;
    @NotNull
    private Double receitaLiquida;
    @NotNull
    private Double lucroLiquido;
    @NotNull
    private Double lucroOperacionalLiquido;
    @NotNull
    private Double acoesTotais;
    @NotNull
    private Double cotacaoAcao;
    @NotNull
    private Double precoAcao;
    @NotNull
    private Double valorPatrimonialPorAcao;
    @NotNull
    private Double patrimonioLiquido;
    @NotNull
    private Double impostos;
    @NotNull
    private Double juros;
    @NotNull
    private Double depreciacao;
    @NotNull
    private Double amortizacao;
    @NotNull
    private Double dividendo;

    @ManyToOne
    @JsonIgnoreProperties("ativos")
    @Schema(hidden = false)
  
	private ClientePJ userLoginPJ;

    /*@JsonProperty("userLoginPJ") private void unpackNested(Long userLoginPJId) {
        this.userLoginPJ = new ClientePJ(); userLoginPJ.setId(userLoginPJId);
    }*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getLucroPorAcao() {
		return lucroPorAcao;
	}

	public void setLucroPorAcao(Double lucroPorAcao) {
		this.lucroPorAcao = lucroPorAcao;
	}

	public Double getDividaTotal() {
		return dividaTotal;
	}

	public void setDividaTotal(Double dividaTotal) {
		this.dividaTotal = dividaTotal;
	}

	public Double getCaixaEEquivalentes() {
		return caixaEEquivalentes;
	}

	public void setCaixaEEquivalentes(Double caixaEEquivalentes) {
		this.caixaEEquivalentes = caixaEEquivalentes;
	}

	public Double getReceitaLiquida() {
		return receitaLiquida;
	}

	public void setReceitaLiquida(Double receitaLiquida) {
		this.receitaLiquida = receitaLiquida;
	}

	public Double getLucroLiquido() {
		return lucroLiquido;
	}

	public void setLucroLiquido(Double lucroLiquido) {
		this.lucroLiquido = lucroLiquido;
	}

	public Double getLucroOperacionalLiquido() {
		return lucroOperacionalLiquido;
	}

	public void setLucroOperacionalLiquido(Double lucroOperacionalLiquido) {
		this.lucroOperacionalLiquido = lucroOperacionalLiquido;
	}

	public Double getAcoesTotais() {
		return acoesTotais;
	}

	public void setAcoesTotais(Double acoesTotais) {
		this.acoesTotais = acoesTotais;
	}

	public Double getCotacaoAcao() {
		return cotacaoAcao;
	}

	public void setCotacaoAcao(Double cotacaoAcao) {
		this.cotacaoAcao = cotacaoAcao;
	}

	public Double getPrecoAcao() {
		return precoAcao;
	}

	public void setPrecoAcao(Double precoAcao) {
		this.precoAcao = precoAcao;
	}

	public Double getValorPatrimonialPorAcao() {
		return valorPatrimonialPorAcao;
	}

	public void setValorPatrimonialPorAcao(Double valorPatrimonialPorAcao) {
		this.valorPatrimonialPorAcao = valorPatrimonialPorAcao;
	}

	public Double getPatrimonioLiquido() {
		return patrimonioLiquido;
	}

	public void setPatrimonioLiquido(Double patrimonioLiquido) {
		this.patrimonioLiquido = patrimonioLiquido;
	}

	public Double getImpostos() {
		return impostos;
	}

	public void setImpostos(Double impostos) {
		this.impostos = impostos;
	}

	public Double getJuros() {
		return juros;
	}

	public void setJuros(Double juros) {
		this.juros = juros;
	}

	public Double getDepreciacao() {
		return depreciacao;
	}

	public void setDepreciacao(Double depreciacao) {
		this.depreciacao = depreciacao;
	}

	public Double getAmortizacao() {
		return amortizacao;
	}

	public void setAmortizacao(Double amortizacao) {
		this.amortizacao = amortizacao;
	}

	public Double getDividendo() {
		return dividendo;
	}

	public void setDividendo(Double dividendo) {
		this.dividendo = dividendo;
	}

	public ClientePJ getUserLoginPJ() {
		return userLoginPJ;
	}

	public void setUserLoginPJ(ClientePJ userLoginPJ) {
		this.userLoginPJ = userLoginPJ;
	}

	public Ativos() {
		
	}

	public Ativos(@NotNull String nome, @NotNull Double lucroPorAcao, @NotNull Double dividaTotal,
			@NotNull Double caixaEEquivalentes, @NotNull Double receitaLiquida, @NotNull Double lucroLiquido,
			@NotNull Double lucroOperacionalLiquido, @NotNull Double acoesTotais, @NotNull Double cotacaoAcao,
			@NotNull Double precoAcao, @NotNull Double valorPatrimonialPorAcao, @NotNull Double patrimonioLiquido,
			@NotNull Double impostos, @NotNull Double juros, @NotNull Double depreciacao, @NotNull Double amortizacao,
			@NotNull Double dividendo) {
		super();
		this.nome = nome;
		this.lucroPorAcao = lucroPorAcao;
		this.dividaTotal = dividaTotal;
		this.caixaEEquivalentes = caixaEEquivalentes;
		this.receitaLiquida = receitaLiquida;
		this.lucroLiquido = lucroLiquido;
		this.lucroOperacionalLiquido = lucroOperacionalLiquido;
		this.acoesTotais = acoesTotais;
		this.cotacaoAcao = cotacaoAcao;
		this.precoAcao = precoAcao;
		this.valorPatrimonialPorAcao = valorPatrimonialPorAcao;
		this.patrimonioLiquido = patrimonioLiquido;
		this.impostos = impostos;
		this.juros = juros;
		this.depreciacao = depreciacao;
		this.amortizacao = amortizacao;
		this.dividendo = dividendo;
	}
 
    
}
