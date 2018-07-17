package com.ceiba.parqueadero.service;

import com.ceiba.parqueadero.model.EntityVehiculo;

public interface IValidacionesIngresoVehiculo {
	
	public boolean validarLetraInicialPlacaYDia(EntityVehiculo vehiculo);
	public boolean validarCuposParqueadero(EntityVehiculo vehiculo);
	public boolean validarCamposRequeridos(EntityVehiculo vehiculo);
	public boolean validarSiVehiculoEstaRegistrado(EntityVehiculo vehiculo);
	public void aceptarIngresoVehiculo(EntityVehiculo vehiculo);
	
}
