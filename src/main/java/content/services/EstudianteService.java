package content.services;
import content.DTO.EstudianteDTO;
import content.entities.Carrera;
import entities.Estudiante;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import content.repositories.EstudianteRepository;
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

    //OBTENER TODOS LOS ESTUDIANTES ORDENADOS POR SU APELLIDO (2.C)
    @Transactional(readOnly = true)
    public List<EstudianteDTO> getEstudiantes() { return estudianteRepository.getEstudiantes(); }

    //OBTENER TODOS LOS ESTUDIANTES POR GÉNERO (2.E)
    @Transactional(readOnly = true)
    public Iterable<Estudiante> getEstudiantesPorGenero(String genero) { return estudianteRepository.getEstudiantesPorGenero(genero); }

    //OBTENER TODOS LOS ESTUDIANTES INSCRIPTOS A UNA CARRERA (FILTRADO POR CIUDAD) (2.G)
    @Transactional(readOnly = true)
    public Iterable<Estudiante> getEstudiantesInscriptosEnCarrera(int idCarrera, String ciudad) { return estudianteRepository.getEstudiantesInscriptosEnCarrera(idCarrera, ciudad); }


    //OBTENER UN ESTUDIANTE POR ID
    @Transactional(readOnly = true)
    public Optional<Estudiante> getEstudianteByDni(Long dni) { return estudianteRepository.findById(dni); }

    //OBTENER ESTUDIANTE POR LU (2.D)
    @Transactional(readOnly = true)
    public EstudianteDTO getEstudianteByLU(Long lu) { return estudianteRepository.findByLU(lu);}

    //CREAR NUEVO ESTUDIANTE (2.A)
    @Transactional
    public Estudiante addEstudiante(Estudiante estudiante) { return estudianteRepository.save(estudiante); }

    //BORRAR UN ESTUDIANTE POR ID
    @Transactional
    public void deleteEstudiante(Long id) { estudianteRepository.deleteById(id);}


}
