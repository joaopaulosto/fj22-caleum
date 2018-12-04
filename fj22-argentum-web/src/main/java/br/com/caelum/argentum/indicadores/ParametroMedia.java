package br.com.caelum.argentum.indicadores;

public abstract class ParametroMedia {
	
	protected int intervado;
	
	public ParametroMedia() {}

	public ParametroMedia(int intervado) {
		super();
		this.intervado = intervado;
	}
	
	public int getIntervado() {
		return intervado;
	}
	public void setIntervado(int intervado) {
		this.intervado = intervado;
	}
}
