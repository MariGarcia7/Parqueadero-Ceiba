package com.ceiba.parqueadero.service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import com.ceiba.parqueadero.dominio.AdministracionParqueadero;
import com.ceiba.parqueadero.exception.ParqueaderoException;
import com.ceiba.parqueadero.modelo.EntityVehiculo;
import com.ceiba.parqueadero.modelo.TipoVehiculo;
import com.ceiba.parqueadero.repository.IVehiculoRepository;

public class VigilanteService {

	@Autowired
	private IVehiculoRepository vehiculoReporsitory;

	public void almacenarVehiculo(EntityVehiculo vehiculo) {
		vehiculoReporsitory.save(vehiculo);
	}
	 
	private void validarDia(EntityVehiculo vehiculo) {
		if (vehiculo.tipoVehiculo == TipoVehiculo.Carro) {
			String dia = vehiculo.getFechaHoraIngreso().getDayOfWeek().toString();
			if (AdministracionParqueadero.LUNES.equals(dia) || AdministracionParqueadero.DOMINGO == dia ) {
				new ParqueaderoException("No esta autorizado para ingresar");
			}
		}
	}
	

	private boolean validarCupo(EntityVehiculo vehiculo, long totalVehiculos) {

		if ((vehiculo.tipoVehiculo == TipoVehiculo.Carro && totalVehiculos < AdministracionParqueadero.CUPOS_CARROS)
				|| (vehiculo.tipoVehiculo == TipoVehiculo.Moto && totalVehiculos < AdministracionParqueadero.CUPOS_MOTOS)) {
			return true;
		}  
		return false;
		
	}

	public void ingresarVehiculos(EntityVehiculo vehiculo) throws ParqueaderoException {
		EntityVehiculo newVehiculo = new EntityVehiculo();
		newVehiculo.setPlaca("UIO123");
		newVehiculo.setTipoVehiculo(TipoVehiculo.Carro);
		newVehiculo.setFechaHoraIngreso(LocalDateTime.now());
		
		validarDia(vehiculo); 
		if (validarCupo(vehiculo, vehiculoReporsitory.contarTipoVehiculo(vehiculo.tipoVehiculo))) {
			almacenarVehiculo(vehiculo);
		} else {
			new ParqueaderoException(AdministracionParqueadero.NO_HAY_CUPO);
		}
	}

	public void retirarVehiculos() {

	}

	public void consultarInfoVehiculos() {

	}

}
