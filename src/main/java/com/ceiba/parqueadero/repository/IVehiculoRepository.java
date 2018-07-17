package com.ceiba.parqueadero.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ceiba.parqueadero.model.EntityVehiculo;
import com.ceiba.parqueadero.model.TipoVehiculo;

@Repository("repositorio")
public interface IVehiculoRepository extends JpaRepository<EntityVehiculo, Long> {
	
	@Query(value="SELECT count(*) FROM EntityVehiculo WHERE tipoVehiculo=:tipoVehiculo")
			long contarTipoVehiculo(@Param("tipoVehiculo") TipoVehiculo tipoVehiculo);
	
	@Query(value="SELECT v FROM EntityVehiculo v WHERE v.placa=:placa AND v.fechaHoraSalida=null")
	EntityVehiculo validarSiVehiculoEstaRegistrado(@Param("placa") String placa);
	
	
}
