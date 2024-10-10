package repositories;


import entities.Estudiante;
import entities.EstudianteCarrera;
import entities.EstudianteCarreraPK;
import DTO.EstudianteCarreraDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EstudianteCarreraRepository extends JpaRepository<EstudianteCarrera, EstudianteCarreraPK>{

    @Query("SELECT new DTO.EstudianteCarreraDTO(c.nombre, YEAR(ec.fechaInscripcion)), " +
            "COUNT(ec.estudiante.dni), " +
            "SUM(CASE WHEN ec.estaGraduado = TRUE THEN  1 ELSE 0 END) " +
            "FROM EstudianteCarrera ec " +
            "JOIN ec.carrera c " +
            "JOIN ec.estudiante e " +
            "GROUP BY c.nombre, YEAR(ec.fechaInscripto) " +
            "ORDER BY YEAR(ec.fechaInscripto) ASC")
    List<EstudianteCarreraDTO> generarReporteCarrera();

}