package com.ceiba.parqueadero.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ceiba.parqueadero.model.TipoVehiculo;
import com.ceiba.parqueadero.model.Vehiculo;

@Repository("repositorio")
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
	
	@Query(value="SELECT count(*) FROM Vehiculo WHERE tipoVehiculo=:tipoVehiculo")
			long contarTipoVehiculo(@Param("tipoVehiculo") TipoVehiculo tipoVehiculo);
	
	@Query(value="SELECT v FROM Vehiculo v WHERE v.placa=:placa AND v.fechaHoraSalida=null")
	Vehiculo validarSiVehiculoEstaRegistrado(@Param("placa") String placa);
	
	@Query(value="SELECT v FROM Vehiculo v WHERE v.fechaHoraSalida=null")
	List<Vehiculo> vehiculoEnParqueadero();
	
	@Query(value="SELECT v FROM Vehiculo v WHERE v.fechaHoraSalida!=null")
	List<Vehiculo> historialVehiculos();
}
