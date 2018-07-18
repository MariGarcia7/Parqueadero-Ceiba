package com.ceiba.parqueadero.pruebasunitarias;

import static org.junit.Assert.*;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.ceiba.parqueadero.model.Vehiculo;
import com.ceiba.parqueadero.model.TipoVehiculo;
import com.ceiba.parqueadero.repository.IVehiculoRepository;
import com.ceiba.parqueadero.service.IValidacionesIngresoVehiculo;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidacionesTest {

	@Autowired
	private IValidacionesIngresoVehiculo validaciones;
	
	@MockBean
	IVehiculoRepository vehiculoRepository;
	
	@Before
	public void inicializacion(){
		MockitoAnnotations.initMocks(this);
	}

	
	@Test
	public void validarCuposParqueaderoMotosTest() {
		
		Vehiculo vehiculo = new Vehiculo(0, "EOT95E", 0, null, null, null, TipoVehiculo.MOTO);
		Mockito.when(vehiculoRepository.contarTipoVehiculo(TipoVehiculo.MOTO)).thenReturn(10l);
		assertEquals(false, validaciones.validarCuposParqueadero(vehiculo));
		
	}
	
	@Test
	public void validarLetraInicialPlacaYDia() {
		
		Vehiculo vehiculo = new Vehiculo(0, "EOT95E", 0, LocalDateTime.of(2018, Month.JULY, 16, 14, 25), null, null, TipoVehiculo.MOTO);
		assertEquals(false, validaciones.validarLetraInicialPlacaYDia(vehiculo));
		
	}

}
