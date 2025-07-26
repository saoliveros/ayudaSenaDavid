package com.example2.CRUD.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Email;



@Entity
public class Persona {

    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
     
    /*Datos personales básicos*/
    private Long id;
    private String rol; 
    public Persona() {
        this.rol = "USER";
    }
 
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;
    
    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String apellido;
    
    @Email(message = "El email debe tener un formato válido")
    @NotBlank(message = "El email es obligatorio")
    @Pattern(
            regexp = "^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$",
            message = "El formato del email no es válido"
        )
    private String email;
    
    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "\\d{10,10}", message = "El teléfono debe tener 10 dígitos")
    private String telefono;
    
    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;
    
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String password;
    
    
    
    
    /*Métodos accesores (Getters y Setters)*/
    
    
    /*Obtiene el ID de la persona - @return Long con el identificador único*/
    public Long getId() {
        return id;
    }   

    /*Establece el ID de la persona*/
    public void setId(Long id) {
        this.id = id;
    }
    
    
    /*Obtiene el nombre de la persona - @return String con el nombre*/
    public String getNombre() {
        return nombre;
    }

    /*Establece el nombre de la persona*/
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    /*Los demás getters y setters seguirían el mismo patrón de documentación*/
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
     public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
}
    
