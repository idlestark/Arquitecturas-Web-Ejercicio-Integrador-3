package content.repositories;
import content.DTO.EstudianteDTO;
import content.entities.EstudianteCarrera;
import content.entities.EstudianteCarreraPK;
import content.DTO.EstudianteCarreraDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EstudianteCarreraRepository extends JpaRepository<EstudianteCarrera, EstudianteCarreraPK> {

    @Query("SELECT new content.DTO.EstudianteCarreraDTO(c.nombre, COUNT(ec.estudiante.dni)) " +
            "FROM EstudianteCarrera ec " +
            "JOIN ec.carrera c " +
            "GROUP BY c.nombre " +
            "ORDER BY c.nombre ASC")
    List<EstudianteCarreraDTO> generarReporte();


    @Query("SELECT new content.DTO.EstudianteCarreraDTO(ec.estudiante.dni, ec.estudiante.nombre, ec.carrera.nombre, ec.fechaInscripto, ec.egresado) " +
            "FROM EstudianteCarrera ec")
    List<EstudianteCarreraDTO> getAllEstudianteCarrera();

    @Query("SELECT new content.DTO.EstudianteCarreraDTO(e.dni, e.nombre, c.nombre, ec.fechaInscripto, ec.egresado) " +
            "FROM EstudianteCarrera ec " +
            "JOIN ec.carrera c " +
            "JOIN ec.estudiante e " +
            "WHERE e.dni = :Edni AND c.idCarrera = :Cid")
    EstudianteCarreraDTO getEstudianteCarreraById(Long Edni, Long Cid);
}