package com.ceiba.parqueadero.dominio;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import com.ceiba.parqueadero.exception.ParqueaderoException;
import com.ceiba.parqueadero.modelo.EntityVehiculo;
import com.ceiba.parqueadero.modelo.TipoVehiculo;
import com.ceiba.parqueadero.service.IVehiculoService;
import com.ceiba.parqueadero.service.IVigilanteService;

public class ValidacionesParaIngresarVehiculo {

	@Autowired
	private IVigilanteService vigilanteService;

	@Autowired
	private IVehiculoService vehiculoService;

	public ValidacionesParaIngresarVehiculo(IVigilanteService vigilanteService, IVehiculoService vehiculoService) {
		this.vigilanteService = vigilanteService;
		this.vehiculoService = vehiculoService;
	}

	private void validarLetraInicialPlacaYDia(EntityVehiculo vehiculo) {

		String placa = vehiculo.getPlaca();
		if (vehiculo.tipoVehiculo == TipoVehiculo.Carro && (placa.startsWith("A") || placa.startsWith("a"))) {
			String dia = vehiculo.getFechaHoraIngreso().getDayOfWeek().toString();
			if (!(AdministracionParqueadero.LUNES.equals(dia) || AdministracionParqueadero.DOMINGO.equals(dia))) {
				new ParqueaderoException(AdministracionParqueadero.NO_AUTORIZADO);
			}
		}
	}

	private boolean validarCuposParqueadero(EntityVehiculo vehiculo, long totalVehiculos) {

		if ((vehiculo.tipoVehiculo == TipoVehiculo.Carro && totalVehiculos < AdministracionParqueadero.CUPOS_CARROS)
				|| (vehiculo.tipoVehiculo == TipoVehiculo.Moto && totalVehiculos < AdministracionParqueadero.CUPOS_MOTOS)) {
			return true;
		}
		return false;

	}

	public EntityVehiculo ingresarVehiculos(EntityVehiculo vehiculo) {

		if (vehiculo == null || vehiculo.getPlaca() == null || vehiculo.getPlaca().isEmpty()) {
			return null;
		}
		vehiculo.setFechaHoraIngreso(LocalDateTime.now());
		validarLetraInicialPlacaYDia(vehiculo);
		if (validarCuposParqueadero(vehiculo, vehiculoService.contarPorTipoVehiculo(vehiculo.tipoVehiculo))) {
			return vigilanteService.ingresarVehiculo(vehiculo);
		} else {
			new ParqueaderoException(AdministracionParqueadero.NO_HAY_CUPO);
		}
		return null;
	}
}
