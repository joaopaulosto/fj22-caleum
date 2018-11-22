package br.com.caelum.argentum.grafico;

import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

import br.com.caelum.argentum.indicadores.Indicador;
import br.com.caelum.argentum.modelo.SerieTemporal;

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

	public void plotaMediaMovelSimples(Indicador indicador) {
		
		ChartSeries chartSeries = new ChartSeries(indicador.toString());

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
