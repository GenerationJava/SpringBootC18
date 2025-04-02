package com.miprimerspring.syntaxpelis.controller;

import com.miprimerspring.syntaxpelis.model.Pelicula;
import com.miprimerspring.syntaxpelis.service.DirectorServiceImpl;
import com.miprimerspring.syntaxpelis.service.GeneroServiceImpl;
import com.miprimerspring.syntaxpelis.service.PaisServiceImpl;
import com.miprimerspring.syntaxpelis.service.PeliculaServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


//@Controller anota un controlador MVC, es decir, para controlar vistas dentro de un modelo MVC
//Las vistas se crean con Thymeleaf y deben estar en /resources/templates
@Controller
public class PruebaController {

    //Inyectamos las dependencias mediante constructor
    private PeliculaServiceImpl peliculaService;
    private DirectorServiceImpl directorService;
    private GeneroServiceImpl generoService;
    private PaisServiceImpl paisService;

    public PruebaController(PeliculaServiceImpl peliculaService,
                            DirectorServiceImpl directorService,
                            GeneroServiceImpl generoService,
                            PaisServiceImpl paisService) {
        this.peliculaService = peliculaService;
        this.directorService = directorService;
        this.generoService = generoService;
        this.paisService = paisService;
    }

    //Controlador MVC para mostrar formulario
    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        model.addAttribute("generos", generoService.findAllGenero());
        return "formulario";
    }


}
