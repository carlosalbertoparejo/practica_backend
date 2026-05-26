package es.ediae.master.programacion.gestionusuario.service;

import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<UsuarioEntity> listarTodos();

    Optional<UsuarioEntity> obtenerPorId(Integer id);

    UsuarioEntity guardar(UsuarioEntity u);

    boolean existsByNick(String nick);

    void eliminar(Integer id);

    boolean iniciarSesion(String nickUsuario, String contrasena);

    boolean validarCredenciales(String nickUsuario, String contrasena);

}
