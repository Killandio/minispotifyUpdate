package com.unifacisa.minispotify.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "perfis")
public class PerfilUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;
    private String pais;

    // Dono da relação 1:1 (tem a FK)
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "usuario_id", unique = true)
    private Usuario usuario;

    public PerfilUsuario() { }

    public PerfilUsuario(String bio, String pais) {
        this.bio = bio;
        this.pais = pais;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
