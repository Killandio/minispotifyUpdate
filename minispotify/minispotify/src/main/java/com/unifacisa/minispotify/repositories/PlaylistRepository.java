package com.unifacisa.minispotify.repositories;

import com.unifacisa.minispotify.entities.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    List<Playlist> findAllByOwnerId(Long ownerId);
}
