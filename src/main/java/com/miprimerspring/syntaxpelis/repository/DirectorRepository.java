package com.miprimerspring.syntaxpelis.repository;

import com.miprimerspring.syntaxpelis.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {

    //JPQL para buscar Director por ID de país
    @Query("SELECT d FROM Director d WHERE d.directorNacionalidad.paisId = :paisId")
    List<Director> findByNacionalidadId(@Param("paisId") Long paisId);

    //El objeto Optional se usa cuando puede que traiga el resultado o no
    Optional<Director> findByDirectorNombre(String nombre);

    //Declaramos un método que verifica si existe director por id
    Boolean existsDirectorByDirectorNombre(String nombre);

    @Query(value = "SELECT * FROM directores d where d.director_id = 1", nativeQuery = true)
    Optional<Director> findById();

}
