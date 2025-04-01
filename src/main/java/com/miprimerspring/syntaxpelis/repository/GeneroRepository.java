package com.miprimerspring.syntaxpelis.repository;


import com.miprimerspring.syntaxpelis.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {
}
