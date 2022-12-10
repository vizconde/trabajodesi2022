package com.tsti.smn.capaDaos;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tsti.smn.pojos.Clima;
@Repository
public interface IClimaRepo extends  JpaRepository<Clima, Long> {
	@Query("SELECT c FROM Clima c WHERE c.id=?1")
	List<Clima> findByIdClima(Long idClima);
}
