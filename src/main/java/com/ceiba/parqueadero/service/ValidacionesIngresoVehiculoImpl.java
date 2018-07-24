package com.ceiba.parqueadero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceiba.parqueadero.dominio.ConstantesRestriccionesParqueadero;
import com.ceiba.parqueadero.dominio.ConstantesCuposParqueadero;
import com.ceiba.parqueadero.dominio.ConstantesMensajesExcepcion;
import com.ceiba.parqueadero.dominio.ParqueaderoException;
import com.ceiba.parqueadero.model.Vehiculo;
import com.ceiba.parqueadero.model.TipoVehiculo;
import com.ceiba.parqueadero.repository.IVehiculoRepository;

@Service
public class ValidacionesIngresoVehiculoImpl implements IValidacionesIngresoVehiculo {

	@Autowired
	private IVehiculoRepository vehiculoReporsitory;

	@Override
	public boolean validarCamposRequeridos(Vehiculo vehiculo) {
		return (vehiculo.getPlaca() == null || vehiculo.getPlaca().isEmpty());
	}

	@Override
	public boolean validarSiVehiculoEstaRegistrado(Vehiculo vehiculo) {

		Vehiculo vehiculoRegistrado = vehiculoReporsitory.validarSiVehiculoEstaRegistrado(vehiculo.getPlaca());
		return vehiculoRegistrado != null;

	}

	@Override
	public boolean validarLetraInicialPlacaYDia(Vehiculo vehiculo) {

		if (vehiculo.getPlaca().charAt(0) == ConstantesRestriccionesParqueadero.INICIAL_PLACA) {
			String dia = vehiculo.getFechaHoraIngreso().getDayOfWeek().toString();
			if ((ConstantesRestriccionesParqueadero.LUNES.equals(dia) || ConstantesRestriccionesParqueadero.DOMINGO.equals(dia))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean validarCuposParqueadero(Vehiculo vehiculo) {

		long totalVehiculos = vehiculoReporsitory.contarTipoVehiculo(vehiculo.tipoVehiculo);

		if (vehiculo.tipoVehiculo == TipoVehiculo.CARRO) {
			return totalVehiculos < ConstantesCuposParqueadero.CUPOS_CARROS;
		} else {
			return totalVehiculos <= ConstantesCuposParqueadero.CUPOS_MOTOS;
		}

	}

	@Override
	public void aceptarIngresoVehiculo(Vehiculo vehiculo) {

		if (validarCamposRequeridos(vehiculo)) {
			throw new ParqueaderoException(ConstantesMensajesExcepcion.CAMPOS_NO_DILIGENCIADOS);
		}
		if (validarSiVehiculoEstaRegistrado(vehiculo)) {
			throw new ParqueaderoException(ConstantesMensajesExcepcion.VEHICULO_REGISTRADO);
		}
		if (!validarCuposParqueadero(vehiculo)) {
			throw new ParqueaderoException(ConstantesMensajesExcepcion.NO_HAY_CUPO);
		}
		if (validarLetraInicialPlacaYDia(vehiculo)) {
			throw new ParqueaderoException(ConstantesMensajesExcepcion.NO_AUTORIZADO);
		}
	}

	

}
