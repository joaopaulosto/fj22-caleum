package br.com.caelum.argentum.modelo;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;

public class CandleTest {

	@Test(expected = IllegalArgumentException.class)
	public void semNegociacoesGeraCandleComZero() {
		new Candle(10, 20, 20, 10, 10000, Calendar.getInstance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void comDataNula() {
		new Candle(10, 20, 20, 20, 10000, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void comAberturaNegativa() {
		new Candle(-10, 20, 20, 20, 10000, Calendar.getInstance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void comFechamentoNegativa() {
		new Candle(10, -20, 20, 20, 10000, Calendar.getInstance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void comMinimoNegativa() {
		new Candle(10, 20, -20, 20, 10000, Calendar.getInstance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void comMaximoNegativa() {
		new Candle(10, 20, 20, -20, 10000, Calendar.getInstance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void comVolumeNegativa() {
		new Candle(10, 20, 20, 20, -10000, Calendar.getInstance());
	}

	@Test
	public void quandoAberturaIgualFechamentoEhAlta() {
		Candle c = new Candle(100, 100, 100, 100, 1000, Calendar.getInstance());
		assertTrue(c.isAlta());
	}

}
