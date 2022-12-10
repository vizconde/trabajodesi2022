package com.tsti.smn.capaServicios;

import java.util.List;

import com.tsti.smn.excepciones.Excepcion;
import com.tsti.smn.pojos.Persona;
import com.tsti.smn.pojos.Pronostico;



public interface PronosticoService {

	//metodo para obtener todos los pronostico
	List<Pronostico> getAll();
	
	
	/**
	 * Obtiene un pronostico determinado
	 * @param idPronostico Identificador de la pronostico buscado
	 * @return Pronostico encontrada
	 */
	Pronostico getById(Long idPronostico) ;
	
	/**
	 * Si el pronostico existe lo actualizará, sino lo creará en BD
	 * @param Pronostico
	 * @throws Exception 
	 */
	void save(Pronostico pronostico) throws Excepcion;
	
	
	/**
	 * Obtiene pronosticos actuales y futuros
	 * @return Pronosticos actuales y futuros
	 */
	
	List<Pronostico> getPronosticosActuales();
	
}
