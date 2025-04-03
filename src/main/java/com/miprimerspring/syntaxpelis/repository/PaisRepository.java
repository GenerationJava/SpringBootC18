package com.miprimerspring.syntaxpelis.repository;

import com.miprimerspring.syntaxpelis.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

    Optional<Pais> findByPaisNombre(String nombre);



}
