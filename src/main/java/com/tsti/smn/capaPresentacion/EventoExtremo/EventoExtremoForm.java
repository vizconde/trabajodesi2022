package com.tsti.smn.capaPresentacion.EventoExtremo;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Future.List;
import javax.validation.constraints.FutureOrPresent;

import org.springframework.format.annotation.DateTimeFormat;
import com.tsti.smn.pojos.EventoExtremo;

public class EventoExtremoForm {
	private Long idEventoExtremo;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull
	private Date fecha;
	@NotNull
	private Long idCiudad;
	
	@NotNull
	@Size(min=1, max=500, message= "la descripción no puede ser nula y debe ocupar menos de 500 caracteres")
	private String descripcion;
	
	public EventoExtremoForm() {
		super();
	}
	public EventoExtremoForm(EventoExtremo e) {
		super();
		this.idEventoExtremo = e.getId() ;
		this.fecha = e.getFecha();
		this.idCiudad = e.getCiudad().getId();//aplique lo indicado de referenciar al IdCiudad que resulta mas sencillo de representar en JSON
		this.descripcion = e.getDescripcion();
	}


	public Long getIdEventoExtremo() {
		return idEventoExtremo;
	}
	public void setIdEventoExtremo(Long idEventoExtremo) {
		this.idEventoExtremo = idEventoExtremo;
	}
	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Long getIdCiudad() {
		return idCiudad;
	}


	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	public EventoExtremo toPojo()
	{
		EventoExtremo eventoExtremo = new EventoExtremo();
		eventoExtremo.setDescripcion(this.getDescripcion());
		eventoExtremo.setFecha(this.getFecha());
		return eventoExtremo;
	}

	
	}