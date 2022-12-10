package com.tsti.smn.capaPresentacion.clima;


import com.tsti.smn.pojos.Clima;


public class ClimaForm {
	private long id;
	private long idEstadoClima;
	
	private int temperatura;
	private int humedad;
	
	private String nombreCiudad;
	private String estadoSeleccionado;
	private long ciudadSeleccionada;
	
	
	public ClimaForm() {
		super();
	}
	
	
	public ClimaForm(Clima c) {
		super();
		this.temperatura = c.getTemperatura();
		this.idEstadoClima = c.getEstadoClima().getId();
		this.humedad = c.getHumedad();
		this.id = c.getIdClima();
		this.ciudadSeleccionada = c.getIdCiudadSeleccionada().getId();
	}


	public int getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(int temperatura) {
		System.out.println("setteo temperatura");
		this.temperatura = temperatura;
	}
	
	
	
	public int getHumedad() {
		return humedad;
	}
	public void setHumedad(int humedad) {
		this.humedad = humedad;
	}
	
	
	
	public long getidEstadoClima() {
		return idEstadoClima;
	}
	public void setidEstadoClima(Long idEstadoClima) {
		System.out.println("setteo estado clima");
		this.idEstadoClima = idEstadoClima;
	}


	public long getIdClima() {
		return id;
	}
	public void setIdClima(long idClima) {
		this.id = idClima;
	}

	public long getCiudadSeleccionada() {
		return ciudadSeleccionada;
	}
	public void setCiudadSeleccionada(long ciudadSeleccionada) {
		this.ciudadSeleccionada = ciudadSeleccionada;
	}


	public String getNombreCiudad() {
		return nombreCiudad;
	}
	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}


	public long getIdEstadoClima() {
		return idEstadoClima;
	}
	public void setIdEstadoClima(long idEstadoClima) {
		this.idEstadoClima = idEstadoClima;
	}


	public String getEstadoSeleccionado() {
		return estadoSeleccionado;
	}
	public void setEstadoSeleccionado(String estadoSeleccionado) {
		this.estadoSeleccionado = estadoSeleccionado;
	}


	public Clima toPojo()
	{
		Clima c = new Clima();

		System.out.println("tempertuta "+this.temperatura);
		System.out.println("humedad "+this.humedad);
		System.out.println("estado clima "+this.idEstadoClima);
		System.out.println("ciudad "+this.ciudadSeleccionada);

		c.setTemperatura(this.temperatura);
		c.setHumedad(this.humedad);
		
		return c;
	}
	
	
}
