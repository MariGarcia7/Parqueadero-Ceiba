package com.ceiba.parqueadero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.parqueadero.modelo.EntityVehiculo;
import com.ceiba.parqueadero.service.IVehiculoService;

@RestController
public class VehiculoController {

	@Autowired
	private IVehiculoService vehiculoService;

	@RequestMapping(value = "/vehiculo", method = RequestMethod.GET)
	public ResponseEntity<List<EntityVehiculo>> listarVehiculos() {
		return new ResponseEntity<List<EntityVehiculo>>(vehiculoService.findAllVehiculo(), HttpStatus.OK);
		
	}

	@RequestMapping(value = "/vehiculo", method = RequestMethod.POST)
	public ResponseEntity<EntityVehiculo> ingresarVehiculo(@RequestBody EntityVehiculo vehiculo) {
		
		if (vehiculo.getPlaca().equals(null) || vehiculo.getPlaca().isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<EntityVehiculo>(vehiculoService.saveVehiculo(vehiculo), HttpStatus.OK);

	}

	@RequestMapping(value = "/vehiculo", method = RequestMethod.PUT)
	public ResponseEntity<EntityVehiculo> actualizarVehiculo(@RequestBody EntityVehiculo vehiculo) {
		return new ResponseEntity<EntityVehiculo>(vehiculoService.updateVehiculo(vehiculo), HttpStatus.OK);
	}



}
