package com.ceiba.parqueadero.dominio;

import java.math.BigDecimal;
import com.ceiba.parqueadero.model.EntityVehiculo;
import com.ceiba.parqueadero.model.TiempoTotalDeParqueo;
import com.ceiba.parqueadero.model.TipoVehiculo;

public class CalculadoraDeParqueadero {

	public BigDecimal calcularTotalaPagar(EntityVehiculo entityVehiculo) {

		BigDecimal valordia;
		BigDecimal valorhora;

		DiasHorasMinutosDeParqueo tiempoDeParqueo = new DiasHorasMinutosDeParqueo();

		TiempoTotalDeParqueo tiempo = tiempoDeParqueo.calcularTiempoTotal(entityVehiculo.getFechaHoraIngreso(),
				entityVehiculo.getFechaHoraSalida());

		if (entityVehiculo.getTipoVehiculo().equals(TipoVehiculo.Moto)) {
			valordia = ConstantesTarifasParqueadero.VALOR_DIA_MOTO;
			valorhora = ConstantesTarifasParqueadero.VALOR_HORA_MOTO;
		} else {
			valordia = ConstantesTarifasParqueadero.VALOR_DIA_CARRO;
			valorhora = ConstantesTarifasParqueadero.VALOR_HORA_CARRO;
		}

		BigDecimal hora;
		BigDecimal minutos = BigDecimal.ZERO;
		BigDecimal totalaPagar;

		BigDecimal dia = new BigDecimal(tiempo.dia).multiply(valordia);

		if (tiempo.hora >= ConstantesRestriccionesParqueadero.INICIO_DIA) {
			hora = valordia;
		} else {
			hora = new BigDecimal(tiempo.hora).multiply(valorhora);
		}

		if (tiempo.minutos > 0) {
			minutos = valorhora;
		}

		if (entityVehiculo.getTipoVehiculo().equals(TipoVehiculo.Moto)
				&& entityVehiculo.getCilindraje() >= ConstantesRestriccionesParqueadero.CILINDRAJE_MOTO) {
			return totalaPagar = dia.add(hora).add(minutos).add(ConstantesTarifasParqueadero.VALOR_ADICIONAL_CILINDRAJE_MOTO);
		} else {
			return totalaPagar = dia.add(hora).add(minutos);
		}
		

	}

}
