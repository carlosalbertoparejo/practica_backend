package es.ediae.master.programacion.gestionusuario.service;

import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;

import java.util.List;
import java.util.Optional;

public interface DireccionService {

    List<DireccionEntity> obtenerDireccionesDeUsuario(Integer usuarioId);

    Optional<DireccionEntity> obtenerPorId(Integer id);

    DireccionEntity guardar(DireccionEntity direccion);

    void eliminar(Integer id);
}
