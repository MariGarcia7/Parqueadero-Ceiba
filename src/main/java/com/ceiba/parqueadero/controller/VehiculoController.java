package com.ceiba.parqueadero.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ceiba.parqueadero.model.EntityVehiculo;
import com.ceiba.parqueadero.service.IVigilanteService;

@RestController
public class VehiculoController {

	@Autowired
	private IVigilanteService vigilanteService;

	
	@RequestMapping(value = "/vehiculo", method = RequestMethod.POST)
	public ResponseEntity<EntityVehiculo> ingresarVehiculo(@RequestBody EntityVehiculo vehiculo) {
		return new ResponseEntity<EntityVehiculo>(vigilanteService.ingresarVehiculo(vehiculo), HttpStatus.OK);
	}

	@RequestMapping(value = "/vehiculo", method = RequestMethod.PUT)
	public ResponseEntity<EntityVehiculo> actualizarVehiculo(@RequestBody EntityVehiculo vehiculo) {
		return new ResponseEntity<EntityVehiculo>(vigilanteService.retirarVehiculo(vehiculo), HttpStatus.OK);
	}

	@RequestMapping(value = "/vehiculo", method = RequestMethod.GET)
	public ResponseEntity<List<EntityVehiculo>> listarVehiculos() {
		return new ResponseEntity<List<EntityVehiculo>>(vigilanteService.consultarVehiculo(), HttpStatus.OK);

	}

}
