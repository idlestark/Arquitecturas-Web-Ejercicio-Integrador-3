package services;
import DTO.EstudianteDTO;
import entities.Carrera;
import entities.Estudiante;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repositories.EstudianteRepository;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    //OBTENER TODOS LOS ESTUDIANTES
    @Transactional(readOnly = true)
    public List<Estudiante> getEstudiantes() { return estudianteRepository.findAll(); }

    //OBTENER UN ESTUDIANTE POR ID
    public Optional<Estudiante> getEstudianteByDni(Long dni) { return estudianteRepository.findById(dni); }

    //CREAR NUEVO ESTUDIANTE
    @Transactional
    public Estudiante addEstudiante(Estudiante estudiante) { return estudianteRepository.save(estudiante); }

    //BORRAR UN ESTUDIANTE POR ID
    @Transactional
    public void deleteEstudiante(Long id) { estudianteRepository.deleteById(id); }

    //OBTENER TODOS LOS ESTUDIANTES ORDENADOS POR SU APELLIDO
    @Transactional(readOnly = true)
    public List<EstudianteDTO> getEstudiantesApellido() { return estudianteRepository.getEstudiantesApellido(); }

}
