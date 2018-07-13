package com.ceiba.parqueadero.service;

import java.util.List;
import com.ceiba.parqueadero.modelo.EntityVehiculo;
import com.ceiba.parqueadero.modelo.TipoVehiculo;

public interface IVigilanteService {
	
	EntityVehiculo ingresarVehiculo(EntityVehiculo vehiculo);
	EntityVehiculo retirarVehiculo(EntityVehiculo vehiculo);
	List<EntityVehiculo> consultarVehiculo();
	EntityVehiculo findByPlaca(String placa);
	long contarPorTipoVehiculo(TipoVehiculo tipovehiculo);

}
