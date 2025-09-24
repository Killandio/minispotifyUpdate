package com.unifacisa.minispotify.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "midias")
public class Midia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String tipo;

    @Column(name = "duracao_segundos")
    private Integer duracaoSegundos;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    @ManyToMany(mappedBy = "midias")
    @JsonIgnore
    private Set<Playlist> playlists = new HashSet<>();

    public Midia() { }


    public Midia(Long id, String titulo, String tipo, Integer duracaoSegundos, Genero genero, Set<Playlist> playlists) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.duracaoSegundos = duracaoSegundos;
        this.genero = genero;
        this.playlists = playlists;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Integer getDuracaoSegundos() { return duracaoSegundos; }
    public void setDuracaoSegundos(Integer duracaoSegundos) { this.duracaoSegundos = duracaoSegundos; }

    public Genero getGenero() { return genero; }
    public void setGenero(Genero genero) { this.genero = genero; }

    public Set<Playlist> getPlaylists() { return playlists; }
    public void setPlaylists(Set<Playlist> playlists) { this.playlists = playlists; }
}
