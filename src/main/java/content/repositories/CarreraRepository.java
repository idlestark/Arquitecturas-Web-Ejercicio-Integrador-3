package content.repositories;
import content.DTO.CarreraDTO;
import content.entities.Carrera;
import content.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarreraRepository extends JpaRepository<Carrera, Long> {

    //OBTENER SOLO CARRERAS CON ESTUDIANTES INSCRIPTOS
    @Query("SELECT new content.DTO.CarreraDTO(c.nombre, COUNT(e.dni)) " +
            "FROM Carrera c " +
            "JOIN c.estudiantes ec " +
            "JOIN ec.estudiante e " +
            "WHERE e.dni IS NOT NULL " +
            "GROUP BY c.nombre " +
            "ORDER BY COUNT(e.dni) DESC")
    List<CarreraDTO> obtenerCarrerasConInscriptos();

    @Query("SELECT new content.DTO.CarreraDTO(c.nombre, c.idCarrera) " +
            "FROM Carrera c")
    List<CarreraDTO> obtenerCarreras();

}
