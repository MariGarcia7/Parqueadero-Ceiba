package com.ceiba.parqueadero.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.dominio.CalculadoraDeParqueadero;
import com.ceiba.parqueadero.model.EntityVehiculo;
import com.ceiba.parqueadero.model.TipoVehiculo;
import com.ceiba.parqueadero.repository.IVehiculoRepository;

@Service
public class VigilanteServiceImpl implements IVigilanteService {

	@Autowired
	private IVehiculoRepository vehiculoReporsitory;

	@Autowired
	private ValidacionesIngresoVehiculoImpl validaciones;
	
	@Autowired
	private ValidacionesRetiroVehiculoImpl validacionesRetiro;

	@Override
	public EntityVehiculo ingresarVehiculo(EntityVehiculo vehiculo) {
		validaciones.aceptarIngresoVehiculo(vehiculo);
		vehiculo.setFechaHoraIngreso(LocalDateTime.now());
		return vehiculoReporsitory.save(vehiculo);
	}

	@Override
	public EntityVehiculo retirarVehiculo(EntityVehiculo vehiculo) {
		EntityVehiculo vehiculoRegistrado = validacionesRetiro.aceptarRetiroVehiculo(vehiculo);
		vehiculoRegistrado.setFechaHoraSalida(LocalDateTime.now());
		CalculadoraDeParqueadero totalaPagar = new CalculadoraDeParqueadero();
		BigDecimal total = totalaPagar.calcularTotalaPagar(vehiculoRegistrado);
		vehiculoRegistrado.setTotalPagar(total);
		return vehiculoReporsitory.saveAndFlush(vehiculoRegistrado);
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
