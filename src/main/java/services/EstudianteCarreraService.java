package services;

import DTO.EstudianteCarreraDTO;
import entities.EstudianteCarrera;
import entities.EstudianteCarreraPK;
import org.springframework.transaction.annotation.Transactional;
import repositories.EstudianteCarreraRepository;

import java.util.List;
import java.util.Optional;

public class EstudianteCarreraService {

    private final EstudianteCarreraRepository estudianteCarreraRepository;

    public EstudianteCarreraService(EstudianteCarreraRepository estudianteCarreraRepository) {
        this.estudianteCarreraRepository = estudianteCarreraRepository;
    }

    @Transactional(readOnly = true)
    public List<EstudianteCarrera> getAllEstudianteCarrera() {
        return estudianteCarreraRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<EstudianteCarrera> getEstudianteCarreraById(EstudianteCarreraPK id) {
        return estudianteCarreraRepository.findById(id);
    }

    @Transactional
    public EstudianteCarrera saveEstudianteCarrera(EstudianteCarrera estudianteCarrera) {
        return estudianteCarreraRepository.save(estudianteCarrera);
    }

    @Transactional
    public void deleteEstudianteCarrera(EstudianteCarreraPK pk){
        estudianteCarreraRepository.deleteById(pk);
    }

    @Transactional(readOnly = true)
    public List<EstudianteCarreraDTO> generarReporteCarreras(){
        return estudianteCarreraRepository.generarReporteCarrera();
    }
}
