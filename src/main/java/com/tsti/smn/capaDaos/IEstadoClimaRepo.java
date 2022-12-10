package com.tsti.smn.capaDaos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tsti.smn.pojos.EstadoClima;

@Repository
public interface IEstadoClimaRepo extends JpaRepository<EstadoClima, Long> {
	@Query("SELECT e FROM EstadoClima e WHERE e.nombre like ?1" )
	List<EstadoClima> findByEstado(String estadoSeleccionado);

}
