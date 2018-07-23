package com.ceiba.parqueadero.model;

public class TiempoTotalDeParqueo {

	private long dia;
	private long hora;
	private long minutos;
	
	
	public TiempoTotalDeParqueo() {
		super();
	}

	public TiempoTotalDeParqueo(long dia, long hora, long minutos) {
		super();
		this.dia = dia;
		this.hora = hora;
		this.minutos = minutos;
	}
	
	public long getDia() {
		return dia;
	}
	public void setDia(long dia) {
		this.dia = dia;
	}
	public long getHora() {
		return hora;
	}
	public void setHora(long hora) {
		this.hora = hora;
	}
	public long getMinutos() {
		return minutos;
	}
	public void setMinutos(long minutos) {
		this.minutos = minutos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (dia ^ (dia >>> 32));
		result = prime * result + (int) (hora ^ (hora >>> 32));
		result = prime * result + (int) (minutos ^ (minutos >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TiempoTotalDeParqueo other = (TiempoTotalDeParqueo) obj;
		if (dia != other.dia)
			return false;
		if (hora != other.hora)
			return false;
		if (minutos != other.minutos)
			return false;
		return true;
	}
	
	
}
