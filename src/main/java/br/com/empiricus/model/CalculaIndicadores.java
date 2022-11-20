package br.com.empiricus.model;



public class CalculaIndicadores {


	public static Double plResult(double getPrecoAcao, double getLucroPorAcao) {
		double pl = getPrecoAcao / getLucroPorAcao;
		return pl;
	}

	public static Double roeResult(double getLucroLiquido, double getPatrimonioLiquido)  {
		double roe = (getLucroLiquido / getPatrimonioLiquido) * 100;
		return roe;
	}

	public static Double pvpaResult(double getPrecoAcao, double getValorPatrimonialPorAcao ) {
		double pvpa = getPrecoAcao / getValorPatrimonialPorAcao;
		return pvpa;
	}

	public static Double evResult(double getCotacaoAcao, double getAcoesTotais, double getDividaTotal, double getCaixaEEquivalentes) {
		double ev = ((getCotacaoAcao * getAcoesTotais) + getDividaTotal) - getCaixaEEquivalentes;
		return ev;
	}

	public static Double ebitdaResult(double getLucroOperacionalLiquido, double getJuros, double getImpostos, double getDepreciacao, double getAmortização) {
		double ebitda =  getLucroOperacionalLiquido + getJuros + getImpostos + getDepreciacao + getAmortização;
		return ebitda;
	}

	public static Double evebitdaResult(double getCotacaoAcao, double getAcoesTotais, double getDividaTotal, double getCaixaEEquivalentes, double getLucroOperacionalLiquido, double getJuros, double getImpostos, double getDepreciacao, double getAmortização) {
		double evebitda = (((getCotacaoAcao * getAcoesTotais) + getDividaTotal) - getCaixaEEquivalentes) / (getLucroOperacionalLiquido + getJuros + getImpostos + getDepreciacao + getAmortização);
		return evebitda;
	}

	public static Double dividendYieldResult(double getDividendo, double getPrecoAcao ) {
		double dividendYield = (getDividendo / getPrecoAcao) * 100;
		return dividendYield;
	}

	public static Double lpaResult(double getLucroLiquido, double getAcoesTotais) {
		double lpa = getLucroLiquido / getAcoesTotais;
		return lpa;
	}


}