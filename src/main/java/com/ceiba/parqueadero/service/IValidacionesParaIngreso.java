package com.ceiba.parqueadero.service;

import com.ceiba.parqueadero.modelo.EntityVehiculo;

public interface IValidacionesParaIngreso {
	
	public void validarLetraInicialPlacaYDia(EntityVehiculo vehiculo);
	public boolean validarCuposParqueadero(EntityVehiculo vehiculo);

}
