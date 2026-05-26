package es.ediae.master.programacion.gestionusuario.service.impl;

import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;
import es.ediae.master.programacion.gestionusuario.repository.PuestoDeTrabajoRepository;
import es.ediae.master.programacion.gestionusuario.service.PuestoDeTrabajoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PuestoDeTrabajoServiceImpl implements PuestoDeTrabajoService {

    private final PuestoDeTrabajoRepository puestoDeTrabajoRepository;

    public PuestoDeTrabajoServiceImpl(PuestoDeTrabajoRepository puestoDeTrabajoRepository) {
        this.puestoDeTrabajoRepository = puestoDeTrabajoRepository;
    }

    @Override
    public List<PuestoDeTrabajoEntity> obtenerTodos() {
        return puestoDeTrabajoRepository.findAll();
    }

    @Override
    public Optional<PuestoDeTrabajoEntity> obtenerPorId(Integer id) {
        return puestoDeTrabajoRepository.findById(id);
    }

    @Override
    public PuestoDeTrabajoEntity guardar(PuestoDeTrabajoEntity puesto) {
        return puestoDeTrabajoRepository.save(puesto);
    }

    @Override
    public void eliminar(Integer id) {
        puestoDeTrabajoRepository.deleteById(id);
    }
}
