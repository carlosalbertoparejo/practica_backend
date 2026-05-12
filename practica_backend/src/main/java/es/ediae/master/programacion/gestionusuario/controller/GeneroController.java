package es.ediae.master.programacion.gestionusuario.controller;

import org.springframework.web.bind.annotation.*;
import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;
import es.ediae.master.programacion.gestionusuario.repository.GeneroRepository;
import java.util.List;

@RestController
@RequestMapping("/api/generos")
public class GeneroController {

    private final GeneroRepository repo;

    public GeneroController(GeneroRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<GeneroEntity> listar() {
        return repo.findAll();
    }
}
