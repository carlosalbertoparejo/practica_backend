package es.ediae.master.programacion.gestionusuario.controller;

import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;
import es.ediae.master.programacion.gestionusuario.service.DireccionService;
import es.ediae.master.programacion.gestionusuario.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/direcciones")
public class DireccionController {

    private final DireccionService direccionService;
    private final UsuarioService usuarioService;

    public DireccionController(DireccionService direccionService, UsuarioService usuarioService) {
        this.direccionService = direccionService;
        this.usuarioService = usuarioService;
    }


    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<?> obtenerDirecciones(
            @PathVariable Integer usuarioId,
            @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {

        if (!usuarioService.validarCredenciales(nickUsuario, nickContrasena)) {
            return ResponseEntity.ok(null);
        }

        List<DireccionEntity> direcciones = direccionService.obtenerDireccionesDeUsuario(usuarioId);
        return ResponseEntity.ok(direcciones);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerDireccion(
            @PathVariable Integer id,
            @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {

        if (!usuarioService.validarCredenciales(nickUsuario, nickContrasena)) {
            return ResponseEntity.ok(null);
        }

        return direccionService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<?> crearDireccion(
            @RequestBody DireccionEntity direccion,
            @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {

        if (!usuarioService.validarCredenciales(nickUsuario, nickContrasena)) {
            return ResponseEntity.ok(null);
        }

        DireccionEntity creada = direccionService.guardar(direccion);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarDireccion(
            @PathVariable Integer id,
            @RequestBody DireccionEntity direccion,
            @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {

        if (!usuarioService.validarCredenciales(nickUsuario, nickContrasena)) {
            return ResponseEntity.ok(null);
        }

        return direccionService.obtenerPorId(id).map(existing -> {

            existing.setNombreCalle(direccion.getNombreCalle());
            existing.setNumeroCalle(direccion.getNumeroCalle());
            existing.setUsuario(direccion.getUsuario());

            DireccionEntity actualizada = direccionService.guardar(existing);
            return ResponseEntity.ok(actualizada);

        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDireccion(
            @PathVariable Integer id,
            @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {

        if (!usuarioService.validarCredenciales(nickUsuario, nickContrasena)) {
            return ResponseEntity.ok(null);
        }

        if (direccionService.obtenerPorId(id).isPresent()) {
            direccionService.eliminar(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
