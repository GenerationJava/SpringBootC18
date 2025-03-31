package com.miprimerspring.syntaxpelis.api;

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

}
