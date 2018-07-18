package com.ceiba.parqueadero.service;

import com.ceiba.parqueadero.model.Vehiculo;

public interface IValidacionesIngresoVehiculo {
	
	public boolean validarLetraInicialPlacaYDia(Vehiculo vehiculo);
	public boolean validarCuposParqueadero(Vehiculo vehiculo);
	public boolean validarCamposRequeridos(Vehiculo vehiculo);
	public boolean validarSiVehiculoEstaRegistrado(Vehiculo vehiculo);
	public void aceptarIngresoVehiculo(Vehiculo vehiculo);
	
}
