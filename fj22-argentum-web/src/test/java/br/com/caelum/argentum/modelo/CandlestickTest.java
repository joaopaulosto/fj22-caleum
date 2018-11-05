package br.com.caelum.argentum.modelo;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;

public class CandlestickTest {

	@Test(expected = IllegalArgumentException.class)
	public void semNegociacoesGeraCandleComZero() {
		new Candlestick(10, 20, 20, 10, 10000, Calendar.getInstance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void comDataNula() {
		new Candlestick(10, 20, 20, 20, 10000, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void comAberturaNegativa() {
		new Candlestick(-10, 20, 20, 20, 10000, Calendar.getInstance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void comFechamentoNegativa() {
		new Candlestick(10, -20, 20, 20, 10000, Calendar.getInstance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void comMinimoNegativa() {
		new Candlestick(10, 20, -20, 20, 10000, Calendar.getInstance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void comMaximoNegativa() {
		new Candlestick(10, 20, 20, -20, 10000, Calendar.getInstance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void comVolumeNegativa() {
		new Candlestick(10, 20, 20, 20, -10000, Calendar.getInstance());
	}

	@Test
	public void quandoAberturaIgualFechamentoEhAlta() {
		Candlestick c = new Candlestick(100, 100, 100, 100, 1000, Calendar.getInstance());
		assertTrue(c.isAlta());
	}

}
