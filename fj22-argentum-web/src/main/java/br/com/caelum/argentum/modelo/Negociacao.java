package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.PROPERTY)
public final class Negociacao {
	private final double preco;
	private final int quantidade;
	private final Calendar data;

	public Negociacao(double preco, int quantidade, Calendar data) {
		super();
		if (data == null) {
			throw new IllegalArgumentException("Data não pode ser nula");
		}

		if (quantidade <= 0) {
			throw new IllegalArgumentException("Quantidade com valor invalido");
		}

		if (preco <= 0) {
			throw new IllegalArgumentException("Preço com valor invalido");
		}

		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	public double getVolume() {
		return preco * quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		return (Calendar) this.data.clone();
	}

	public boolean isMesmoDia(Calendar outraData) {
		return this.data.get(Calendar.DAY_OF_MONTH) == outraData.get(Calendar.DAY_OF_MONTH) &&
				this.data.get(Calendar.MONTH) == outraData.get(Calendar.MONTH) &&
				this.data.get(Calendar.YEAR) == outraData.get(Calendar.YEAR);
	}

	 
}
