package com.ceiba.parqueadero.pruebasunitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.parqueadero.dominio.AdministracionParqueadero;
import com.ceiba.parqueadero.exception.ParqueaderoException;
import com.ceiba.parqueadero.modelo.EntityVehiculo;
import com.ceiba.parqueadero.modelo.TipoVehiculo;
import com.ceiba.parqueadero.repository.IVehiculoRepository;
import com.ceiba.parqueadero.service.IValidacionesParaIngreso;
import com.ceiba.parqueadero.service.IVigilanteService;
import com.ceiba.parqueadero.service.ValidacionesParaIngresoImpl;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class VigilanteTest {
//
//	@Autowired
//	@Qualifier("validaingreso")
	IValidacionesParaIngreso validaciones  = new ValidacionesParaIngresoImpl();
	
	@Mock
	IVehiculoRepository vehiculoRepository;
	
	@Before
	public void inicializacion(){
		MockitoAnnotations.initMocks(this);
	}

	
	@Test
	public void validarCuposParqueaderomotosTest() {
		
		EntityVehiculo vehiculo = new EntityVehiculo(0, "EOT95E", 0, null, null, null, TipoVehiculo.Moto);
		Mockito.when(vehiculoRepository.contarTipoVehiculo(TipoVehiculo.Moto)).thenReturn(10l);
		assertEquals(false, validaciones.validarCuposParqueadero(vehiculo));
		
	
	}
	


}
