package com.ceiba.parqueadero.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.ceiba.parqueadero.modelo.EntityVehiculo;
import com.ceiba.parqueadero.modelo.TipoVehiculo;
import com.ceiba.parqueadero.repository.IVehiculoRepository;

public class VigilanteService {

	@Autowired
	private IVehiculoRepository vehiculoReporsitory;

	public void ingresarVehiculos(EntityVehiculo vehiculo  ) {
		
//		long totalvehiculo = vehiculoReporsitory.contarTipoVehiculo(vehiculo.tipoVehiculo);
//		
//		if (vehiculo.tipoVehiculo == TipoVehiculo.Carro) {
//			if (totalvehiculo < 20) {
//				LocalDateTime fechaHoraIngreso;
//				fechaHoraIngreso = LocalDateTime.now();
//				vehiculo.setFechaHoraIngreso(fechaHoraIngreso);
//				vehiculoReporsitory.save(vehiculo);
//			}
//		}
		
		
		//vehiculoReporsitory.save(vehiculo);

	}

	public void retirarVehiculos() {

	}

	public void consultarInfoVehiculos() {

	}

}
