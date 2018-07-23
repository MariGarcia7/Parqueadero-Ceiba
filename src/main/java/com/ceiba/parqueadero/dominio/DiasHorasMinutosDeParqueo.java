package com.ceiba.parqueadero.dominio;

import java.time.Duration;
import java.time.LocalDateTime;
import com.ceiba.parqueadero.model.TiempoTotalDeParqueo;

public class DiasHorasMinutosDeParqueo {

	public TiempoTotalDeParqueo calcularTiempoTotal(LocalDateTime fechaHoraIngreso, LocalDateTime fechaHoraSalida) {

		TiempoTotalDeParqueo tiempoTotal = new TiempoTotalDeParqueo();

		Duration duration = Duration.between(fechaHoraIngreso, fechaHoraSalida);
		tiempoTotal.setDia(duration.toDays()); 
		duration = duration.minusDays(tiempoTotal.getDia());
		tiempoTotal.setHora(duration.toHours()); 
		duration = duration.minusHours(tiempoTotal.getHora());
		tiempoTotal.setMinutos(duration.toMinutes()); 

		return tiempoTotal;
	}

}
