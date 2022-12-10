package com.tsti.smn.pojos;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EventoExtremo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date fecha;

	private String descripcion;
	
	@ManyToOne
	private Ciudad ciudad;
	
	

	public EventoExtremo() {
		super();
		
	}
	

	public EventoExtremo(EventoExtremo e) {
		super();
		this.id = e.getId();
		this.fecha = e.getFecha();
		this.descripcion = e.getDescripcion();
		this.ciudad = e.getCiudad();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
}