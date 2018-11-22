package br.com.caelum.argentum.indicadores;

public abstract class ParametroMedia {
	
	protected int intervado;

	public ParametroMedia(int intervado) {
		super();
		this.intervado = intervado;
	}
	
	public int getIntervado() {
		return intervado;
	}
}
