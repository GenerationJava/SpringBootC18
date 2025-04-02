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

    Optional<Director> findByDirectorNombre(String nombre);

}
