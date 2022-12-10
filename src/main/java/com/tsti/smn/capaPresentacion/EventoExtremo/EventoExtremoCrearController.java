package com.tsti.smn.capaPresentacion.EventoExtremo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tsti.smn.capaServicios.CiudadService;
import com.tsti.smn.capaServicios.EventoExtremoService;
import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.EventoExtremo;

@Controller
@RequestMapping("/eventoExtremoCrear")
public class EventoExtremoCrearController {

	@Autowired
	private EventoExtremoService service;
	

	@Autowired
	private CiudadService serviceCiudad;

	@RequestMapping(method = RequestMethod.GET)
	public String preparaForm(Model modelo) {
		EventoExtremoForm form = new EventoExtremoForm();
		modelo.addAttribute("formBean", form);
		return "eventoExtremoCrear";
	}

	@ModelAttribute("allCiudades")
	public List<Ciudad> getAllCiudades() {

		return this.serviceCiudad.getAll();
	}

	
	@ModelAttribute("allEventosExtremos")
	public List<EventoExtremo> getAllEventosExtremos() {
		return this.service.getAll();
	}
//las validaciones se configuran en el Form y aquí se infica con @Valid cuando se aplican
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("formBean") @Valid EventoExtremoForm formBean, BindingResult result,
			ModelMap modelo, @RequestParam String action) {

		if (action.equals("Aceptar")) {
			if (result.hasErrors()) {
				modelo.addAttribute("formBean", formBean);

				return "eventoExtremoCrear";//hay un error y vuelve a la misma pantalla
			} else {
				EventoExtremo e = formBean.toPojo();

			
				e.setCiudad(serviceCiudad.getById(formBean.getIdCiudad()));
				
				try {
					service.save(e);
				
				service.enviarCorreos(e);
				ArrayList<String> alertasEnviadas = service.enviarCorreos(e);
    			
    			if (alertasEnviadas.size() == 0)
    			{
    				alertasEnviadas.add("No hay subscripciones para enviar alertas.");
    			}
    			
    			modelo.addAttribute("resultados",alertasEnviadas);

    			return "eventoExtremoCrear";
    			
				} catch (Exception ex) {

					ObjectError error = new ObjectError("globalError", ex.getMessage());

					result.addError(error);
					modelo.addAttribute("formBean",formBean);

					return "eventoExtremoCrear";
				}
    		}
    	}
    	if(action.equals("Cancelar"))
    	{
    		modelo.clear();

    		return "redirect:/";
    	}
    	return "redirect:/";
    }
}