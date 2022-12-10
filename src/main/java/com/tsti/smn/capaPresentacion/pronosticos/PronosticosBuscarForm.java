package com.tsti.smn.capaPresentacion.pronosticos;

import java.util.Date;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class PronosticosBuscarForm {
	
	@NotNull(message = "Debes especificar la fecha del pronostico")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@FutureOrPresent(message = "La fecha debe ser la actual o futura")
	private Date fechaPronostico;
	
	@NotNull
	private Long idCiudadSeleccionada;

	public Date getFechaPronostico() {
		return fechaPronostico;
	}

	public void setFechaPronostico(Date fechaPronostico) {
		this.fechaPronostico = fechaPronostico;
	}

	public Long getIdCiudadSeleccionada() {
		return idCiudadSeleccionada;
	}

	public void setIdCiudadSeleccionada(Long idCiudadSeleccionada) {
		this.idCiudadSeleccionada = idCiudadSeleccionada;
	}

	

	
	
	
	
}
