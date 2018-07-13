package com.ceiba.parqueadero.dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.ceiba.parqueadero.modelo.TiempoTotalDeParqueo;
import com.ceiba.parqueadero.modelo.TipoVehiculo;

public class TotalaPagar {

	public BigDecimal calcularTotalaPagar(TipoVehiculo tipovehiculo,int cilindraje, LocalDateTime fechaHoraIngreso,
			LocalDateTime fechaHoraSalida) {

		BigDecimal diaCarro;
		BigDecimal diaMoto;
		BigDecimal horaMoto;
		BigDecimal horaCarro;
		BigDecimal minutosCarro = AdministracionParqueadero.VALOR_HORA_CARRO;
		BigDecimal minutosMoto = AdministracionParqueadero.VALOR_HORA_MOTO;
		BigDecimal totalaPagarMoto;
		BigDecimal totalaPagarCarro;
		BigDecimal totalaPagarMotoMayorCilindraje;

		TiempoDeParqueo tiempoDeParqueo = new TiempoDeParqueo();
		TiempoTotalDeParqueo tiempo = tiempoDeParqueo.calcularTiempoTotal(fechaHoraIngreso, fechaHoraSalida);

		diaCarro = new BigDecimal(tiempo.dia).multiply(AdministracionParqueadero.VALOR_DIA_CARRO);
		diaMoto = new BigDecimal(tiempo.dia).multiply(AdministracionParqueadero.VALOR_DIA_MOTO);

		if (tiempo.hora >= 9) {
			horaCarro = AdministracionParqueadero.VALOR_DIA_CARRO;
			horaMoto = AdministracionParqueadero.VALOR_DIA_MOTO;
		} else {
			horaCarro = new BigDecimal(tiempo.hora).multiply(AdministracionParqueadero.VALOR_HORA_CARRO);
			horaMoto = new BigDecimal(tiempo.hora).multiply(AdministracionParqueadero.VALOR_HORA_MOTO);
		}

		if (tiempo.minutos <= 0) {
			minutosCarro = BigDecimal.ZERO ;
			minutosMoto = BigDecimal.ZERO;
		}
		
		totalaPagarMoto = diaMoto.add(horaMoto).add(minutosMoto);
		totalaPagarCarro = diaCarro.add(horaCarro.add(minutosCarro));

		if(tipovehiculo == TipoVehiculo.Moto) {
			if (cilindraje >= AdministracionParqueadero.CILINDRAJE_MOTO) {
				totalaPagarMotoMayorCilindraje = totalaPagarMoto.add(AdministracionParqueadero.VALOR_ADICIONAL_CILINDRAJE_MOTO);
				return totalaPagarMotoMayorCilindraje;
				}
			return totalaPagarMoto;
		}else {
			return totalaPagarCarro;

		}
	}
}
