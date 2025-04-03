package com.miprimerspring.syntaxpelis.repository;

import com.miprimerspring.syntaxpelis.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository//Esta es una especificación para indicar que este repository debe ser manejado por el contenedor de Spring
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    //Declaramos un método para buscar película por anio
    List<Pelicula> findByPeliculaAnio(Integer anio);

    @Query("SELECT p FROM Pelicula p JOIN p.peliculaDirector d WHERE d.directorNombre = :nombreDirector")
    List<Pelicula> findByDirectorNombre(@Param("nombreDirector") String nombreDirector);


}
