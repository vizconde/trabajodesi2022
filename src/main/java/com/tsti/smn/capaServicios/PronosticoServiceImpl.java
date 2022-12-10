package com.tsti.smn.capaServicios;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsti.smn.capaDaos.IPronosticoRepo;
import com.tsti.smn.excepciones.Excepcion;
import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.Persona;
import com.tsti.smn.pojos.Pronostico;

@Service
public class PronosticoServiceImpl implements PronosticoService{

	@Autowired
	IPronosticoRepo repo;
	
	//implementacion del metodo para buscar todo los pronosticos
	@Override
	public List<Pronostico> getAll() {
		
		return repo.findAll();
	}
	
	
	//implementa servicio para buscar un pronostico por id
	@Override
	public Pronostico getById(Long idPronostico) {

		return repo.findById(idPronostico).get();
	}
	
	
	//guarda pronostico
	@Override
	public void save(Pronostico p) throws Excepcion {
		repo.save(p);
	}


	@Override
	public List<Pronostico> getPronosticosActuales() {
		// TODO Auto-generated method stub
		return repo.presentFuturePronostico();
	}
	
	
}
