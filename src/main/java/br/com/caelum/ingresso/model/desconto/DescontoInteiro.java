package br.com.caelum.ingresso.model.desconto;

import java.math.BigDecimal;

public class DescontoInteiro implements Desconto {

	@Override
	public BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal) {
		return precoOriginal;
	}
	
}
