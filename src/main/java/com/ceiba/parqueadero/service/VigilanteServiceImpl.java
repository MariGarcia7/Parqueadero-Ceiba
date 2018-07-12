package com.ceiba.parqueadero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.modelo.EntityVehiculo;
import com.ceiba.parqueadero.repository.IVehiculoRepository;

@Service
public class VigilanteServiceImpl implements IVigilanteService {

	@Autowired
	private IVehiculoRepository vehiculoReporsitory;

	@Override
	public EntityVehiculo ingresarVehiculo(EntityVehiculo vehiculo) {
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

}
