package com.tsti.smn.capaPresentacion.clima;

public class EstadoClimaForm {
	//busca el estado del clima en la bd
	
	private String estadoClimaSeleccionado;
	private String estadoActual;
	
	public String getEstadoClimaSeleccionado() {
		return estadoClimaSeleccionado;
	}
	public void setEstadoClimaSeleccionado(String estadoClimaSeleccionado) {
		this.estadoClimaSeleccionado = estadoClimaSeleccionado;
	}
	
	public String getEstadoActual() {
		if( estadoActual != null &&  estadoActual.length() > 0)
			return estadoActual;
		else
			return null;
	}
	public void setEstadoActual(String estadoActual) {
		this.estadoActual = estadoActual;
	}
	
	

}
