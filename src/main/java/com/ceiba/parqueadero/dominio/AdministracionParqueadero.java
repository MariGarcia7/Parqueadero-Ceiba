package com.ceiba.parqueadero.dominio;

import java.math.BigDecimal;

public class AdministracionParqueadero {
	
	public static final BigDecimal VALOR_HORA_CARRO = new BigDecimal(1000);
	public static final BigDecimal VALOR_HORA_MOTO = new BigDecimal(500);
	public static final BigDecimal VALOR_DIA_CARRO = new BigDecimal(8000);
	public static final BigDecimal VALOR_DIA_MOTO = new BigDecimal(4000);
	public static final int CUPOS_MOTOS = 10;
	public static final int CUPOS_CARROS = 20;
	public static final int CILINDRAJE_MOTOS = 500;
	public static final int INICIO_DIA = 9;
	public static final int FIN_DIA = 24;
	public static final String LUNES = "MONDAY";
	public static final String DOMINGO = "SUNDAY";
	public static final String NO_HAY_CUPO = "No hay cupo";

	private AdministracionParqueadero() {

	}

}
