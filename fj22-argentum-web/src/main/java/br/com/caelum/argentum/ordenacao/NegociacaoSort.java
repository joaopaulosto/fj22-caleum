package br.com.caelum.argentum.ordenacao;

import java.util.Comparator;

import br.com.caelum.argentum.modelo.Negociacao;

public class NegociacaoSort implements Comparator<Negociacao> {

	@Override
	public int compare(Negociacao neg1, Negociacao neg2){
		return neg1.getData().before(neg2.getData()) ? -1 : 1;
	}
	

}
