package com.example2.CRUD.controller;

import com.example2.CRUD.model.Persona;
import com.example2.CRUD.service.PersonaService;
import jakarta.servlet.http.HttpSession; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/login")
    public String mostrarLogin(Model model,
                               @RequestParam(value = "error", required = false) String error,
                               @RequestParam(value = "logout", required = false) String logout,
                               @RequestParam(value = "exitoRegistro", required = false) String exitoRegistro) {
        if (error != null) {
            model.addAttribute("error", "Correo o contraseña incorrectos.");
        }
        if (logout != null) {
            model.addAttribute("logout", "Has cerrado sesión exitosamente.");
        }
        if (exitoRegistro != null) {
            model.addAttribute("exito", "¡Persona registrada exitosamente! Ahora puedes iniciar sesión.");
        }
        return "login";
    }

    // Procesa el formulario de login
    @PostMapping("/login")
    public String procesarLogin(@RequestParam String email, @RequestParam String password,
                                HttpSession session, RedirectAttributes redirectAttrs) {
        // 1. Buscar la persona por el email
        Persona persona = personaService.buscarPorEmail(email).orElse(null);

        // 2. Verificar si la persona existe y la contraseña coincide
        if (persona != null && persona.getPassword().equals(password)) {
            session.setAttribute("usuarioLogueado", persona);
            return "redirect:/personas?mensaje=loginExitoso"; 
        } else {
            redirectAttrs.addFlashAttribute("error", "true"); 
            return "redirect:/login?error=true"; 
        }
    }

}