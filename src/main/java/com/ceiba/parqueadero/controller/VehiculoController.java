package com.ceiba.parqueadero.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ceiba.parqueadero.model.Vehiculo;
import com.ceiba.parqueadero.service.IVigilanteService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
public class VehiculoController {

	@Autowired
	private IVigilanteService vigilanteService;

	
	@RequestMapping(value = "/vehiculo", method = RequestMethod.POST)
	public ResponseEntity<Vehiculo> ingresarVehiculo(@RequestBody Vehiculo vehiculo) {
		return new ResponseEntity<Vehiculo>(vigilanteService.ingresarVehiculo(vehiculo), HttpStatus.OK);
	}

	@RequestMapping(value = "/vehiculo", method = RequestMethod.PUT)
	public ResponseEntity<Vehiculo> actualizarVehiculo(@RequestBody Vehiculo vehiculo) {
		return new ResponseEntity<Vehiculo>(vigilanteService.retirarVehiculo(vehiculo), HttpStatus.OK);
	}

	@RequestMapping(value = "/vehiculo", method = RequestMethod.GET)
	public ResponseEntity<List<Vehiculo>> listarVehiculos() {
		return new ResponseEntity<List<Vehiculo>>(vigilanteService.consultarVehiculo(), HttpStatus.OK);

	}

}
