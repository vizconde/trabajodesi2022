package com.tsti.smn.capaServicios;

import java.util.ArrayList;
import java.util.List;
import com.tsti.smn.pojos.EventoExtremo;



public interface EventoExtremoService {

	List<EventoExtremo> getAll();
	
	void save(EventoExtremo eventoExtremo) throws Exception;
	
	ArrayList<String> enviarCorreos(EventoExtremo eventoExtremo);
}

