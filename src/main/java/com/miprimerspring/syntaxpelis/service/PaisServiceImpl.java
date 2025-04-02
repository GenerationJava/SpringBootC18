package com.miprimerspring.syntaxpelis.service;


import com.miprimerspring.syntaxpelis.model.Pais;
import com.miprimerspring.syntaxpelis.repository.PaisRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PaisServiceImpl implements PaisService {

    //Campo que inyecta PaisRepository
    private PaisRepository paisRepository;

    //Constructor
    public PaisServiceImpl(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    //Implementaciones de los métodos declarados en PaisService
    @Override
    public Pais savePais(Pais pais) {
        return paisRepository.save(pais);
    }

    @Override
    public List<Pais> findAllPais() {
        return paisRepository.findAll();
    }

    @Override
    public Pais findById(Long id) {
        return paisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("País no encontrado"));
    }

    @Override
    public Pais findByNombre(String nombre) {
        return paisRepository.findByPaisNombre(nombre).orElse(null);
    }

    @Override
    public void deletePais(Long id) {
        paisRepository.deleteById(id);
    }
}
