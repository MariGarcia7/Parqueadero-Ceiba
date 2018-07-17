package com.ceiba.parqueadero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceiba.parqueadero.dominio.ConstantesMensajesExcepcion;
import com.ceiba.parqueadero.dominio.ParqueaderoException;
import com.ceiba.parqueadero.model.EntityVehiculo;
import com.ceiba.parqueadero.repository.IVehiculoRepository;

@Service
public class ValidacionesRetiroVehiculoImpl implements IValidacionesRetiroVehiculo {

	
	@Autowired
	private IVehiculoRepository vehiculoReporsitory;
	
	@Override
	public EntityVehiculo aceptarRetiroVehiculo(EntityVehiculo vehiculo) {

		EntityVehiculo vehiculoRegistrado = vehiculoReporsitory.validarSiVehiculoEstaRegistrado(vehiculo.getPlaca());

		if (vehiculoRegistrado == null) {

			throw new ParqueaderoException(ConstantesMensajesExcepcion.VEHICULO_NO_REGISTRADO);

		}
		return vehiculoRegistrado;

	}

}
