package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelSimples implements CalculaMedia {

	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0.0;
		for (int i = posicao; i > posicao - 3; i--) {
			soma += serie.getCandles(i).getFechamento();
		}
		return soma / 3;
	}

}
