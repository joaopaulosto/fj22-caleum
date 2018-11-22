package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class IndicadorFechamento implements Indicador {

	public double calcula(int posicao, SerieTemporal serie) {
		return serie.getCandles(posicao).getFechamento();
	}

	@Override
	public String toString() {
		return "Fechamento";
	}

}
