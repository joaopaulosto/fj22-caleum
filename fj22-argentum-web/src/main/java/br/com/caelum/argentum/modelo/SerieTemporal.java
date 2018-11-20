package br.com.caelum.argentum.modelo;

import java.util.List;

public class SerieTemporal {

	private final List<Candle> candles;

	public SerieTemporal(List<Candle> candles) {
		super();
		if (candles == null || candles.size() == 0) {
			throw new IllegalArgumentException("A lista de candle nao pode ser nula");
		}
		this.candles = candles;
	}

	public Candle getCandles(int i) {
		return candles.get(i);
	}

	public int getUltimaPosicao() {
		return this.candles.size() - 1;
	}

}
