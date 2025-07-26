package com.example2.CRUD.controller;

import com.example2.CRUD.model.Persona;
import com.example2.CRUD.service.PersonaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.servlet.http.HttpSession;


/*esto es un controlador Spring MVC para devolver vistas*/
@Controller

/*Aqui establecemos que todas las rutas del controlador inician con /personas*/
@RequestMapping("/personas")
public class PersonaController {
    
    
    /*Lógica del negocio dentro del servicio que inyectamos (@Autowired)*/
    @Autowired
    private PersonaService personaService;
    
    
    /*
    Mapea solicitudes HTTP GET a /personas 
    */
    @GetMapping
     public String listarPersonas(Model model, HttpSession session){
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/login"; // Si no está logueado, redirige al login
        }
        model.addAttribute("personas", personaService.listarTodas());
        return "persona-list";
    }
    
   
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevaPersona (Model model) {
        model.addAttribute("persona", new Persona());
        return "persona-form";
    }
    
   
    @GetMapping("/")
    public String inicio(){
        return "index";
    }


    @PostMapping
    public String guardarPersona(@Valid Persona persona, BindingResult result, RedirectAttributes redirectAttrs){
        if (result.hasErrors()){
            return "persona-form";
        }
        
         personaService.guardar(persona);
        if (persona.getId() != null) {
            return "redirect:/personas?mensaje=editado"; // Redirige a la lista con un parámetro
        } else {
            // Si es un nuevo registro, redirigimos al login con un mensaje de "registrado"
            return "redirect:/login?mensaje=registrado"; // Redirige al login con un parámetro
        }
        }

    
    
     
   

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarPersona(@PathVariable Long id, Model model, HttpSession session){
        if (session.getAttribute("usuarioLogueado") == null){
            return "redurect:/login";
        }
        model.addAttribute("persona", personaService.obtenerPorId(id));
        return "persona-form";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id, HttpSession session, RedirectAttributes redirectAttrs){
        if (session.getAttribute("usuarioLogueado") == null){
            return "redirect:/login";
        }
        
        personaService.eliminar(id);
        return "redirect:/personas?mensaje=eliminado";
    } 
    
}
