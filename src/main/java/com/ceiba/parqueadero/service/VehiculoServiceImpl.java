package com.ceiba.parqueadero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceiba.parqueadero.modelo.EntityVehiculo;
import com.ceiba.parqueadero.modelo.TipoVehiculo;
import com.ceiba.parqueadero.repository.IVehiculoRepository;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

	@Autowired
	private IVehiculoRepository vehiculoReporsitory;

	@Override
	public EntityVehiculo findByPlaca(String placa) {

		return null;
	}

	@Override
	public long contarPorTipoVehiculo(TipoVehiculo tipovehiculo) {
		return vehiculoReporsitory.contarTipoVehiculo(tipovehiculo);
	}

}
