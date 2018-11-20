package br.com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Candle {

	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final Calendar data;

	public Candle(double abertura, double fechamento, double minimo, double maximo, double volume, Calendar data) {
		super();
		validaCampos(abertura, fechamento, minimo, maximo, volume, data);
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
	}
	private void validaCampos(double abertura, double fechamento, double minimo, double maximo, double volume, Calendar data) {
		if (maximo < minimo) {
			throw new IllegalArgumentException("O Preco M�ximo n�o pode ser menor que o m�nimo");
		}	
		if(data == null) {
			throw new IllegalArgumentException("Data n�o pode ser nula");
		}
		if(abertura < 0) {
			throw new IllegalArgumentException("Abertura n�o pode ser negativo");
		}
		if(fechamento < 0) {
			throw new IllegalArgumentException("Fechamento n�o pode ser negativo");
		}
		if(minimo < 0) {
			throw new IllegalArgumentException("Minimo n�o pode ser negativo");
		}
		if(maximo < 0) {
			throw new IllegalArgumentException("Maximo n�o pode ser negativo");
		}
		if(volume < 0) {
			throw new IllegalArgumentException("Volume n�o pode ser negativo");
		}
	}

	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getVolume() {
		return volume;
	}

	public Calendar getData() {
		return data;
	}

	public boolean isBaixa() {
		return this.abertura > this.fechamento;
	}

	public boolean isAlta() {
		return this.abertura == this.fechamento ? true : this.abertura < this.fechamento;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String data = sdf.format(this.getData().getTime());
		return String.format(
				"Abertura: %f, Fechamento: %f, M�nima: %f, M�xima: %f, Volume: %f, Data: %s, Baixa: %b, Alta: %b",
				this.getAbertura(), this.getFechamento(), this.getMinimo(), this.getMaximo(), this.getVolume(), data,
				this.isBaixa(), this.isAlta());
	}

}
