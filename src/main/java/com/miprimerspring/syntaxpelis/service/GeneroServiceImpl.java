package com.miprimerspring.syntaxpelis.service;

import com.miprimerspring.syntaxpelis.model.Genero;
import com.miprimerspring.syntaxpelis.repository.GeneroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class GeneroServiceImpl implements GeneroService{

    //Campo que inyecta GeneroRepository
    private GeneroRepository generoRepository;

    //Constructor
    public GeneroServiceImpl(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    //Implementación de métodos declarados en GeneroService
    @Override
    public Genero saveGenero(Genero genero) {
        return generoRepository.save(genero);
    }

    @Override
    public List<Genero> findAllGenero() {
        return generoRepository.findAll();
    }

    @Override
    public Genero findById(Long id) {
        return generoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Género no encontrado"));
    }

    @Override
    public Genero findByNombre(String nombre) {
        return generoRepository.findByGeneroNombre(nombre)
                .orElse(null);
    }

    @Override
    public void deleteGenero(Long id) {
        generoRepository.deleteById(id);
    }
}
