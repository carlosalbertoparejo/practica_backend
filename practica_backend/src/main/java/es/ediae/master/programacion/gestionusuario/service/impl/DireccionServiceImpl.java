package es.ediae.master.programacion.gestionusuario.service.impl;

import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;
import es.ediae.master.programacion.gestionusuario.repository.DireccionRepository;
import es.ediae.master.programacion.gestionusuario.service.DireccionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionServiceImpl implements DireccionService {

    private final DireccionRepository direccionRepository;

    public DireccionServiceImpl(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }

    @Override
    public List<DireccionEntity> obtenerDireccionesDeUsuario(Integer usuarioId) {
        return direccionRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public Optional<DireccionEntity> obtenerPorId(Integer id) {
        return direccionRepository.findById(id);
    }

    @Override
    public DireccionEntity guardar(DireccionEntity direccion) {
        return direccionRepository.save(direccion);
    }

    @Override
    public void eliminar(Integer id) {
        direccionRepository.deleteById(id);
    }
}
