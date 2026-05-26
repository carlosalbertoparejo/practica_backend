package es.ediae.master.programacion.gestionusuario.controller;

import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import es.ediae.master.programacion.gestionusuario.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/iniciar-sesion")
    public ResponseEntity<Boolean> iniciarSesion(
            @RequestParam String nickUsuario,
            @RequestParam String contrasena) {

        boolean valido = service.iniciarSesion(nickUsuario, contrasena);
        return ResponseEntity.ok(valido);
    }

    @GetMapping
    public ResponseEntity<?> listar(
            @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {

        if (!service.validarCredenciales(nickUsuario, nickContrasena)) {
            return ResponseEntity.ok(null);
        }

        List<UsuarioEntity> usuarios = service.listarTodos();
        return ResponseEntity.ok(usuarios);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(
            @PathVariable Integer id,
            @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {

        if (!service.validarCredenciales(nickUsuario, nickContrasena)) {
            return ResponseEntity.ok(null);
        }

        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<?> crear(
            @RequestBody UsuarioEntity u,
            @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {

        if (!service.validarCredenciales(nickUsuario, nickContrasena)) {
            return ResponseEntity.ok(null);
        }

        if (service.existsByNick(u.getNickUsuario())) {
            return ResponseEntity.badRequest().body("El nick ya existe");
        }

        UsuarioEntity creado = service.guardar(u);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable Integer id,
            @RequestBody UsuarioEntity u,
            @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {

        if (!service.validarCredenciales(nickUsuario, nickContrasena)) {
            return ResponseEntity.ok(null);
        }

        return service.obtenerPorId(id).map(existing -> {

            existing.setNombre(u.getNombre());
            existing.setPrimerApellido(u.getPrimerApellido());
            existing.setSegundoApellido(u.getSegundoApellido());
            existing.setFechaNacimiento(u.getFechaNacimiento());
            existing.setHoraDesayuno(u.getHoraDesayuno());
            existing.setGenero(u.getGenero());
            existing.setPuestoDeTrabajo(u.getPuestoDeTrabajo());
            existing.setEsAdmin(u.isEsAdmin());

            UsuarioEntity actualizado = service.guardar(existing);
            return ResponseEntity.ok(actualizado);

        }).orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(
            @PathVariable Integer id,
            @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {

        if (!service.validarCredenciales(nickUsuario, nickContrasena)) {
            return ResponseEntity.ok(null);
        }

        if (service.obtenerPorId(id).isPresent()) {
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
