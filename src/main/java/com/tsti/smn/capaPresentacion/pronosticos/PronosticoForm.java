package com.tsti.smn.capaPresentacion.pronosticos;


import java.util.Date;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import com.tsti.smn.pojos.Pronostico;

/**
 * Objeto necesario para insertar o eliminar una pronostico. 
 * Nótese que en lugar de referenciar al objeto Ciudad, reemplaza ese atributo por el idCiudad, lo cual resulta mas sencillo de representar en JSON
 *
 */
public class PronosticoForm {

	private Long id;
	
	
	@NotNull
	private Long idCiudad;
	
	@NotNull(message = "Debes especificar la fecha del pronostico")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@FutureOrPresent(message = "La fecha debe ser la actual o futura")
	private Date fechaPronostico;
		
	
	@NotNull(message = "Debes Ingresar probabilidad de lluvia")
	@Min(0)
	private Long probabilidadLluvia;
	
	
	@NotNull(message = "Ingresar mm de lluvia prevista")
	@Min(0)
	private Long lluviaPrevista;
	
	@NotNull(message = "Ingresar descripcion del pronostico")
	@Size(max = 500)
	private String descripcionPronostico;
	
	
	public PronosticoForm() {
		super();
	}
	
	public PronosticoForm(Pronostico p) {
		super();
		this.id=p.getId();
		this.idCiudad=p.getCiudad().getId();
		this.fechaPronostico=p.getFechaPronostico();
		this.probabilidadLluvia=p.getProbabilidadLluvia();
		this.lluviaPrevista=p.getLluviaPrevista();
		this.descripcionPronostico=p.getDescripcionPronostico();
	}
		

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
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
	
	public Pronostico toPojo()
	{
		Pronostico p = new Pronostico();
		p.setId(this.getId());
		p.setFechaPronostico(this.getFechaPronostico());
		p.setLluviaPrevista(this.getLluviaPrevista());
		p.setProbabilidadLluvia(this.getProbabilidadLluvia());
		p.setDescripcionPronostico(this.getDescripcionPronostico());
		
		return p;
	}

	public String getDescripcionPronostico() {
		return descripcionPronostico;
	}

	public void setDescripcionPronostico(String descripcionPronostico) {
		this.descripcionPronostico = descripcionPronostico;
	}
	
	
}
