package br.com.caelum.argentum.modelo;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

public class SerieTemporalTest {

	@Test(expected = IllegalArgumentException.class)
	public void serieNaoPodeSerNula() {
		new SerieTemporal(null);				
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void serieDeveConterAoMenusUmCandle() {
		new SerieTemporal(new ArrayList<Candle>());				
	}
	
	@Test
	public void serieContendoAoMenusUmCandle() {
		List<Candle> candles = new ArrayList<Candle>();
		candles.add(new Candle(1, 1, 1, 1, 100, Calendar.getInstance()));
		SerieTemporal serie = new SerieTemporal(candles);
		assertNotNull(serie);
	}

}
