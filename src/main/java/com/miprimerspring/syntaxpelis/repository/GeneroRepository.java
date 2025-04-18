package com.miprimerspring.syntaxpelis.repository;


import com.miprimerspring.syntaxpelis.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {

    //Optional es un contenedor que puede o no, venir con el objeto que se desea buscar
    Optional<Genero> findByGeneroNombre(String nombre);
}
