package com.tsti.smn.pojos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Pronostico Classe
@Entity
public class Pronostico {
		
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@ManyToOne
	private Ciudad ciudad;
	
	@NotNull
	private Date fechaPronostico;
		
	
	@NotNull
	private Long probabilidadLluvia;
	
	
	@NotNull
	private Long lluviaPrevista;
	
	@Size(max = 500)
	private String descripcionPronostico;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Date getFechaPronostico() {
		return fechaPronostico;
	}

	public void setFechaPronostico(Date fechaPronostico) {
		this.fechaPronostico = fechaPronostico;
	}

	public Long getProbabilidadLluvia() {
		return probabilidadLluvia;
	}

	public void setProbabilidadLluvia(Long probabilidadLluvia) {
		this.probabilidadLluvia = probabilidadLluvia;
	}

	public Long getLluviaPrevista() {
		return lluviaPrevista;
	}

	public void setLluviaPrevista(Long lluviaPrevista) {
		this.lluviaPrevista = lluviaPrevista;
	}

	public String getDescripcionPronostico() {
		return descripcionPronostico;
	}

	public void setDescripcionPronostico(String descripcionPronostico) {
		this.descripcionPronostico = descripcionPronostico;
	}
	
	
	
	
}
