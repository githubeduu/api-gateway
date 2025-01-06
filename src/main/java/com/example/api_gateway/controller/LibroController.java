package com.example.api_gateway.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@CrossOrigin
public class LibroController {
    
    @GetMapping("/mensaje")
    public String mensaje() {
        
        
        System.out.println("Backend llamado");
        return "{\"mensaje\": \"Integración OK al backend\"}";
    }
    
}
