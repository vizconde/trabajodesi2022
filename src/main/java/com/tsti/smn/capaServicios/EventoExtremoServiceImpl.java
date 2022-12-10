
package com.tsti.smn.capaServicios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.tsti.smn.capaDaos.IEventoExtremoRepo;
import com.tsti.smn.capaDaos.IPersonaRepo;
import com.tsti.smn.pojos.EventoExtremo;
import com.tsti.smn.pojos.Persona;
import com.tsti.smn.pojos.Usuario;

@Service
public class EventoExtremoServiceImpl implements EventoExtremoService {

	@Autowired
	IEventoExtremoRepo repo;

	@Autowired
	IPersonaRepo repoPersona;

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public List<EventoExtremo> getAll() {
		return repo.findAll();
	}

	@Override
	public void save(EventoExtremo eventoExtremo) throws Exception {

	    Calendar fDesde = Calendar.getInstance();
	    fDesde.set(Calendar.HOUR_OF_DAY, 0);
	    fDesde.set(Calendar.MINUTE, 0);
	    fDesde.set(Calendar.SECOND, 0);
	    fDesde.set(Calendar.MILLISECOND, 0);

	    Calendar fHasta = Calendar.getInstance();
	    fHasta.set(Calendar.HOUR_OF_DAY, 0);
	    fHasta.set(Calendar.MINUTE, 0);
	    fHasta.set(Calendar.SECOND, 0);
	    fHasta.set(Calendar.MILLISECOND, 0);
	    fHasta.add(Calendar.DAY_OF_YEAR,1);
		
		if (eventoExtremo.getFecha().compareTo(fDesde.getTime()) < 0)
			throw new Exception("Se admiten registros para hoy o mañana");
			else if (eventoExtremo.getFecha().compareTo(fHasta.getTime()) > 0)
			throw new Exception("Se admiten registros para hoy o mañana");
		else
		repo.save(eventoExtremo);
	}

	@Override
	public ArrayList<String> enviarCorreos(EventoExtremo eventoExtremo) {

		ArrayList<String> alertasEnviadas = new ArrayList<String>();

		List<Persona> personas = repoPersona.findAll();

		for (Persona p : personas) {

			if (p.getRecibirAlertas() && p.getCiudad().getId() == eventoExtremo.getCiudad().getId()) {
				alertasEnviadas.add(p.getCorreo());

				try {

					SimpleMailMessage email = new SimpleMailMessage();
					// email.setFrom(Usuario.getEmail());

					email.setTo(p.getCorreo());

					email.setSubject("Existe alerta de evento extremo para su ciudad");

					email.setText(eventoExtremo.getDescripcion());

					mailSender.send(email);

				} catch (Exception e) {

				}
			}
		}
		return alertasEnviadas;
	}
}