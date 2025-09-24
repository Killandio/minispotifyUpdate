package com.unifacisa.minispotify.services;

import com.unifacisa.minispotify.entities.Usuario;
import com.unifacisa.minispotify.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }
}
