package com.unifacisa.minispotify.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String email;

    private String telefone;

    // 1:1 (lado inverso) - o dono é PerfilUsuario (tem a FK usuario_id)
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private PerfilUsuario perfil;

    // 1:N (lado inverso) - o dono está em Playlist.owner
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // evita loop no JSON; remova se quiser listar playlists embutidas
    private List<Playlist> playlists = new ArrayList<>();

    public Usuario() { }

    public Usuario(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    // perfil (1:1)
    public PerfilUsuario getPerfil() { return perfil; }
    public void setPerfil(PerfilUsuario perfil) {
        this.perfil = perfil;
        if (perfil != null) {
            perfil.setUsuario(this);
        }
    }

    // playlists (1:N inverso)
    public List<Playlist> getPlaylists() { return playlists; }
    public void setPlaylists(List<Playlist> playlists) { this.playlists = playlists; }

    // helpers opcionais
    public void addPlaylist(Playlist p) {
        playlists.add(p);
        p.setOwner(this);
    }

    public void removePlaylist(Playlist p) {
        playlists.remove(p);
        p.setOwner(null);
    }
}
