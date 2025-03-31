package com.miprimerspring.syntaxpelis.repository;

import com.miprimerspring.syntaxpelis.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiRepository extends JpaRepository<Usuario, Long> {

}
