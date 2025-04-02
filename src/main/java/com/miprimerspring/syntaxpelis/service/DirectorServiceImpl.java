package com.miprimerspring.syntaxpelis.service;

import com.miprimerspring.syntaxpelis.model.Director;
import com.miprimerspring.syntaxpelis.repository.DirectorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DirectorServiceImpl implements DirectorService {

    //Campo que inyecta DirectorRepository
    private DirectorRepository directorRepository;

    //Constructor
    public DirectorServiceImpl(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }


    //Implementaciones de métodos declarados en DirectorService
    @Override
    public Director saveDirector(Director director) {;
        return directorRepository.save(director);
    }

    @Override
    public List<Director> findAllDirector() {
        return directorRepository.findAll();
    }

    @Override
    public Director findByDirectorId(Long id) {
        return directorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Director no encontrado"));
    }

    @Override
    public Director findByNombre(String nombre) {
        return directorRepository.findByDirectorNombre(nombre).orElse(null);
    }

    @Override
    public List<Director> findByPaisId(Long id) {
        return directorRepository.findByNacionalidadId(id);
    }

    @Override
    public void deleteDirector(Long id) {
        directorRepository.deleteById(id);
    }
}
