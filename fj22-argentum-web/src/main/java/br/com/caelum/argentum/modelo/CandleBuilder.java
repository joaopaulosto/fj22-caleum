package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public class CandleBuilder {
	private double abertura;
	private double fechamento;
	private double minimo;
	private double maximo;
	private double volume;
	private Calendar data;

	public CandleBuilder comAbertura(double abertura) {
		this.abertura = abertura;
		return this;
	}

	public CandleBuilder comFechamento(double fechamento) {
		this.fechamento = fechamento;
		return this;
	}

	public CandleBuilder comMinimo(double minimo) {
		this.minimo = minimo;
		return this;
	}

	public CandleBuilder comMaximo(double maximo) {
		this.maximo = maximo;
		return this;
	}

	public CandleBuilder comVolume(double volume) {
		this.volume = volume;
		return this;
	}

	public CandleBuilder comData(Calendar data) {
		this.data = data;
		return this;
	}

	public Candlestick geraCandle() {
		validaCamposPreenchido();
		return new Candlestick(this.abertura, this.fechamento, this.minimo, this.maximo, this.volume, this.data);
	}

	private void validaCamposPreenchido() {
		
		if(this.abertura == 0.0) {
			throw new IllegalStateException("Informe o valor de abertura");
		}
		
		if(this.fechamento == 0.0) {
			throw new IllegalStateException("Informe o valor do fechamento");
		}
		
		if(this.minimo == 0.0) {
			throw new IllegalStateException("Informe o valor do maximo");
		}
		
		if(this.maximo == 0.0) {
			throw new IllegalStateException("Informe o valor do maximo");
		}
		
		if(this.volume == 0.0) {
			throw new IllegalStateException("Informe o valor do volume");			
		}
		
		if(this.data == null) {
			throw new IllegalStateException("Informe o valor da data");
		}
	}

}
