package br.com.caelum.argentum.modelo;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import br.com.caelum.argentum.ordenacao.NegociacaoSort;

public class CandleFactoryTest {

	private Calendar getHoje() {
		return Calendar.getInstance();
	}

	@Test
	public void apenasUmaNegociacaoGeraCandleComValoresIguais() {

		Calendar hoje = Calendar.getInstance();

		Negociacao n1 = new Negociacao(40.5, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(n1);

		Candle candle = new CandleFactory().constroiCandleParaData(hoje, negociacoes);

		assertEquals(40.5, candle.getAbertura(), 0.00001);
		assertEquals(40.5, candle.getFechamento(), 0.00001);
		assertEquals(40.5, candle.getMinimo(), 0.00001);
		assertEquals(40.5, candle.getMaximo(), 0.00001);
		assertEquals(4050.0, candle.getVolume(), 0.00001);

	}

	@Test
	public void sequenciaSimpleDeNegociacao() {

		Calendar hoje = getHoje();

		Negociacao n1 = new Negociacao(40.5, 100, hoje);
		Negociacao n2 = new Negociacao(45.0, 100, hoje);
		Negociacao n3 = new Negociacao(39.8, 100, hoje);
		Negociacao n4 = new Negociacao(42.3, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(n1, n2, n3, n4);

		CandleFactory fabrica = new CandleFactory();
		Candle candle = fabrica.constroiCandleParaData(hoje, negociacoes);

		assertEquals(40.5, candle.getAbertura(), 0.00001);
		assertEquals(42.3, candle.getFechamento(), 0.00001);
		assertEquals(39.8, candle.getMinimo(), 0.00001);
		assertEquals(45.0, candle.getMaximo(), 0.00001);
		assertEquals(16760.0, candle.getVolume(), 0.00001);

	}

	@Test(expected = IllegalStateException.class)
	public void semNegociacaoGeraCandleComZeros() {

		Calendar hoje = getHoje();

		List<Negociacao> negociacoes = Arrays.asList();

		CandleFactory fabrica = new CandleFactory();
		Candle candle = fabrica.constroiCandleParaData(hoje, negociacoes);

		double dif = 0.0001;
		assertEquals(0.0, candle.getVolume(), dif);
		assertEquals(0.0, candle.getAbertura(), dif);
		assertEquals(0.0, candle.getFechamento(), dif);
		assertEquals(0.0, candle.getMinimo(), dif);
		assertEquals(0.0, candle.getMaximo(), dif);
	}

	@Test
	public void negociacoesEmOrdemCrescenteDeValor() {

		Calendar hoje = getHoje();

		Negociacao n1 = new Negociacao(39.8, 100, hoje);
		Negociacao n2 = new Negociacao(40.5, 100, hoje);
		Negociacao n3 = new Negociacao(42.3, 100, hoje);
		Negociacao n4 = new Negociacao(45.0, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(n1, n2, n3, n4);

		CandleFactory fabrica = new CandleFactory();
		Candle candle = fabrica.constroiCandleParaData(hoje, negociacoes);

	}

	@Test
	public void paraNegociacaoDeTresDiasDistintosGeraTresCandles() {

		Calendar hoje = Calendar.getInstance();

		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
		Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);

		Calendar amanha = (Calendar) hoje.clone();
		amanha.add(Calendar.DAY_OF_MONTH, 1);

		Negociacao negociacao5 = new Negociacao(48.8, 100, amanha);
		Negociacao negociacao6 = new Negociacao(49.3, 100, amanha);

		Calendar depois = (Calendar) amanha.clone();
		depois.add(Calendar.DAY_OF_MONTH, 1);

		Negociacao negociacao7 = new Negociacao(51.8, 100, depois);
		Negociacao negociacao8 = new Negociacao(52.3, 100, depois);

		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4, negociacao5,
				negociacao6, negociacao7, negociacao8);
		
		CandleFactory fabrica = new CandleFactory();
		List<Candle> candles = fabrica.constroiCandles(negociacoes);
		
		assertEquals(3, candles.size());
		assertEquals(40.5, candles.get(0).getAbertura(), 0.00001);
		assertEquals(42.3, candles.get(0).getFechamento(), 0.00001);
		
		assertEquals(48.8, candles.get(1).getAbertura(), 0.00001);
		assertEquals(49.3, candles.get(1).getFechamento(), 0.00001);
		
		assertEquals(51.8, candles.get(2).getAbertura(), 0.00001);
		assertEquals(52.3, candles.get(2).getFechamento(), 0.00001);			

	}
	@Test(expected = IllegalStateException.class)
	public void naoPermiteCriarCandleForaDaOrdem() {

		Calendar hoje = Calendar.getInstance();

		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
		Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);

		Calendar amanha = (Calendar) hoje.clone();
		amanha.add(Calendar.DAY_OF_MONTH, 1);

		Negociacao negociacao5 = new Negociacao(48.8, 100, amanha);
		Negociacao negociacao6 = new Negociacao(49.3, 100, amanha);

		Calendar depois = (Calendar) amanha.clone();
		depois.add(Calendar.DAY_OF_MONTH, 1);

		Negociacao negociacao7 = new Negociacao(51.8, 100, depois);
		Negociacao negociacao8 = new Negociacao(52.3, 100, depois);

		List<Negociacao> negociacoes = Arrays.asList(negociacao8, negociacao7, negociacao6, negociacao5, negociacao4,
				negociacao3, negociacao2, negociacao1);
		
		CandleFactory fabrica = new CandleFactory();
		List<Candle> candles = fabrica.constroiCandles(negociacoes);
		
		assertEquals(3, candles.size());
		assertEquals(40.5, candles.get(0).getAbertura(), 0.00001);
		assertEquals(42.3, candles.get(0).getFechamento(), 0.00001);
		
		assertEquals(48.8, candles.get(1).getAbertura(), 0.00001);
		assertEquals(49.3, candles.get(1).getFechamento(), 0.00001);
		
		assertEquals(51.8, candles.get(2).getAbertura(), 0.00001);
		assertEquals(52.3, candles.get(2).getFechamento(), 0.00001);			

	}
	
	@Test
	public void ordenaListaNegociacaoDataCrescente() {

		Calendar hoje = Calendar.getInstance();

		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
		Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);

		Calendar amanha = (Calendar) hoje.clone();
		amanha.add(Calendar.DAY_OF_MONTH, 1);

		Negociacao negociacao5 = new Negociacao(48.8, 100, amanha);
		Negociacao negociacao6 = new Negociacao(49.3, 100, amanha);

		Calendar depois = (Calendar) amanha.clone();
		depois.add(Calendar.DAY_OF_MONTH, 1);

		Negociacao negociacao7 = new Negociacao(51.8, 100, depois);
		Negociacao negociacao8 = new Negociacao(52.3, 100, depois);

		List<Negociacao> negociacoes = Arrays.asList(negociacao8, negociacao7, negociacao6, negociacao5, negociacao4,
				negociacao3, negociacao2, negociacao1);
		
		Collections.sort(negociacoes, new NegociacaoSort());
		
		CandleFactory fabrica = new CandleFactory();
		List<Candle> candles = fabrica.constroiCandles(negociacoes);
		
		assertEquals(3, candles.size());		

	}
	
	
	
	

}
