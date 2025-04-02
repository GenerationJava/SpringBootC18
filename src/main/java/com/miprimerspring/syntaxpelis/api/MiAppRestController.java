package com.miprimerspring.syntaxpelis.api;

import com.miprimerspring.syntaxpelis.service.*;
import com.miprimerspring.syntaxpelis.model.*;
import com.miprimerspring.syntaxpelis.repository.MiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MiAppRestController {


    //Autowired es una manera de inyectar dependencias, pero no se recomienda usarla. Mejor usar constructores
    @Autowired
    private MiRepository miRepository;

    @Autowired
    private PeliculaServiceImpl peliculaService;

    @Autowired
    private DirectorServiceImpl directorService;

    @Autowired
    private GeneroServiceImpl generoService;

    @Autowired
    private PaisServiceImpl paisService;

    @Value("${custom.message}")
    private String message;

    @GetMapping("/message")
    public String getMessage() {
        return message;
    }

    @GetMapping("/usuarios")
    public List<Usuario> getListaUsuarios() {
        return miRepository.findAll();
    }


    @GetMapping("/peliculas")
    public List<Pelicula> getListaPeliculas() {
        //Llamado a método de guardar para verificar que se guarda la película
        Director directorPrueba = directorService.saveDirector(new Director());
        Pelicula peliculaPrueba = new Pelicula();
        peliculaPrueba.setPeliculaAnio(2020);
        peliculaPrueba.setPeliculaTitulo("Pelicula de Prueba");
        peliculaPrueba.setPeliculaDuracion(120);
        peliculaPrueba.setPeliculaDirector(directorPrueba);
        peliculaService.savePelicula(peliculaPrueba);
        return peliculaService.findAllPelicula();
    }


}
