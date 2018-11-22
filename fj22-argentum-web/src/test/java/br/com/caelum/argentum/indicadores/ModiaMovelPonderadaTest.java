package br.com.caelum.argentum.indicadores;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.util.GeradorDeSerie;

public class ModiaMovelPonderadaTest {

	@Test
	public void sequenciaSimpleDeClandes() {
		SerieTemporal serie = GeradorDeSerie.criaSerie(1, 2, 3, 4, 5, 6);
		
		int intervalo = 3;
		MediaMovelPonderada mmp = new MediaMovelPonderada(intervalo);
		
		//Ex: calcula(2): 1*1 + 2*2 + 3*3 = 14. Divide por 3, da 14/6 
		assertEquals(14.0/intervalo, mmp.calcula(2, serie), 0.0001);
		assertEquals(20.0/intervalo, mmp.calcula(3, serie), 0.0001);
		assertEquals(26.0/intervalo, mmp.calcula(4, serie), 0.0001);
		assertEquals(32.0/intervalo, mmp.calcula(5, serie), 0.0001);
		
	}

}
