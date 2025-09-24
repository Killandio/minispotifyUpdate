package com.unifacisa.minispotify.services;

import com.unifacisa.minispotify.entities.Genero;
import com.unifacisa.minispotify.repositories.GeneroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {

    private final GeneroRepository repository;

    public GeneroService(GeneroRepository repository) {
        this.repository = repository;
    }

    public List<Genero> listarTodos() {
        return repository.findAll();
    }

    public Genero salvar(Genero genero) {
        return repository.save(genero);
    }

    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }

    public Genero buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gênero não encontrado"));
    }
}
