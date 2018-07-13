package com.ceiba.parqueadero.service;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.dominio.AdministracionParqueadero;
import com.ceiba.parqueadero.exception.ParqueaderoException;
import com.ceiba.parqueadero.modelo.EntityVehiculo;
import com.ceiba.parqueadero.modelo.TipoVehiculo;
import com.ceiba.parqueadero.repository.IVehiculoRepository;

@Service("validaingreso")
public class ValidacionesParaIngresoImpl implements IValidacionesParaIngreso {

	@Autowired
	@Qualifier("repositorio")
	private IVehiculoRepository vehiculoReporsitory;

	@Override
	public void validarLetraInicialPlacaYDia(EntityVehiculo vehiculo) {

		String placa = vehiculo.getPlaca();
		vehiculo.setFechaHoraIngreso(LocalDateTime.now());
		if (placa.startsWith(AdministracionParqueadero.INICIAL_PLACA)) {
			String dia = vehiculo.getFechaHoraIngreso().getDayOfWeek().toString();
			if (!(AdministracionParqueadero.LUNES.equals(dia) || AdministracionParqueadero.DOMINGO.equals(dia))) {
				new ParqueaderoException(AdministracionParqueadero.NO_AUTORIZADO);
			}
		}
	}

	@Override
	public boolean validarCuposParqueadero(EntityVehiculo vehiculo) {

		long totalVehiculos = vehiculoReporsitory.contarTipoVehiculo(vehiculo.tipoVehiculo);

		if (vehiculo.tipoVehiculo == TipoVehiculo.Carro) {
			return totalVehiculos < AdministracionParqueadero.CUPOS_CARROS;
		} else {
			return totalVehiculos < AdministracionParqueadero.CUPOS_MOTOS;
		}

	}
	
	

}
