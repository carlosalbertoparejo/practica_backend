package es.ediae.master.programacion.gestionusuario.controller;

import org.springframework.web.bind.annotation.*;
import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;
import es.ediae.master.programacion.gestionusuario.repository.PuestoRepository;
import java.util.List;

@RestController
@RequestMapping("/api/puestos-de-trabajo")
public class PuestoDeTrabajoController {

    private final PuestoRepository repo;

    public PuestoDeTrabajoController(PuestoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<PuestoDeTrabajoEntity> listar() {
        return repo.findAll();
    }
}
