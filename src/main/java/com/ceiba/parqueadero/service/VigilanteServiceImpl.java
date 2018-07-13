package com.ceiba.parqueadero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.modelo.EntityVehiculo;
import com.ceiba.parqueadero.modelo.TipoVehiculo;
import com.ceiba.parqueadero.repository.IVehiculoRepository;

@Service
public class VigilanteServiceImpl implements IVigilanteService {

	@Autowired
	@Qualifier("repositorio")
	private IVehiculoRepository vehiculoReporsitory;
	
	@Autowired
	@Qualifier("validaingreso")
	private ValidacionesParaIngresoImpl validaciones;

	@Override
	public EntityVehiculo ingresarVehiculo(EntityVehiculo vehiculo) {
		validaciones.
		return vehiculoReporsitory.save(vehiculo);
	}

	@Override
	public EntityVehiculo retirarVehiculo(EntityVehiculo vehiculo) {
		
		return vehiculoReporsitory.saveAndFlush(vehiculo);
	}

	@Override
	public List<EntityVehiculo> consultarVehiculo() {

		return vehiculoReporsitory.findAll();
	}

	@Override
	public EntityVehiculo findByPlaca(String placa) {

		return null;
	}

	@Override
	public long contarPorTipoVehiculo(TipoVehiculo tipovehiculo) {
		return vehiculoReporsitory.contarTipoVehiculo(tipovehiculo);
	}

}
