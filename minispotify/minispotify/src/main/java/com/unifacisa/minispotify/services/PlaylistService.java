package com.unifacisa.minispotify.services;

import com.unifacisa.minispotify.entities.Midia;
import com.unifacisa.minispotify.entities.Playlist;
import com.unifacisa.minispotify.entities.Usuario;
import com.unifacisa.minispotify.repositories.MidiaRepository;
import com.unifacisa.minispotify.repositories.PlaylistRepository;
import com.unifacisa.minispotify.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final UsuarioRepository usuarioRepository;
    private final MidiaRepository midiaRepository;

    public PlaylistService(
            PlaylistRepository playlistRepository,
            UsuarioRepository usuarioRepository,
            MidiaRepository midiaRepository
    ) {
        this.playlistRepository = playlistRepository;
        this.usuarioRepository = usuarioRepository;
        this.midiaRepository = midiaRepository;
    }

    public Playlist create(Playlist request) {
        if (request.getOwner() == null || request.getOwner().getId() == null) {
            throw new IllegalArgumentException("Owner.id é obrigatório para criar playlist.");
        }
        Usuario owner = usuarioRepository.findById(request.getOwner().getId())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado: " + request.getOwner().getId()));

        Playlist p = new Playlist();
        p.setNome(request.getNome());
        p.setOwner(owner);
        return playlistRepository.save(p);
    }

    public List<Playlist> list(Long ownerId) {
        if (ownerId != null) {
            return playlistRepository.findAllByOwnerId(ownerId);
        }
        return playlistRepository.findAll();
    }


    public Playlist findById(Long id) {
        return playlistRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Playlist não encontrada: " + id));
    }


    public Playlist rename(Long playlistId, String novoNome) {
        Playlist p = findById(playlistId);
        p.setNome(novoNome == null ? null : novoNome.trim());
        return playlistRepository.save(p);
    }


    public Playlist addMidia(Long playlistId, Long midiaId) {
        Playlist p = findById(playlistId);
        Midia m = midiaRepository.findById(midiaId)
                .orElseThrow(() -> new EntityNotFoundException("Mídia não encontrada: " + midiaId));

        p.addMidia(m);
        return playlistRepository.save(p);
    }


    public Playlist removeMidia(Long playlistId, Long midiaId) {
        Playlist p = findById(playlistId);
        Midia m = midiaRepository.findById(midiaId)
                .orElseThrow(() -> new EntityNotFoundException("Mídia não encontrada: " + midiaId));

        p.removeMidia(m);
        return playlistRepository.save(p);
    }


    public void delete(Long id) {
        if (!playlistRepository.existsById(id)) {
            throw new EntityNotFoundException("Playlist não encontrada: " + id);
        }
        playlistRepository.deleteById(id);
    }
}
