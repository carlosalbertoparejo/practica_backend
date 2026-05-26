package es.ediae.master.programacion.gestionusuario.service.impl;

import org.springframework.stereotype.Service;
import es.ediae.master.programacion.gestionusuario.repository.UsuarioRepository;
import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import es.ediae.master.programacion.gestionusuario.service.UsuarioService;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioServiceImpl(UsuarioRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<UsuarioEntity> listarTodos() {
        return repo.findAll();
    }

    @Override
    public Optional<UsuarioEntity> obtenerPorId(Integer id) {
        return repo.findById(id);
    }

    @Override
    public UsuarioEntity guardar(UsuarioEntity u) {
        return repo.save(u);
    }

    @Override
    public boolean existsByNick(String nick) {
        return repo.existsByNickUsuario(nick);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public boolean iniciarSesion(String nickUsuario, String contrasena) {
        return repo.findByNickUsuarioAndContrasena(nickUsuario, contrasena).isPresent();
    }

    @Override
    public boolean validarCredenciales(String nickUsuario, String contrasena) {
    return repo.findByNickUsuarioAndContrasena(nickUsuario, contrasena).isPresent();
}


}
