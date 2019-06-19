package br.com.caelum.ingresso.model.desconto;

import java.math.BigDecimal;

public class DescontoEstudante implements Desconto {

	private BigDecimal porcentagemSobreValorOriginal = new BigDecimal(0.5);
	
	@Override
	public BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal) {
		return precoOriginal.multiply(porcentagemSobreValorOriginal);
	}

}
