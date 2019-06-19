package br.com.caelum.ingresso.model.desconto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class DescontoBancoTest {

	@Test
	public void deveAplicarTrintaPorCentoDeDescontoParaClientesDoBanco() {
		Sala sala 	= new Sala("Eldorado - IMAX", new BigDecimal(12));
		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal(8));
		
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), sala, filme);
		Ingresso ingresso = new Ingresso(sessao, new DescontoBanco());
		
		BigDecimal precoEsperado = new BigDecimal(14).setScale(2, RoundingMode.HALF_UP);
		
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}
}
