package com.ceiba.parqueadero.dominio;

public class ParqueaderoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ParqueaderoException(String mensaje) {
		super(mensaje);
	}
}
