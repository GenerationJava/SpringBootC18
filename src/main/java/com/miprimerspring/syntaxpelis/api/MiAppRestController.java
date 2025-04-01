package com.miprimerspring.syntaxpelis.api;

import com.miprimerspring.syntaxpelis.PeliculaService.DirectorService;
import com.miprimerspring.syntaxpelis.PeliculaService.DirectorServiceImpl;
import com.miprimerspring.syntaxpelis.PeliculaService.PeliculaServiceImpl;
import com.miprimerspring.syntaxpelis.model.Director;
import com.miprimerspring.syntaxpelis.model.Pais;
import com.miprimerspring.syntaxpelis.model.Pelicula;
import com.miprimerspring.syntaxpelis.model.Usuario;
import com.miprimerspring.syntaxpelis.repository.MiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MiAppRestController {

    @Autowired
    private MiRepository miRepository;

    @Autowired
    private PeliculaServiceImpl peliculaService;

    @Autowired
    private DirectorServiceImpl directorService;

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
