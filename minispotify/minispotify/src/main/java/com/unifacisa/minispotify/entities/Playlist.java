package com.unifacisa.minispotify.entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "playlists")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id")
    private Usuario owner;

    @ManyToMany
    @JoinTable(
            name = "playlist_midias",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "midia_id")
    )
    private Set<Midia> midias = new HashSet<>();

    public Playlist() { }

    public Playlist(Long id, String nome, Usuario owner) {
        this.id = id;
        this.nome = nome;
        this.owner = owner;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Usuario getOwner() { return owner; }
    public void setOwner(Usuario owner) { this.owner = owner; }

    public Set<Midia> getMidias() { return midias; }
    public void setMidias(Set<Midia> midias) { this.midias = midias; }

    // helpers
    public void addMidia(Midia m) { this.midias.add(m); }
    public void removeMidia(Midia m) { this.midias.remove(m); }
}
