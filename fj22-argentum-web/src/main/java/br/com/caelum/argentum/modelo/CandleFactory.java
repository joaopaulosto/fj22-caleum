package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CandleFactory {

	public Candle constroiCandleParaData(Calendar data, List<Negociacao> negociacoes) {

		double maximo = 0;
		double minimo = Double.MAX_VALUE;

		double volume = 0.0;

		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();

			double precoNeg = negociacao.getPreco();
			if (precoNeg > maximo) {
				maximo = precoNeg;
			}
			if (precoNeg < minimo) {
				minimo = precoNeg;
			}
		}

		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(negociacoes.size() - 1).getPreco();
		double minimoFinal = minimo == Double.MAX_VALUE ? 0 : minimo;

		// return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
		return new CandleBuilder().comAbertura(abertura).comFechamento(fechamento).comMinimo(minimoFinal)
				.comMaximo(maximo).comVolume(volume).comData(data).geraCandle();

	}

	public List<Candle> constroiCandles(List<Negociacao> todasNegociacoes) {
		List<Candle> candles = new ArrayList<Candle>();

		List<Negociacao> negociacoesDoDia = new ArrayList<Negociacao>();
		Calendar dataAtual = todasNegociacoes.get(0).getData();

		for (Negociacao negociacao : todasNegociacoes) {
			if(negociacao.getData().before(dataAtual)){
				throw new IllegalStateException("Negociacao em ordem errada");
			}			
			// se nao for mesmo dia, fecha candle e reinicia variaveis
			if (!negociacao.isMesmoDia(dataAtual)) {
				criaEGuardaCandles(candles, negociacoesDoDia, dataAtual);
				negociacoesDoDia = new ArrayList<Negociacao>();
				dataAtual = negociacao.getData();
			}
			negociacoesDoDia.add(negociacao);
		}

		//adiciona o ultimo candle
		criaEGuardaCandles(candles, negociacoesDoDia, dataAtual);
		return candles;
	}

	public void criaEGuardaCandles(List<Candle> candles, List<Negociacao> negociacoesDoDia, Calendar dataAtual) {
		Candle candleDoDia = constroiCandleParaData(dataAtual, negociacoesDoDia);
		candles.add(candleDoDia);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
