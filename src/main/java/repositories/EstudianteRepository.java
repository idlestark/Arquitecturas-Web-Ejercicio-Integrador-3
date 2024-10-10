package repositories;
import DTO.EstudianteDTO;
import entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    @Query("SELECT new DTO.EstudianteDTO(e.nombre, e.apellido, e.edad, e.genero, e.dni, e.ciudad, e.lu)" +
            " FROM Estudiante e ORDER BY e.apellido")
    public List<EstudianteDTO> getEstudiantesApellido();

}
