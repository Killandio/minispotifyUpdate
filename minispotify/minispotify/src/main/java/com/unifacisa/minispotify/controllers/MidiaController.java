package com.unifacisa.minispotify.controllers;

import com.unifacisa.minispotify.entities.Midia;
import com.unifacisa.minispotify.services.MidiaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/midias")
public class MidiaController {

    private final MidiaService service;

    public MidiaController(MidiaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Midia> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Midia criar(@RequestBody Midia midia) {
        return service.salvar(midia);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletarPorId(id);
    }
}
