package br.com.caelum.argentum.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.LineChartModel;

import br.com.caelum.argentum.grafico.GeradorModeloGrafico;
import br.com.caelum.argentum.indicadores.MediaMovelSimples;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandleFactory;
import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.ws.ClientWebService;

@ManagedBean
@ViewScoped
public class ArgentumBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Negociacao> negociacaoes;

	private LineChartModel modeloGrafico;

	public ArgentumBean() {
		this.negociacaoes = new ClientWebService().getNegociacoes();
		
		List<Candle> candles = new CandleFactory().constroiCandles(this.negociacaoes);
		
		SerieTemporal serie = new SerieTemporal(candles);
		
		GeradorModeloGrafico geradorGrafico = new GeradorModeloGrafico(serie, 2, serie.getUltimaPosicao());
		
		geradorGrafico.plotaMediaMovelSimples(new MediaMovelSimples(3));
		
		this.modeloGrafico = geradorGrafico.getModeloGrafico();

	}

	public List<Negociacao> getNegociacaoes() {
		return negociacaoes;
	}
	
	public LineChartModel getModeloGrafico() {
		return modeloGrafico;
	}

}
