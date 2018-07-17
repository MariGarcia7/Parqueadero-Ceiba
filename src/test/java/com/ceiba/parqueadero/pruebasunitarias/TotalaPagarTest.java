package com.ceiba.parqueadero.pruebasunitarias;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.ceiba.parqueadero.dominio.CalculadoraDeParqueadero;
import com.ceiba.parqueadero.model.EntityVehiculo;
import com.ceiba.parqueadero.model.TipoVehiculo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TotalaPagarTest {

	@Test
	public void totalaPagarHoraMotoTest() {

		EntityVehiculo vehiculo = new EntityVehiculo(0, "EOT95E", 0, LocalDateTime.of(2018, Month.JULY, 9, 7, 20),
				LocalDateTime.of(2018, Month.JULY, 9, 8, 25), null, TipoVehiculo.MOTO);
		CalculadoraDeParqueadero totalPagarMoto = new CalculadoraDeParqueadero();
		BigDecimal totalaPagarMoto = totalPagarMoto.calcularTotalaPagar(vehiculo);
		BigDecimal valor = new BigDecimal(1000);
		assertEquals((valor), totalaPagarMoto);

	}

	@Test
	public void totalaPagarMotoConCilindrajeMayorTest() {

		EntityVehiculo vehiculo = new EntityVehiculo(0, "EOT95E", 650, LocalDateTime.of(2018, Month.JULY, 9, 7, 20),
				LocalDateTime.of(2018, Month.JULY, 9, 17, 20), null, TipoVehiculo.MOTO);
		CalculadoraDeParqueadero totalPagarMoto = new CalculadoraDeParqueadero();
		BigDecimal totalaPagarMoto = totalPagarMoto.calcularTotalaPagar(vehiculo);
		BigDecimal valor = new BigDecimal(6000);
		assertEquals((valor), totalaPagarMoto);

	}

	@Test
	public void totalaPagarHoraCarroTest() {

		EntityVehiculo vehiculo = new EntityVehiculo(0, "EOT95E", 650, LocalDateTime.of(2018, Month.JULY, 16, 14, 25),
				LocalDateTime.of(2018, Month.JULY, 16, 20, 45), null, TipoVehiculo.CARRO);
		CalculadoraDeParqueadero totalPagarCarro = new CalculadoraDeParqueadero();
		BigDecimal totalaPagarCarro = totalPagarCarro.calcularTotalaPagar(vehiculo);
		BigDecimal valor = new BigDecimal(7000);
		assertEquals((valor), totalaPagarCarro);

	}

	@Test
	public void totalaPagarDiaCarroTest() {

		EntityVehiculo vehiculo = new EntityVehiculo(0, "EOT95E", 650, LocalDateTime.of(2018, Month.JULY, 14, 19, 00),
				LocalDateTime.of(2018, Month.JULY, 16, 11, 49), null, TipoVehiculo.CARRO);
		CalculadoraDeParqueadero totalPagarCarro = new CalculadoraDeParqueadero();
		BigDecimal totalaPagarCarro = totalPagarCarro.calcularTotalaPagar(vehiculo);
		BigDecimal valor = new BigDecimal(17000);
		assertEquals((valor), totalaPagarCarro);

	}

}
