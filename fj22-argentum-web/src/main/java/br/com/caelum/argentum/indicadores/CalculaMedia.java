package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public interface CalculaMedia {
	
	public double calcula(int posicao, SerieTemporal serie);

}
