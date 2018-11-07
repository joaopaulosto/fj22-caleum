package br.com.caelum.argentum.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class OlaMundoBean {
	private String mensagem  = "Quem eh voce?";
	
	private String nome;
	
	public String getNome() {
		System.out.println("getNome");
		return nome;
	}
	
	public void setNome(String nome) {
		System.out.println("setNome");
		this.nome = nome;
	}
	
	public String getMensagem() {
		System.out.println("getMensagem");
		return mensagem;
	}
	
	public void nomeFoiDigitado() {
		System.out.println("\nChamdou o botão");
	}
}
