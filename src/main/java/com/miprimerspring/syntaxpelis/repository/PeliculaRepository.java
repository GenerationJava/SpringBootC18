package com.miprimerspring.syntaxpelis.repository;

import com.miprimerspring.syntaxpelis.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//Esta es una especificación para indicar que este repository debe ser manejado por el contenedor de Spring
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {


}
