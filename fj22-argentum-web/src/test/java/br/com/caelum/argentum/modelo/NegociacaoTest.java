package br.com.caelum.argentum.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class NegociacaoTest {

	@Test
	public void dataDeNegocicaoEhImutavel() {
		//se criar um negócio no dia 15
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 15);
		
		Negociacao n = new Negociacao(10, 5, c);

		//ainda que eu tente mudar a data para 20
		n.getData().set(Calendar.DAY_OF_MONTH, 20);
		
		//ele continua como 15
		assertEquals(15, n.getData().get(Calendar.DAY_OF_MONTH));
		
	}
	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula() {
		new Negociacao(10, 5, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegociacaoComPrecoZerado() {
		new Negociacao(0, 5, Calendar.getInstance());
	}
	@Test(expected = IllegalArgumentException.class)
	public void naoCriaNegociacaoComQuantidadeZerado() {
		new Negociacao(10, 0, Calendar.getInstance());
	}
	
	@Test
	public void mesmoMilisegundoEhMesmoDia() {
		Calendar agora = Calendar.getInstance();
		Calendar mesmoMomento = (Calendar)agora.clone();
		
		Negociacao negociacao = new Negociacao(40.0, 100, agora);
		assertTrue(negociacao.isMesmoDia(mesmoMomento));
	}
	
	@Test
	public void comHorariosDiferenteNoMesmoDia() {
		Calendar manha = new GregorianCalendar(2018, 10, 28, 8, 30);
		Calendar tarde = new GregorianCalendar(2018, 10, 28, 15, 30);
		
		Negociacao neg = new Negociacao(40.0, 100, manha);
		assertTrue(neg.isMesmoDia(tarde));

	}
	@Test
	public void mesmoDiaMasMesesDiferentesNaoSaoDoMesmoDia() {
		Calendar setembro = new GregorianCalendar(2018, 9, 28, 8, 30);
		Calendar outubro = new GregorianCalendar(2018, 10, 28, 8, 30);
		
		Negociacao neg = new Negociacao(40.0, 100, setembro);
		assertFalse(neg.isMesmoDia(outubro));
	}
	
	@Test
	public void mesmoDiaEMesMasAnosDiferentesNaoSaoDoMesmoDia() {
		Calendar outubro2017 = new GregorianCalendar(2017, 10, 28, 8, 30);
		Calendar outubro2018 = new GregorianCalendar(2018, 10, 28, 8, 30);
		
		Negociacao neg = new Negociacao(40.0, 100, outubro2017);
		assertFalse(neg.isMesmoDia(outubro2018));
	}

}
