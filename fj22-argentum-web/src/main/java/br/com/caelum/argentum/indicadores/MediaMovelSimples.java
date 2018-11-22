package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelSimples extends ParametroMedia implements Indicador {

	public MediaMovelSimples(int intervado) {
		super(intervado);
	}
	
	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0.0;
		for (int i = posicao; i > posicao - getIntervado(); i--) {
			soma += serie.getCandles(i).getFechamento();
		}
		return soma / getIntervado();
	}
	@Override
	public String toString() {
		return "MMS de Fechamento";
	}

}
