package com.tsti.smn.capaServicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsti.smn.capaDaos.IEstadoClimaRepo;
import com.tsti.smn.capaPresentacion.clima.ClimaForm;
import com.tsti.smn.excepciones.Excepcion;
import com.tsti.smn.pojos.EstadoClima;


@Service
public class EstadoClimaImpl implements EstadoClimaService{
	@Autowired
	IEstadoClimaRepo repo;

	@Override
	public List<EstadoClima> getAll() {
		return repo.findAll();
	}



	@Override
	public EstadoClima getById(Long idEstadoClima) {
		System.out.println(idEstadoClima);
		return repo.findById(idEstadoClima).get();
	}



	@Override
	public List<EstadoClima> filter(ClimaForm filter) throws Excepcion {

		if (filter.getEstadoSeleccionado() == null) {

			throw new Excepcion("Es necesario al menos un filtro");
		} else
			return repo.findByEstado(filter.getEstadoSeleccionado());
	}



}
