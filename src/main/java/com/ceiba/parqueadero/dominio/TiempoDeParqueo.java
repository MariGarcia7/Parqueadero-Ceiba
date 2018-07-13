package com.ceiba.parqueadero.dominio;

import java.time.Duration;
import java.time.LocalDateTime;
import com.ceiba.parqueadero.modelo.TiempoTotalDeParqueo;

public class TiempoDeParqueo {

	TiempoTotalDeParqueo calcularTiempoTotal(LocalDateTime fechaHoraIngreso, LocalDateTime fechaHoraSalida) {

		TiempoTotalDeParqueo tiempoTotal = new TiempoTotalDeParqueo();

		Duration duration = Duration.between(fechaHoraIngreso, fechaHoraSalida);
		tiempoTotal.dia = duration.toDays();
		duration = duration.minusDays(tiempoTotal.dia);
		tiempoTotal.hora = duration.toHours();
		duration = duration.minusHours(tiempoTotal.hora);
		tiempoTotal.minutos = duration.toMinutes();

		return tiempoTotal;
	}

}
