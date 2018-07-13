package com.ceiba.parqueadero.pruebasunitarias;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;
import com.ceiba.parqueadero.dominio.TotalaPagar;
import com.ceiba.parqueadero.modelo.TipoVehiculo;

public class TotalaPagarTest {

	@Test
	public void totalaPagarHoraMotoTest() {
		
		TotalaPagar totalPagarMoto = new TotalaPagar();
		BigDecimal totalaPagarMoto=totalPagarMoto.calcularTotalaPagar(TipoVehiculo.Moto, 0, (LocalDateTime.of(2018, Month.JULY, 9, 7, 20)), LocalDateTime.of(2018, Month.JULY, 9, 8, 25));
		BigDecimal valor=new BigDecimal(1000);
		assertEquals((valor), totalaPagarMoto);
		
	}
	
	@Test
	public void totalaPagarMotoConCilindrajeMayorTest() {
		
		TotalaPagar totalPagarMoto = new TotalaPagar();
		BigDecimal totalaPagarMoto=totalPagarMoto.calcularTotalaPagar(TipoVehiculo.Moto, 650, (LocalDateTime.of(2018, Month.JULY, 9, 7, 20)), LocalDateTime.of(2018, Month.JULY, 9, 17, 20));
		BigDecimal valor=new BigDecimal(6000);
		assertEquals((valor), totalaPagarMoto);
		
	}
	
	@Test
	public void totalaPagarDiaCarroTest() {
		
		TotalaPagar totalPagarMoto = new TotalaPagar();
		BigDecimal totalaPagarMoto=totalPagarMoto.calcularTotalaPagar(TipoVehiculo.Carro, 0, (LocalDateTime.of(2018, Month.JULY, 9, 7, 20)), LocalDateTime.of(2018, Month.JULY, 10, 9, 25));
		BigDecimal valor=new BigDecimal(11000);
		assertEquals((valor), totalaPagarMoto);
		
	}

}
