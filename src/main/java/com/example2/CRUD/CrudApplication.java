package com.example2.CRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Inicia un servidor web automaticamente / en el application.run datos inicio a la aplicacion de SpringBoot, 
es aqui donde escanea y carga los controladores, servicios y repositorios).
*/

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}
