package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ingresso {

	private Sessao sessao;
	private BigDecimal preco;
	private Lugar lugar;
	
	public Ingresso(Sessao sessao, TipoDeIngresso tipo, Lugar lugar) {
		this.sessao 	= sessao;
		this.preco 		= tipo.applicaDesconto(sessao.getPreco());
		this.lugar		= lugar;
	}
	
	
	public Sessao getSessao() {
		return sessao;
	}
	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}
	public BigDecimal getPreco() {
		return preco.setScale(2, RoundingMode.HALF_UP);
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Lugar getLugar() {
		return lugar;
	}
	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}
}
