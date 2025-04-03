package com.miprimerspring.syntaxpelis.service;

import com.miprimerspring.syntaxpelis.model.Pelicula;
import com.miprimerspring.syntaxpelis.repository.DirectorRepository;
import com.miprimerspring.syntaxpelis.repository.PeliculaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional//Cuando tenemos métodos que realizan alguna persistencia, queremsos que suceda bajo los principios ACID
public class PeliculaServiceImpl implements PeliculaService {

    //Inyectamos la dependencia de repository
    private PeliculaRepository peliculaRepository;

    //Inyectamos la dependencia de DirectorRepository
    private DirectorRepository directorRepository;

    //Creamos un constructor para la clase y le seteamos el atributo del repository(dependencia)
    public PeliculaServiceImpl(PeliculaRepository peliculaRepository,
                               DirectorRepository directorRepository) {
        this.peliculaRepository = peliculaRepository;
        this.directorRepository = directorRepository;
    }

    //Guardar película
    @Override
    public Pelicula savePelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    //Buscar lista de peliculas
    @Override
    public List<Pelicula> findAllPelicula() {
        return peliculaRepository.findAll();
    }

    //Buscar una película por ID
    @Override
    public Pelicula findById(Long id) {
        return peliculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La pelicula con " + id + " no existe"));
    }

    //Buscar lista de películas por año
    @Override
    public List<Pelicula> findByAnio(Integer anio) {
        //Validamos que el año ingresado que esté dentro del rango
        if (anio < 1870 || anio > 2025) {
            throw new RuntimeException("El año no es válido");
        }
        return peliculaRepository.findByPeliculaAnio(anio);
    }

    @Override
    public List<Pelicula> findByDirector(String nombreDirector) {
        //Llamado al método findByDirectorNombre
        if (!directorRepository.existsDirectorByDirectorNombre(nombreDirector)) {
            throw new RuntimeException("El director no ha sido encontrado");
        }
        return peliculaRepository.findByDirectorNombre(nombreDirector);
    }

    @Override
    public void deleteById(Long id) {
        //Validamos que existe la película
        Pelicula peliculaBorrar = findById(id);
        //Verificamos que la película exista en la BDD
        if (peliculaBorrar == null) {
            throw new RuntimeException("La pelicula con " + id + " no existe");
        }
        //LLamamos al método delete
        peliculaRepository.deleteById(id);
    }


}
