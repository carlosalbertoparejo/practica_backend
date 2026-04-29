package es.ediae.master.programacion.gestionusuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    Optional<UsuarioEntity> findByNickUsuario(String nickUsuario);
    boolean existsByNickUsuario(String nickUsuario);
}
