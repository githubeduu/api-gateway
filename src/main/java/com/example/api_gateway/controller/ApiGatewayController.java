package com.example.api_gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
@RequestMapping("/api/libros") // Prefijo para las rutas relacionadas con libros
public class ApiGatewayController {

    private final RestTemplate restTemplate;

    @Value("${microservice.libros.base.url}")
    private String librosServiceUrl;

    public ApiGatewayController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // GET: Obtener todos los libros
    @GetMapping
    public String getLibros() {
        String url = librosServiceUrl + "/libros";
        return restTemplate.getForObject(url, String.class);
    }

    // POST: Crear un libro
    @PostMapping
    public String createLibro(@RequestBody String libro) {
        String url = librosServiceUrl + "/libros";
        return restTemplate.postForObject(url, libro, String.class);
    }

    // PUT: Actualizar un libro por ID
    @PutMapping("/{id}")
    public String updateLibro(@PathVariable int id, @RequestBody String libro) {
        String url = librosServiceUrl + "/libros/" + id;
        restTemplate.put(url, libro);
        return "Libro actualizado con ID: " + id;
    }

    // DELETE: Eliminar un libro por ID
    @DeleteMapping("/{id}")
    public String deleteLibro(@PathVariable int id) {
        String url = librosServiceUrl + "/libros/" + id;
        restTemplate.delete(url);
        return "Libro eliminado con ID: " + id;
    }

    // GET: Obtener un libro por ID
    @GetMapping("/{id}")
    public String getLibroById(@PathVariable int id) {
        String url = librosServiceUrl + "/libros/" + id;
        return restTemplate.getForObject(url, String.class);
    }

    // GET: Buscar libros por palabra clave
    @GetMapping("/buscar")
    public String buscarLibros(@RequestParam String keyword) {
        String url = librosServiceUrl + "/libros/buscar?keyword=" + keyword;
        return restTemplate.getForObject(url, String.class);
    }
}
