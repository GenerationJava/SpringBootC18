package com.miprimerspring.syntaxpelis.service;

import com.miprimerspring.syntaxpelis.model.Pelicula;

import java.util.List;

public interface PeliculaService {

    //Declaro el método savePelicula, sin implementación
    Pelicula savePelicula(Pelicula pelicula);

    List<Pelicula> findAllPelicula();


}
