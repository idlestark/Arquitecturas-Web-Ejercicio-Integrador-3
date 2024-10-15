package content.services;

import content.DTO.EstudianteCarreraDTO;
import content.entities.EstudianteCarrera;
import content.entities.EstudianteCarreraPK;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import content.repositories.EstudianteCarreraRepository;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EstudianteCarreraService {

    private final EstudianteCarreraRepository estudianteCarreraRepository;

    @Transactional(readOnly = true)
    public List<EstudianteCarreraDTO> getAllEstudianteCarrera() {
        return estudianteCarreraRepository.getAllEstudianteCarrera();
    }

    @Transactional(readOnly = true)
    public EstudianteCarreraDTO getEstudianteCarreraById(long dni, long carreraid) {
        return estudianteCarreraRepository.getEstudianteCarreraById(dni, carreraid);
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
    public List<EstudianteCarreraDTO> generarReporte(){
        return estudianteCarreraRepository.generarReporte();
    }

}
