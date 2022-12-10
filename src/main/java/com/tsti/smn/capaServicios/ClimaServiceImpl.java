package com.tsti.smn.capaServicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.Clima;
import com.tsti.smn.pojos.EventoExtremo;
import com.tsti.smn.capaDaos.IClimaRepo;
import com.tsti.smn.capaPresentacion.clima.ClimaForm;
import com.tsti.smn.excepciones.Excepcion; 

@Service
public class ClimaServiceImpl implements ClimaServicio{

	@Autowired
	IClimaRepo repo;
	
	@Override
	public
	List<Clima> getAll(){
		return repo.findAll();
	}
	
	@Override
	public void save(Clima clima) {

		repo.save(clima);
	}

	@Override
	public Clima getById(Long IdClima) {
		
		return repo.findById(IdClima).get();
	}

	@Override
	public List<Clima> filter(ClimaForm filter) throws Excepcion {
		if(filter.getIdClima()== 0 )
			
			throw new Excepcion("Es necesario al menos un filtro");
		else
			return repo.findByIdClima(filter.getIdClima());
	}
	

	
	
}
