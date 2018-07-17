package com.ceiba.parqueadero.dominio;

import java.math.BigDecimal;

public class ConstantesTarifasParqueadero {
	
	public static final BigDecimal VALOR_HORA_CARRO = new BigDecimal(1000);
	public static final BigDecimal VALOR_HORA_MOTO = new BigDecimal(500);
	public static final BigDecimal VALOR_DIA_CARRO = new BigDecimal(8000);
	public static final BigDecimal VALOR_DIA_MOTO = new BigDecimal(4000);
	public static final BigDecimal VALOR_ADICIONAL_CILINDRAJE_MOTO = new BigDecimal(2000);
	
	private ConstantesTarifasParqueadero() {
		
	}
}
