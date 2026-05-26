package es.ediae.master.programacion.gestionusuario.service;

import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;

import java.util.List;
import java.util.Optional;

public interface PuestoDeTrabajoService {

    List<PuestoDeTrabajoEntity> obtenerTodos();

    Optional<PuestoDeTrabajoEntity> obtenerPorId(Integer id);

    PuestoDeTrabajoEntity guardar(PuestoDeTrabajoEntity puesto);

    void eliminar(Integer id);
}
