package com.ceiba.parqueadero.service;

import java.util.List;
import com.ceiba.parqueadero.modelo.EntityVehiculo;

public interface IVigilanteService {
	
	EntityVehiculo ingresarVehiculo(EntityVehiculo vehiculo);
	EntityVehiculo retirarVehiculo(EntityVehiculo vehiculo);
	List<EntityVehiculo> consultarVehiculo();

}
