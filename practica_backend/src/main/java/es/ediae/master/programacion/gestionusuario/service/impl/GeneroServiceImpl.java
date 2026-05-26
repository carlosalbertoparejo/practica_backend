package es.ediae.master.programacion.gestionusuario.service.impl;

import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;
import es.ediae.master.programacion.gestionusuario.repository.GeneroRepository;
import es.ediae.master.programacion.gestionusuario.service.GeneroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroServiceImpl implements GeneroService {

    private final GeneroRepository generoRepository;

    public GeneroServiceImpl(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    @Override
    public List<GeneroEntity> obtenerTodos() {
        return generoRepository.findAll();
    }

    @Override
    public Optional<GeneroEntity> obtenerPorId(Integer id) {
        return generoRepository.findById(id);
    }

    @Override
    public GeneroEntity guardar(GeneroEntity genero) {
        return generoRepository.save(genero);
    }

    @Override
    public void eliminar(Integer id) {
        generoRepository.deleteById(id);
    }
}
