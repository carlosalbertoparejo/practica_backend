package es.ediae.master.programacion.gestionusuario.repository;

import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuestoDeTrabajoRepository extends JpaRepository<PuestoDeTrabajoEntity, Integer> {

    boolean existsByNombre(String nombre);
}
