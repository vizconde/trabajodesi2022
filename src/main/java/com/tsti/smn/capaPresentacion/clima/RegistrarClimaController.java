package com.tsti.smn.capaPresentacion.clima;

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

import com.tsti.smn.capaPresentacion.ciudades.CiudadForm;
import com.tsti.smn.capaServicios.CiudadService;
import com.tsti.smn.capaServicios.ClimaServicio;
import com.tsti.smn.capaServicios.EstadoClimaService;
import com.tsti.smn.excepciones.Excepcion;
import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.Clima;
import com.tsti.smn.pojos.EstadoClima;
import com.tsti.smn.pojos.Provincia; 


@Controller
@RequestMapping("/registrarClima")
public class RegistrarClimaController {
	@Autowired
	private ClimaServicio servicioClima;
	
	@Autowired
    private CiudadService servicioCiudad;
		
	@Autowired
	private EstadoClimaService servicioEstadoClima;
	

	
	 @RequestMapping(path = {"", "/{id}"},method=RequestMethod.GET)
	    public String preparaForm(Model modelo, @PathVariable("id") Optional<Long> idClima) throws Exception {

         System.out.println("Ingreso al prepara form");
			if (idClima.isPresent()) {

                System.out.println("Ingreso al idClima");
	    		Clima entity = servicioClima.getById(idClima.get());
	    		ClimaForm form = new ClimaForm(entity);
	    		
				modelo.addAttribute("formBean", form);
				
			} else {
				modelo.addAttribute("formBean",new ClimaForm());
			}
			
	       return "registrarClima";
	    }
	     

    @ModelAttribute("allCiudades")
    public List<Ciudad> getAllCiudad() {
        return this.servicioCiudad.getAll();
    }
    
    @ModelAttribute("allEstadoClima")
    public List<EstadoClima> getAllEstadoClima() {
        return this.servicioEstadoClima.getAll();
    }
    
    
    
    @RequestMapping( method=RequestMethod.POST)
    public String submit( @ModelAttribute("formBean") @Valid ClimaForm form, BindingResult result, ModelMap modelo,@RequestParam String action) throws Excepcion {
    	
    	if(action.equals("Aceptar"))
    	{
    		if(result.hasErrors())
    		{
    			
                System.out.println("Ingreso al form");
    			modelo.addAttribute("formBean",form);
    			
    			 return "redirect:/";
    		}
    		else
    		{
				try {
					Clima c = form.toPojo();
					c.setIdCiudadSeleccionada(servicioCiudad.getById(form.getCiudadSeleccionada()));
					c.setEstadoClima(servicioEstadoClima.getById(form.getidEstadoClima()));

					System.out.println("ciudad" + c.getIdCiudadSeleccionada());
					System.out.println("estado" + c.getEstadoClima());
					System.out.println("humedad" + c.getHumedad());
					System.out.println("temperatura" + c.getTemperatura());

					servicioClima.save(c);
					System.out.println("El registro ha sido guardado");

					return "redirect:/ciudadesBuscar";
					
				} catch (Excepcion e) {
					if(e.getAtributo()==null) //si la excepcion estuviera referida a un atributo del objeto, entonces mostrarlo al lado del compornente (ej. dni)
					{
						ObjectError error = new ObjectError("globalError", e.getMessage());
			            result.addError(error);
					}
					else
					{
			    		FieldError error1 = new FieldError("formBean",e.getAtributo(),e.getMessage());
			            result.addError(error1);
//			            FieldError error2 = new FieldError("form",e.getAtributo(),e.getMessage());
//			            result.addError(error2);

					}
		           
		            modelo.addAttribute("formBean", form);
	    			return "registrarClima";  //Como existe un error me quedo en la misma pantalla
				}
    		}
    	}
    
    	
    	
    	if(action.equals("Cancelar"))
    	{
    		modelo.clear();
    		return "redirect:/ciudadesBuscar";
    	}
    	
    	
    		
    	return "redirect:/";
    	
    	
    }

}
