package com.miprimerspring.syntaxpelis.service;

import com.miprimerspring.syntaxpelis.model.Pais;

import java.util.List;

public interface PaisService {

    Pais savePais(Pais pais);
    List<Pais> findAllPais();

    //Declaración de método para buscar País por ID
    Pais findById(Long id);

    //Declaración de método para buscar País por nombre
    Pais findByNombre(String nombre);

    //Declaración de método para eliminar País por id
    void deletePais(Long id);
}
