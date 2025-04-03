package com.miprimerspring.syntaxpelis.controller;

import com.miprimerspring.syntaxpelis.model.Pelicula;
import com.miprimerspring.syntaxpelis.service.PeliculaServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("peliculas")
public class PeliculaController {

    private PeliculaServiceImpl peliculaService;

    public PeliculaController(PeliculaServiceImpl peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping("/lista")
    public String mostrarListaPeliculas(Model model) {
        List<Pelicula> listaPeliculas = peliculaService.findAllPelicula();

        model.addAttribute("lista", listaPeliculas);

        return "lista-peliculas";
    }


  

}
