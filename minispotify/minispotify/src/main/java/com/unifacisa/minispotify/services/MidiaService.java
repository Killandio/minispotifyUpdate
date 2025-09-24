package com.unifacisa.minispotify.services;

import com.unifacisa.minispotify.entities.Midia;
import com.unifacisa.minispotify.repositories.MidiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MidiaService {

    private final MidiaRepository repository;

    public MidiaService(MidiaRepository repository) {
        this.repository = repository;
    }

    public List<Midia> listarTodos() {
        return repository.findAll();
    }

    public Midia salvar(Midia midia) {
        return repository.save(midia);
    }

    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }
}
