package com.ceiba.parqueadero.service;

import java.util.List;

import com.ceiba.parqueadero.modelo.EntityVehiculo;

public interface IVehiculoService {
	
	EntityVehiculo saveVehiculo(EntityVehiculo vehiculo);
	EntityVehiculo updateVehiculo(EntityVehiculo vehiculo);
	List<EntityVehiculo> findAllVehiculo();
	EntityVehiculo findByplaca(String placa);
	EntityVehiculo contarCarros(String tipovehiculo);
	EntityVehiculo contarMotos(String tipovehiculo);
	
}
