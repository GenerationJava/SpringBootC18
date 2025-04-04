package com.miprimerspring.syntaxpelis.controller;

import com.miprimerspring.syntaxpelis.model.Genero;
import com.miprimerspring.syntaxpelis.model.Pelicula;
import com.miprimerspring.syntaxpelis.service.DirectorServiceImpl;
import com.miprimerspring.syntaxpelis.service.GeneroServiceImpl;
import com.miprimerspring.syntaxpelis.service.PeliculaServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("peliculas")
public class PeliculaController {

    private PeliculaServiceImpl peliculaService;
    private GeneroServiceImpl generoService;
    private DirectorServiceImpl directorService;

    public PeliculaController(PeliculaServiceImpl peliculaService,
                              GeneroServiceImpl generoService,
                              DirectorServiceImpl directorService) {

        this.peliculaService = peliculaService;
        this.generoService = generoService;
        this.directorService = directorService;
    }

    @GetMapping("/lista")
    public String mostrarListaPeliculas(Model model) {
        List<Pelicula> listaPeliculas = peliculaService.findAllPelicula();

        model.addAttribute("lista", listaPeliculas);

        return "lista-peliculas";
    }

    //Método para mostrar la vista
    @GetMapping("/formulario")
    //Model es un objeto de Spring MVC que representa la plantilla HTML
    public String mostrarFormulario(Model model) {
        //Con el model.addAttribute le puedo pasar un objeto o variable a la vista
        model.addAttribute("pelicula", new Pelicula());
        //Para que se muestren los generos, primero llamamos al service
        model.addAttribute("generos", generoService.findAllGenero());
        model.addAttribute("directores", directorService.findAllDirector());
        return "formulario";
    }

    //Guardar va a ser una acción de tipo POST
    @PostMapping("/formulario/guardar")
    public String guardarNuevaPelicula(@ModelAttribute Pelicula nuevaPelicula,
                                       @RequestParam(required = false) List<Long> generosIds) {
        //En esta lista vamos a guardar los generos que se seleccionen
        List<Genero> generosPelicula = new ArrayList<>();
        //Iteramos sobre cada generoId que se pasa por la ruta y con cada uno buscamos en la tabla de Generos de peliculas y lo agregamos a la variable generosPelicula
        for(int i = 0; i < generosIds.size(); i++) {
            generosPelicula.add(generoService.findById(generosIds.get(i)));
        }
        //Le seteamos la lista de generos con la variable generosPelicula
        nuevaPelicula.setPeliculasGeneros(generosPelicula);
        peliculaService.savePelicula(nuevaPelicula);
        return "redirect:/peliculas/lista";
    }

    //@RequestParam se va a ver así eliminar?id=1
    //@PathVariable se va a ver así eliminar/1
    @GetMapping("eliminar/{id}")
    public String eliminarPelicula(@PathVariable Long id) {
        peliculaService.deleteById(id);
        return "redirect:/peliculas/lista";
    }


    @GetMapping("/ver/{id}")
    public String mostrarDetallePelicula(@PathVariable Long id,
                                         Model model) {
        Pelicula peliculaSeleccionada = peliculaService.findById(id);
        model.addAttribute("pelicula", peliculaSeleccionada);
        return "detalle-pelicula";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicionPelicula(@PathVariable Long id,
                                                   Model model) {
        //Guardamos la pelicula selecciona con el id en una variable nueva
        Pelicula peliculaSeleccionada = peliculaService.findById(id);

        //Convertimos los objetos genero en una lista de ids de esos generos
        List<Long> generosSeleccionados = peliculaSeleccionada.getPeliculasGeneros().stream()
                .map(Genero::getGeneroId)
                .collect(Collectors.toList());

        //Le pasamos a la vista, todos los generos, directores, generos de la pelicula y la pelicula
        model.addAttribute("pelicula", peliculaSeleccionada);
        model.addAttribute("generos", generoService.findAllGenero());
        model.addAttribute("directores", directorService.findAllDirector());
        model.addAttribute("generosSeleccionados", generosSeleccionados);


        return "formulario-edicion";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarPelicula(@PathVariable Long id,
                                     @ModelAttribute Pelicula peliculaActualizar,
                                     @RequestParam(required = false) List<Long> generosIds) {

        List<Genero> generosPelicula = new ArrayList<>();
        //Verificamos que la variable generosIds no sea null ni venga como una lista vacía
        if(generosIds != null && !generosIds.isEmpty()) {
            for(int i = 0; i < generosIds.size(); i++) {
                generosPelicula.add(generoService.findById(generosIds.get(i)));
            }
        }
        //Seteamos al objeto Pelicula que llega de la vista, los generos modificados y el id para que se sobreescriba
        peliculaActualizar.setPeliculasGeneros(generosPelicula);
        peliculaActualizar.setPeliculaId(id);
        peliculaService.savePelicula(peliculaActualizar);
        return "redirect:/peliculas/lista";

    }




}
