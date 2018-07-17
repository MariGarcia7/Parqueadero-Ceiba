package com.ceiba.parqueadero.dominio;

public class ConstantesMensajesExcepcion {
	
	public static final String NO_HAY_CUPO = "No hay cupo disponible";
	public static final String CAMPOS_NO_DILIGENCIADOS = "Los campos requeridos no están diligenciados";
	public static final String VEHICULO_REGISTRADO = "El vehiculo ya se encuentra dentro del parqueadero";
	public static final String VEHICULO_NO_REGISTRADO = "El vehiculo no se encuentra dentro del parqueadero";
	public static final String NO_AUTORIZADO = "No esta autorizado a ingresar:Placas que inician por la letra A solo pueden ingresar al parqueadero los días Domingo y Lunes";
	
	private ConstantesMensajesExcepcion() {
		
	}

}
