package com.miprimerspring.syntaxpelis.PeliculaService;

import com.miprimerspring.syntaxpelis.model.Director;
import com.miprimerspring.syntaxpelis.repository.DirectorRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DirectorServiceImpl implements DirectorService {

    private DirectorRepository directorRepository;

    public DirectorServiceImpl(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public Director saveDirector(Director director) {
        director.setDirectorNombre("Prueba");
        director.setDirectorFechaNacimiento(new Date());
        return directorRepository.save(director);
    }
}
