package com.ceiba.parqueadero.pruebasunitarias;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;
import org.junit.Test;
import com.ceiba.parqueadero.dominio.DiasHorasMinutosDeParqueo;
import com.ceiba.parqueadero.model.TiempoTotalDeParqueo;

public class TiempoParqueoTest {

	@Test
	public void calcularTiempoTotalDeParqueo() {

		DiasHorasMinutosDeParqueo tiempoDeParqueo = new DiasHorasMinutosDeParqueo();
		TiempoTotalDeParqueo tiempoTotal = tiempoDeParqueo.calcularTiempoTotal(LocalDateTime.of(2018, Month.JULY, 9, 9, 20), LocalDateTime.of(2018, Month.JULY, 12, 13, 20));
		TiempoTotalDeParqueo tiempoTotalReal = new TiempoTotalDeParqueo(3,4,0);
		assertEquals(tiempoTotalReal, tiempoTotal);
		
	}

}
