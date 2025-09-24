package com.unifacisa.minispotify.repositories;

import com.unifacisa.minispotify.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
