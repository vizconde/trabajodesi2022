package com.tsti.smn.capaServicios;
	import java.util.List;


import com.tsti.smn.pojos.Clima;
import com.tsti.smn.pojos.EstadoClima;
import com.tsti.smn.capaPresentacion.clima.ClimaForm;
import com.tsti.smn.capaPresentacion.clima.EstadoClimaForm;
import com.tsti.smn.excepciones.Excepcion;

public interface ClimaServicio {
	
	List<Clima> getAll();
	
	Clima getById(Long IdClima);
	void save(Clima c) throws Excepcion;
	
	List<Clima> filter(ClimaForm filter) throws Excepcion;
//	List<EstadoClima> filter(EstadoClimaForm filter) throws Excepcion;

	
	
}
