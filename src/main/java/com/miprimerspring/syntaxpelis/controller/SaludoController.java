package com.miprimerspring.syntaxpelis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//Tenemos que anotar la clase como componente Controller
@Controller//Esto indica a Spring que este componente es controlador MVC y va a manejar vistas
@RequestMapping("/saludo")//Ruta base para acceder a los endpoints de este controlador
public class SaludoController {

    //Spring MVC nos permite trabajar con GET Y POST
    /**
     * @RequestMapping es una anotaciión para indicar la ruta y el tipo de petición, en general
     * @GetMapping una especificación para indicar la ruta a la que se hara una petición de tipo GET
     * @PostMapping una especificación para indicar la ruta a la que se hara una petición de tipo POST
     *
     * **/

    //@RequestParam se usa para recibir un parámetro a través de la ruta
    //Model es un objeto de Spring MVC que va a representar la vista
    @RequestMapping(value = "/hola")
    public String saludar(@RequestParam(name = "nombre") String nombre,// localhost:8081/saludo/hola?nombre=Woodleine?apellido=Formetus
                            @RequestParam(name = "apellido") String apellido,
                          Model model) {

        String nombreCompleto = nombre + " " + apellido;
        model.addAttribute("nombrePersona", nombreCompleto);
        System.out.println(nombreCompleto);
        return "home";
    }



    @GetMapping("/despedida")
    public String despedirse() {
        return "despedida";
    }





}
