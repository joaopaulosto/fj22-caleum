package br.com.caelum.argentum.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.ws.ClientWebService;

@ManagedBean
public class ArgentumBean {

	private List<Negociacao> negociacaoes;

	public ArgentumBean() {
		this.negociacaoes = new ClientWebService().getNegociacoes();
	}

	public List<Negociacao> getNegociacaoes() {
		return negociacaoes;
	}

}
