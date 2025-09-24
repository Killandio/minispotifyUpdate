package com.unifacisa.minispotify.services;

import com.unifacisa.minispotify.entities.PerfilUsuario;
import com.unifacisa.minispotify.entities.Usuario;
import com.unifacisa.minispotify.repositories.PerfilUsuarioRepository;
import com.unifacisa.minispotify.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilUsuarioService {

    private final PerfilUsuarioRepository perfilRepo;
    private final UsuarioRepository usuarioRepo;

    public PerfilUsuarioService(PerfilUsuarioRepository perfilRepo, UsuarioRepository usuarioRepo) {
        this.perfilRepo = perfilRepo;
        this.usuarioRepo = usuarioRepo;
    }

    public List<PerfilUsuario> listarTodos() {
        return perfilRepo.findAll();
    }

    public PerfilUsuario criarParaUsuario(Long usuarioId, PerfilUsuario perfil) {
        Usuario usuario = usuarioRepo.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado: " + usuarioId));

        // Liga a relação bidirecional
        usuario.setPerfil(perfil); // setPerfil() já chama perfil.setUsuario(this)
        // Por ser 1:1 com cascade no Usuario.perfil, salvar o perfil é suficiente
        return perfilRepo.save(perfil);
    }

    public void deletarPorId(Long id) {
        perfilRepo.deleteById(id);
    }
}
