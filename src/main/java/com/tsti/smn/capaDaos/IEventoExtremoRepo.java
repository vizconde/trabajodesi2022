package com.tsti.smn.capaDaos;

//Capa de persistencia, se utiliza JPA Repository, se crean interfaces que extiendan de JPA

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.tsti.smn.pojos.EventoExtremo;

//@Repository es lo que identifica que ésta interfaz es inyectable en la capa de servicios
@Repository
public interface IEventoExtremoRepo extends JpaRepository<EventoExtremo, Long> {
	
}