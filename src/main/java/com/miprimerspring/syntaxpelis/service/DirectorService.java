package com.miprimerspring.syntaxpelis.service;

import com.miprimerspring.syntaxpelis.model.Director;

import java.util.List;

public interface DirectorService {

    Director saveDirector(Director director);

    //Declaración de método para buscar lista de Directores
    List<Director> findAllDirector();

    //Declaración de método para buscar Director por ID
    Director findByDirectorId(Long id);

    //Declaración de método para buscar Directores por nombre
    Director findByNombre(String nombre);

    //Declaración de método para buscar Directores por nacionalidad
    List<Director> findByPaisId(Long id);

    //Declaración de método para eliminar Director por ID
    void deleteDirector(Long id);
}
