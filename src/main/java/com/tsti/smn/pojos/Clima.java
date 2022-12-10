package com.tsti.smn.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import com.tsti.smn.pojos.Ciudad;



import com.tsti.smn.pojos.EstadoClima;

@Entity
public class Clima {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@ManyToOne
	private Ciudad idCiudadSeleccionada;
	private int temperatura;
	
	@ManyToOne
	private EstadoClima estadoClima;
	private int humedad; //en porcentajes
	
	
	public Long getIdClima() {
		return id;
	}
	public void setIdClima(Long idClima) {
		this.id = idClima;
	}
	
	public int getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}
	
	public EstadoClima getEstadoClima() {
		return estadoClima;
	}
	public void setEstadoClima(EstadoClima estadoClima) {
		this.estadoClima = estadoClima;
	}
	
	public int getHumedad() {
		return humedad;
	}
	public void setHumedad(int humedad) {
		this.humedad = humedad;
	}

	public Ciudad getIdCiudadSeleccionada() {
		return idCiudadSeleccionada;
	}
	public void setIdCiudadSeleccionada(Ciudad idCiudadSeleccionada) {
		this.idCiudadSeleccionada = idCiudadSeleccionada;
	}
	
	

}
