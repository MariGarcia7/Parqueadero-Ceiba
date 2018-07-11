package com.ceiba.parqueadero.dominio;

import java.time.Duration;
import java.time.LocalDateTime;
import com.ceiba.parqueadero.modelo.TiempoTotalDeParqueo;

public class TiempoDeParqueo {

	TiempoTotalDeParqueo calcularTiempoTotal(LocalDateTime fechaHoraIngreso, LocalDateTime fechaHoraSalida) {

		TiempoTotalDeParqueo tiempoTotal = new TiempoTotalDeParqueo();
		
		tiempoTotal.dia= calcularDias(fechaHoraIngreso, fechaHoraSalida);
		tiempoTotal.hora= calcularHoras(fechaHoraIngreso, fechaHoraSalida);
		tiempoTotal.minutos = calcularDias(fechaHoraIngreso, fechaHoraSalida);
		
		return tiempoTotal;
	}

	public long calcularDias(LocalDateTime fechaHoraIngreso, LocalDateTime fechaHoraSalida) {

		Duration duration = Duration.between(fechaHoraIngreso, fechaHoraSalida);
		return duration.toDays();

	}

	public long calcularHoras(LocalDateTime fechaHoraIngreso, LocalDateTime fechaHoraSalida) {

		Duration duration = Duration.between(fechaHoraIngreso, fechaHoraSalida);

		long days = duration.toDays();
		duration = duration.minusDays(days);

		return duration.toHours();
	}

	public long calcularMinutos(LocalDateTime fechaHoraIngreso, LocalDateTime fechaHoraSalida) {

		Duration duration = Duration.between(fechaHoraIngreso, fechaHoraSalida);

		long days = duration.toDays();
		duration = duration.minusDays(days);
		long hours = duration.toHours();
		duration = duration.minusHours(hours);

		return duration.toMinutes();
	}

}
