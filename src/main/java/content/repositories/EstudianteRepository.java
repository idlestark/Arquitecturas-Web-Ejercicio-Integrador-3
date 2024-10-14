package content.repositories;
import content.DTO.EstudianteDTO;
import content.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    @Query("SELECT new content.DTO.EstudianteDTO(e.nombre, e.apellido, e.edad, e.genero, e.dni, e.ciudad, e.lu)" +
            " FROM Estudiante e ORDER BY e.apellido")
    public List<EstudianteDTO> getEstudiantes();

    @Query("SELECT new content.DTO.EstudianteDTO(e.nombre, e.apellido, e.edad, e.genero, e.dni, e.ciudad, e.lu) "+
            "FROM Estudiante e WHERE e.genero = :genero")
    Iterable<Estudiante> getEstudiantesPorGenero(String genero);

    @Query("SELECT new content.DTO.EstudianteDTO(e.nombre, e.apellido, e.edad, e.genero, e.dni, e.ciudad, e.lu) " +
            "FROM Estudiante e WHERE e.lu = :lu")
    EstudianteDTO findByLU(long lu);

    @Query("SELECT new content.DTO.EstudianteDTO(e.nombre, e.apellido, e.edad, e.genero, e.dni, e.ciudad, e.lu) " +
            "FROM Estudiante e JOIN EstudianteCarrera ec ON ec.estudiante.dni = e.dni " +
            "WHERE e.ciudad = :ciudad AND ec.carrera.idCarrera = :idCarrera")
    Iterable<Estudiante> getEstudiantesInscriptosEnCarrera(int idCarrera, String ciudad);
}
