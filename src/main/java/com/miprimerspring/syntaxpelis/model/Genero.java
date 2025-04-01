package com.miprimerspring.syntaxpelis.model;

import jakarta.persistence.*;

@Entity
@Table(name = "generos")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long generoId;


    @Column(name = "genero_nombre", unique = true, nullable = false)
    private String generoNombre;

    public Genero() {
    }

    public Genero(long generoId, String generoNombre) {
        this.generoId = generoId;
        this.generoNombre = generoNombre;
    }

    public long getGeneroId() {
        return generoId;
    }

    public void setGeneroId(long generoId) {
        this.generoId = generoId;
    }

    public String getGeneroNombre() {
        return generoNombre;
    }

    public void setGeneroNombre(String generoNombre) {
        this.generoNombre = generoNombre;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "generoId=" + generoId +
                ", generoNombre='" + generoNombre + '\'' +
                '}';
    }
}
