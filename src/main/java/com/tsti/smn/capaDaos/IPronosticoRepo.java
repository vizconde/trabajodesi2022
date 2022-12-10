package com.tsti.smn.capaDaos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.Pronostico;
import java.util.List;
import java.util.Optional;


public interface IPronosticoRepo extends JpaRepository<Pronostico, Long> {
	
	
	Optional<Pronostico> findById(Long idProvinciaSeleccionada);
	
	@Query(value = "SELECT * FROM pronostico p WHERE p.fecha_pronostico >= now()", nativeQuery=true)
	List<Pronostico> presentFuturePronostico();

}
