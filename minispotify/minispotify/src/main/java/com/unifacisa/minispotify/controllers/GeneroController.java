package com.unifacisa.minispotify.controllers;

import com.unifacisa.minispotify.entities.Genero;
import com.unifacisa.minispotify.services.GeneroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    private final GeneroService service;

    public GeneroController(GeneroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Genero> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Genero criar(@RequestBody Genero genero) {
        return service.salvar(genero);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletarPorId(id);
    }
}
