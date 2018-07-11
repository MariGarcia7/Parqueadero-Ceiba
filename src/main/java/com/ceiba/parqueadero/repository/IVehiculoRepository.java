package com.ceiba.parqueadero.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ceiba.parqueadero.modelo.EntityVehiculo;
import com.ceiba.parqueadero.modelo.TipoVehiculo;


public interface IVehiculoRepository extends JpaRepository<EntityVehiculo, Long> {
	
	@Query(value="SELECT count(*) FROM EntityVehiculo WHERE tipoVehiculo=:tipoVehiculo")
			long contarTipoVehiculo(@Param("tipoVehiculo") TipoVehiculo tipoVehiculo);
	
	
	
	
	
}
