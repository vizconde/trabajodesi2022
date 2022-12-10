package com.tsti.smn.capaPresentacion.pronosticos;

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

import com.tsti.smn.capaPresentacion.personas.PersonasBuscarForm;
import com.tsti.smn.capaServicios.CiudadService;
import com.tsti.smn.capaServicios.PersonaService;
import com.tsti.smn.capaServicios.PronosticoService;
import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.Persona;
import com.tsti.smn.pojos.Pronostico;

@Controller
@RequestMapping("/pronosticosBuscar")
public class PronosticosBuscarController {
	
	@Autowired
    private PronosticoService service;
	@Autowired
    private CiudadService serviceCiudad;
     
    @RequestMapping(method=RequestMethod.GET)
    public String preparaForm(Model modelo) {
    	PronosticosBuscarForm form =  new PronosticosBuscarForm();
    	form.setIdCiudadSeleccionada(1L); //Esto es por ejemplo, si quisiera setear un valor por defecto en el filtro de ciudad 
//    	 form.setCiudades(serviceCiudad.getAll());    //  en lugar de esto hacemos @ModelAttribute("allCiudades")
       modelo.addAttribute("formBean",form);
       return "pronosticosBuscar";
    }
     
  
    @ModelAttribute("allCiudades")
    public List<Ciudad> getAllCiudades() {
        return this.serviceCiudad.getAll();
    }
    
    
}
