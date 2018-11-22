package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderada extends ParametroMedia implements Indicador {

	public MediaMovelPonderada(int intervado) {
		super(intervado);
	}

	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0.0;
		int peso = 3;

		for (int i = posicao; i > posicao - getIntervado(); i--) {
			Candle c = serie.getCandles(i);
			soma += c.getFechamento() * peso;
			peso--;
		}
		return soma / getIntervado();
	}

	@Override
	public String toString() {
		return "MMP de Fechamento";
	}

}
