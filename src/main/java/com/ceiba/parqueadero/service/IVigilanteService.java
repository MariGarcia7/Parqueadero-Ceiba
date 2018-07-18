package com.ceiba.parqueadero.service;

import java.util.List;

import com.ceiba.parqueadero.model.Vehiculo;
import com.ceiba.parqueadero.model.TipoVehiculo;

public interface IVigilanteService {
	
	Vehiculo ingresarVehiculo(Vehiculo vehiculo);
	Vehiculo retirarVehiculo(Vehiculo vehiculo);
	List<Vehiculo> consultarVehiculo();
	Vehiculo findByPlaca(String placa);
	long contarPorTipoVehiculo(TipoVehiculo tipovehiculo);

}
