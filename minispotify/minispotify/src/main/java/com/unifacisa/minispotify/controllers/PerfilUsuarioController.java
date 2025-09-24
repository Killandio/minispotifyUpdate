package com.unifacisa.minispotify.controllers;

import com.unifacisa.minispotify.entities.PerfilUsuario;
import com.unifacisa.minispotify.services.PerfilUsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfis")
public class PerfilUsuarioController {

    private final PerfilUsuarioService service;

    public PerfilUsuarioController(PerfilUsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<PerfilUsuario> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public PerfilUsuario criar(@RequestParam Long usuarioId, @RequestBody PerfilUsuario perfil) {
        return service.criarParaUsuario(usuarioId, perfil);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletarPorId(id);
    }
}
