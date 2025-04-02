package com.miprimerspring.syntaxpelis.service;

import com.miprimerspring.syntaxpelis.model.Genero;

import java.util.List;

public interface GeneroService {

    Genero saveGenero(Genero genero);

    //Declaración de método para buscar lista de Generos
    List<Genero> findAllGenero();

    //Declaración de método para buscar Genero por id
    Genero findById(Long id);

    //Declaración de método para buscar Genero por nombre
    Genero findByNombre(String nombre);

    //Declaración de método para buscar Genero por id
    void deleteGenero(Long id);

}
