package com.unifacisa.minispotify.controllers;

import com.unifacisa.minispotify.entities.Playlist;
import com.unifacisa.minispotify.services.PlaylistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    // POST /playlists
    @PostMapping
    public Playlist create(@RequestBody Playlist body) {
        return playlistService.create(body);
    }

    // GET /playlists  (opcional: ?ownerId=1)
    @GetMapping
    public List<Playlist> list(@RequestParam(required = false) Long ownerId) {
        return playlistService.list(ownerId);
    }

    // GET /playlists/{id}
    @GetMapping("/{id}")
    public Playlist get(@PathVariable Long id) {
        return playlistService.findById(id);
    }

    // PUT /playlists/{id}/nome?nome=Novo+Nome
    @PutMapping("/{id}/nome")
    public Playlist rename(@PathVariable Long id, @RequestParam String nome) {
        return playlistService.rename(id, nome);
    }

    // POST /playlists/{playlistId}/midias/{midiaId}
    @PostMapping("/{playlistId}/midias/{midiaId}")
    public Playlist addMidia(@PathVariable Long playlistId, @PathVariable Long midiaId) {
        return playlistService.addMidia(playlistId, midiaId);
    }

    // DELETE /playlists/{playlistId}/midias/{midiaId}
    @DeleteMapping("/{playlistId}/midias/{midiaId}")
    public Playlist removeMidia(@PathVariable Long playlistId, @PathVariable Long midiaId) {
        return playlistService.removeMidia(playlistId, midiaId);
    }

    // DELETE /playlists/{id}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playlistService.delete(id);
    }
}
