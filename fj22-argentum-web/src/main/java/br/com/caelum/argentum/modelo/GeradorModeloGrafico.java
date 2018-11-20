package br.com.caelum.argentum.modelo;

import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

import br.com.caelum.argentum.indicadores.MediaMovelSimples;

public class GeradorModeloGrafico {
	private SerieTemporal serie;
	private int comeco;
	private int fim;
	private LineChartModel modeloGrafico;

	public GeradorModeloGrafico(SerieTemporal serie, int comeco, int fim) {
		super();
		this.serie = serie;
		this.comeco = comeco;
		this.fim = fim;
		this.modeloGrafico = new LineChartModel();

	}

	public void plotaMediaMovelSimples() {
		MediaMovelSimples indicador = new MediaMovelSimples();
		ChartSeries chartSeries = new ChartSeries("MMS do Fechamento");

		for (int i = comeco; i < fim; i++) {
			double valor = indicador.calcula(i, serie);
			chartSeries.set(i, valor);
		}

		this.modeloGrafico.addSeries(chartSeries);
		this.modeloGrafico.setLegendPosition("w");
		this.modeloGrafico.setTitle("Indicadores");
	}

	public LineChartModel getModeloGrafico() {
		return this.modeloGrafico;
	}

}
