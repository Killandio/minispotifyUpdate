package com.unifacisa.minispotify.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "generos")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Midia> midias = new ArrayList<>();

    public Genero() { }

    public Genero(String nome) {
        this.nome = nome;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<Midia> getMidias() { return midias; }
    public void setMidias(List<Midia> midias) { this.midias = midias; }
}
