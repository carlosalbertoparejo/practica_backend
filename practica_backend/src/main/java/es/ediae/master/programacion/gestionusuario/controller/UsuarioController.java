package es.ediae.master.programacion.gestionusuario.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import es.ediae.master.programacion.gestionusuario.service.UsuarioService;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsuarioEntity> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> obtener(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody UsuarioEntity u) {
        if (service.existsByNick(u.getNickUsuario())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("nick_usuario ya existe");
        }
        u.setFechaHoraCreacion(LocalDateTime.now());
        UsuarioEntity creado = service.guardar(u);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody UsuarioEntity u) {
        return service.obtenerPorId(id).map(existing -> {
            existing.setNombre(u.getNombre());
            existing.setPrimerApellido(u.getPrimerApellido());
            existing.setSegundoApellido(u.getSegundoApellido());
            existing.setFechaNacimiento(u.getFechaNacimiento());
            existing.setHoraDesayuno(u.getHoraDesayuno());
            existing.setGenero(u.getGenero());
            existing.setPuestoDeTrabajo(u.getPuestoDeTrabajo());
            existing.setEsAdmin(u.isEsAdmin());
            UsuarioEntity saved = service.guardar(existing);
            return ResponseEntity.ok(saved);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (service.obtenerPorId(id).isPresent()) {
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
