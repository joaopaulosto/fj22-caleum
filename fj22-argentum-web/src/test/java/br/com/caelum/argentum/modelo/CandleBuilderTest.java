package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import org.junit.Test;

public class CandleBuilderTest {

	@Test()
	public void geracaoDeClandeDeveTerTodosOsDadosNecessarios() {
		new CandleBuilder()
				.comAbertura(10.0)
				.comData(Calendar.getInstance())
				.comFechamento(10.0)
				.comMaximo(10.0)
				.comMinimo(10.0)
				.comVolume(10.0)
				.geraCandle();		
	}
	
	@Test(expected = IllegalStateException.class)
	public void naoGeraClandeSemAbertura() {
		new CandleBuilder()
				.comData(Calendar.getInstance())
				.comFechamento(10.0)
				.comMaximo(10.0)
				.comMinimo(10.0)
				.comVolume(10.0)
				.geraCandle();		
	}
	@Test(expected = IllegalStateException.class)
	public void naoGeraCandleSemData() {
		new CandleBuilder()
				.comAbertura(10.0)
				.comFechamento(10.0)
				.comMaximo(10.0)
				.comMinimo(10.0)
				.comVolume(10.0)
				.geraCandle();
	}
	@Test(expected = IllegalStateException.class)
	public void naoGeraCandleSemFechamento() {
		new CandleBuilder()
				.comAbertura(10.0)
				.comData(Calendar.getInstance())
				.comMaximo(10.0)
				.comMinimo(10.0)
				.comVolume(10.0)
				.geraCandle();
	}
	@Test(expected = IllegalStateException.class)
	public void naoGeraCandleSemMaximo() {
		new CandleBuilder()
				.comAbertura(10.0)
				.comData(Calendar.getInstance())
				.comFechamento(10.0)
				.comMinimo(10.0)
				.comVolume(10.0)
				.geraCandle();
	}
	@Test(expected = IllegalStateException.class)
	public void naoGeraCandleSemMinimo() {
		new CandleBuilder()
				.comAbertura(10.0)
				.comData(Calendar.getInstance())
				.comFechamento(10.0)
				.comMaximo(10.0)
				.comVolume(10.0)
				.geraCandle();
	}
	@Test(expected = IllegalStateException.class)
	public void naoGeraCandleSemVolume() {
		new CandleBuilder()
				.comAbertura(10.0)
				.comData(Calendar.getInstance())
				.comFechamento(10.0)
				.comMaximo(10.0)
				.comMinimo(10.0)
				.geraCandle();
	}
	
}
