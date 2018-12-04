package br.com.caelum.argentum.util;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Calendar;

import org.junit.Test;

import br.com.caelum.argentum.indicadores.MediaMovelSimples;
import br.com.caelum.argentum.modelo.Negociacao;

public class GenericTestes {

	@Test
	public void pegaOTipoClass() {
		Negociacao n = new Negociacao(1, 1, Calendar.getInstance());
		Class classe = n.getClass();
		System.out.println(classe.getName());
		assertNotNull(classe);
		Class<?> neg = Negociacao.class;
		System.out.println(neg.getName());
		assertNotNull(neg);

	}

	@Test
	public void criaClassePeloPacote() throws ClassNotFoundException {
		Class<?> neg = Negociacao.class;
		assertNotNull(neg);
		String classPath = neg.getName();
		Class<?> classPeloNome = Class.forName(classPath);
		System.out.println(classPeloNome.getName());
	}

	@Test(expected = ClassNotFoundException.class)
	public void classePacoteErrado() throws ClassNotFoundException {
		Class<?> classPeloNome = Class.forName("br.com.caelum.argentum.modelo.Negociacao1");
	}

	@Test
	public void listaAtributosDaClasse() {
		Class<Negociacao> classe = Negociacao.class;
		StringBuilder atributos = new StringBuilder();
		System.out.println("Campos da classe: " + classe.getSimpleName() + "\n**************************");
		for (Field atributo : classe.getDeclaredFields()) {
			System.out.println(atributo.getName());
			atributos.append(atributo.getName());
		}
		System.out.println("\n*************************");
		assertNotNull(atributos.toString());
	}

	@Test
	public void listaMetodoDaClasse() {
		Class<Negociacao> classe = Negociacao.class;
		StringBuilder metodos = new StringBuilder();
		System.out.println("Metodos da classe: " + classe.getSimpleName() + "\n*************************");
		for (Method metodo : classe.getMethods()) {
			System.out.println(metodo.getName());
			metodos.append(metodo.getName());
		}
		System.out.println("\n*************************");
		assertNotNull(metodos.toString());
	}

	@Test
	public void listaConstrutores() {
		Class<MediaMovelSimples> classe = MediaMovelSimples.class;
		Constructor<?>[] construtores = classe.getConstructors();
		StringBuilder construtoresString = new StringBuilder();
		System.out.println("Constutores da classe: " + classe.getSimpleName() + "\n*************************");
		for (Constructor<?> constructor : construtores) {
			System.out.println(constructor.getName());
			String params = Arrays.toString(constructor.getParameterTypes());
			System.out.println(params);
			construtoresString.append(params);
		}
		System.out.println("\n*************************");
		assertNotNull(construtoresString.toString());
	}
}
