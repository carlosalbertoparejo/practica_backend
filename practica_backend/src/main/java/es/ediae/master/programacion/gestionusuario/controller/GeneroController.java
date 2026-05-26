package es.ediae.master.programacion.gestionusuario.controller;

import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;
import es.ediae.master.programacion.gestionusuario.service.GeneroService;
import es.ediae.master.programacion.gestionusuario.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/generos")
public class GeneroController {

    private final GeneroService generoService;
    private final UsuarioService usuarioService;

    public GeneroController(GeneroService generoService, UsuarioService usuarioService) {
        this.generoService = generoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<?> obtenerGeneros(
            @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {

        if (!usuarioService.validarCredenciales(nickUsuario, nickContrasena)) {
            return ResponseEntity.ok(null);
        }

        List<GeneroEntity> generos = generoService.obtenerTodos();
        return ResponseEntity.ok(generos);
    }
}
