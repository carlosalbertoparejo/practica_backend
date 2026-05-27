package es.ediae.master.programacion.gestionusuario.controller;

import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;
import es.ediae.master.programacion.gestionusuario.service.PuestoDeTrabajoService;
import es.ediae.master.programacion.gestionusuario.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/puestos-de-trabajo")
public class PuestoDeTrabajoController {

    private final PuestoDeTrabajoService puestoService;
    private final UsuarioService usuarioService;

    public PuestoDeTrabajoController(PuestoDeTrabajoService puestoService, UsuarioService usuarioService) {
        this.puestoService = puestoService;
        this.usuarioService = usuarioService;
    }


    @GetMapping
    public ResponseEntity<?> obtenerPuestos(
            @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {

        if (!usuarioService.validarCredenciales(nickUsuario, nickContrasena)) {
            return ResponseEntity.ok(null);
        }

        List<PuestoDeTrabajoEntity> puestos = puestoService.obtenerTodos();
        return ResponseEntity.ok(puestos);
    }
}
