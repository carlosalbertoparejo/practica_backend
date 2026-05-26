package es.ediae.master.programacion.gestionusuario.service;

import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;

import java.util.List;
import java.util.Optional;

public interface GeneroService {

    List<GeneroEntity> obtenerTodos();

    Optional<GeneroEntity> obtenerPorId(Integer id);

    GeneroEntity guardar(GeneroEntity genero);

    void eliminar(Integer id);
}
