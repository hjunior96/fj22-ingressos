package br.com.caelum.ingresso.model.desconto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Lugar;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.TipoDeIngresso;

public class DescontoInteiroTest {

	@Test
	public void naoDeveAplicarNenhumDescontoParaIngressosDoTipoInteira() {
		Sala sala 	= new Sala("Eldorado - IMAX", new BigDecimal(20));
		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal(12));
		Lugar lugar = new Lugar ("A", 1);
		
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), sala, filme);
		Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.INTEIRO,lugar );
		
		BigDecimal precoEsperado = new BigDecimal(32).setScale(2, RoundingMode.HALF_UP);
		
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}
}
