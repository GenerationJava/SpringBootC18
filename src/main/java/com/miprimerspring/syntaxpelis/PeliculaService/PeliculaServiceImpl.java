package com.miprimerspring.syntaxpelis.PeliculaService;

import com.miprimerspring.syntaxpelis.model.Pelicula;
import com.miprimerspring.syntaxpelis.repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    //Inyectamos la dependencia de repository
    private PeliculaRepository peliculaRepository;
    //Creamos un constructor para la clase y le seteamos el atributo del repository(dependencia)
    public PeliculaServiceImpl(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    @Override
    public Pelicula savePelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public List<Pelicula> findAllPelicula() {
        return peliculaRepository.findAll();
    }
}
