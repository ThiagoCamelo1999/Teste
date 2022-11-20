package br.com.empiricus.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Indicadores")
@AllArgsConstructor
@NoArgsConstructor
public class Indicadores extends CalculaIndicadores {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = true, unique = true)
    private String nome;

    
    @NotNull
    private Double pl;
    
    @NotNull
    private Double roe;
    
    @NotNull
    private Double pvpa;
   
    @NotNull
    private Double ev;
   
    @NotNull
    private Double ebitda;
    
    @NotNull
    private Double evebitda;
    
    @NotNull
    private Double dividendYield;
    
    @NotNull
    private Double lpa;

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

	public Double getPl() {
		return pl;
	}

	public void setPl(Double pl) {
		this.pl = pl;
	}

	public Double getRoe() {
		return roe;
	}

	public void setRoe(Double roe) {
		this.roe = roe;
	}

	public Double getPvpa() {
		return pvpa;
	}

	public void setPvpa(Double pvpa) {
		this.pvpa = pvpa;
	}

	public Double getEv() {
		return ev;
	}

	public void setEv(Double ev) {
		this.ev = ev;
	}

	public Double getEbitda() {
		return ebitda;
	}

	public void setEbitda(Double ebitda) {
		this.ebitda = ebitda;
	}

	public Double getEvebitda() {
		return evebitda;
	}

	public void setEvebitda(Double evebitda) {
		this.evebitda = evebitda;
	}

	public Double getDividendYield() {
		return dividendYield;
	}

	public void setDividendYield(Double dividendYield) {
		this.dividendYield = dividendYield;
	}

	public Double getLpa() {
		return lpa;
	}

	public void setLpa(Double lpa) {
		this.lpa = lpa;
	}
    
}
