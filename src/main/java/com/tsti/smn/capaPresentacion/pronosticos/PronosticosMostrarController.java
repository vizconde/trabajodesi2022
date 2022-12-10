package com.tsti.smn.capaPresentacion.pronosticos;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tsti.smn.capaServicios.CiudadService;
import com.tsti.smn.capaServicios.PronosticoService;
import com.tsti.smn.excepciones.Excepcion;
import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.Pronostico;

@Controller
@RequestMapping("/pronosticosMostrar")
public class PronosticosMostrarController {
	
	@Autowired
	private PronosticoService servicioPronostico;
	@Autowired
    private CiudadService serviceCiudad;
     
    
	@RequestMapping(path = {"", "/{id}"},method=RequestMethod.GET)
    public String preparaForm(Model modelo, @PathVariable("id") Optional<Long> id) throws Exception {
    	if (id.isPresent()) {
    		Pronostico entity = servicioPronostico.getById(id.get());
    		PronosticoForm form = new PronosticoForm(entity);
			modelo.addAttribute("formBean", form);
		} else {
 
	       modelo.addAttribute("formBean",new PronosticoForm());
		}
       return "pronosticosMostrar";
    }
	
	  @ModelAttribute("allCiudades")
	    public List<Ciudad> getAllCiudades() {
	        return this.serviceCiudad.getAll();
	    }
	  
	  @ModelAttribute("allPronosticos")
	    public List<Pronostico> getAllPronosticos() {
	        return this.servicioPronostico.getAll();
	    }
	  
	  @ModelAttribute("allPronActuales")
	    public List<Pronostico> getAllPronosticosActuales() {
	        return this.servicioPronostico.getPronosticosActuales();
	    }
	  
	  
	  
	  
	  
	  
}
