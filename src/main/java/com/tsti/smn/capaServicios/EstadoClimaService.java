package com.tsti.smn.capaServicios;

import java.util.List;

import com.tsti.smn.capaPresentacion.clima.ClimaForm;

import com.tsti.smn.excepciones.Excepcion;

import com.tsti.smn.pojos.EstadoClima;

public interface EstadoClimaService {
	
	List<EstadoClima> getAll();
	
	
	
	EstadoClima getById(Long id) ;
	List<EstadoClima> filter(ClimaForm filter) throws Excepcion;
	
}
