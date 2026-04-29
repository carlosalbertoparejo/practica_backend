package es.ediae.master.programacion.gestionusuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;

public interface PuestoRepository extends JpaRepository<PuestoDeTrabajoEntity, Integer> {}
