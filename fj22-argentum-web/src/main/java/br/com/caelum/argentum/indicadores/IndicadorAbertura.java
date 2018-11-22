package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class IndicadorAbertura implements Indicador {

	public double calcula(int posicao, SerieTemporal serie) {
		return serie.getCandles(posicao).getAbertura();
	}

	
	@Override
	public String toString() {
		return "Abertura";
	}
}
