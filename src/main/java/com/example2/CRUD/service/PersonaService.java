package com.example2.CRUD.service;

import com.example2.CRUD.model.Persona;
import com.example2.CRUD.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> listarTodas(){
        return personaRepository.findAll();
    }

    public Persona obtenerPorId(Long id){
        return personaRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id){
        personaRepository.deleteById(id);
    }

     public Persona guardar(Persona persona){
         return personaRepository.save(persona);
     }
     
     public Optional<Persona> buscarPorEmail(String email) {
        return personaRepository.findByEmail(email);
    }
}