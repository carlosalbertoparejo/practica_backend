package es.ediae.master.programacion.gestionusuario.repository;

import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DireccionRepository extends JpaRepository<DireccionEntity, Integer> {

    List<DireccionEntity> findByUsuarioId(Integer usuarioId);
}
