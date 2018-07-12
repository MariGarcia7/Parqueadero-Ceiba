package com.ceiba.parqueadero.service;

import com.ceiba.parqueadero.modelo.EntityVehiculo;
import com.ceiba.parqueadero.modelo.TipoVehiculo;

public interface IVehiculoService {

	EntityVehiculo findByPlaca(String placa);
	long contarPorTipoVehiculo(TipoVehiculo tipovehiculo);

}
