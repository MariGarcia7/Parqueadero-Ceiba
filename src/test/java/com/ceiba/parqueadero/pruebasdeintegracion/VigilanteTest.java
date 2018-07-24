package com.ceiba.parqueadero.pruebasdeintegracion;

import static org.junit.Assert.*;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import com.ceiba.parqueadero.ParqueaderoApplication;
import com.ceiba.parqueadero.model.TipoVehiculo;
import com.ceiba.parqueadero.model.Vehiculo;
import com.ceiba.parqueadero.repository.IVehiculoRepository;
import com.ceiba.parqueadero.service.VigilanteServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ParqueaderoApplication.class)
@Transactional
@Rollback(value=true)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class VigilanteTest {

	@Autowired
	VigilanteServiceImpl vigilante;
	
	@Autowired
	IVehiculoRepository vehiculoRepository;
	
	@Test
	public void ingresarVehiculotest() {
		
		Vehiculo vehiculo = new Vehiculo(0, "xxxxxx", 250, null, null, null, TipoVehiculo.MOTO);
		vigilante.ingresarVehiculo(vehiculo);
		assertEquals(vehiculoRepository.validarSiVehiculoEstaRegistrado(vehiculo.getPlaca()),vehiculo);
		
	}

}
