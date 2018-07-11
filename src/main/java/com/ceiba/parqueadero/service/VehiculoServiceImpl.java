package com.ceiba.parqueadero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.modelo.EntityVehiculo;
import com.ceiba.parqueadero.repository.IVehiculoRepository;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

	@Autowired
	private IVehiculoRepository vehiculoReporsitory;

	@Override
	public EntityVehiculo saveVehiculo(EntityVehiculo vehiculo) {

		return vehiculoReporsitory.save(vehiculo);

	}

	@Override
	public EntityVehiculo updateVehiculo(EntityVehiculo vehiculo) {

		return vehiculoReporsitory.saveAndFlush(vehiculo);

	}

	@Override
	public List<EntityVehiculo> findAllVehiculo() {

		return vehiculoReporsitory.findAll();
	}

	@Override
	public EntityVehiculo findByplaca(String placa) {

		return null;
	}

	@Override
	public EntityVehiculo contarCarros(String tipovehiculo) {

		return null;
	}

	@Override
	public EntityVehiculo contarMotos(String tipovehiculo) {

		return null;
	}

}
