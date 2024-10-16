package content.controllers;
import content.DTO.EstudianteCarreraDTO;
import content.entities.EstudianteCarrera;
import content.entities.EstudianteCarreraPK;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import content.entities.*;
import content.services.*;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/estudianteCarrera")
public class EstudianteCarreraController {

    private final EstudianteCarreraService estudianteCarreraService;
    private final EstudianteService estudianteService;
    private final CarreraService carreraService;

    public static class EstudianteCarreraRequest {
        public Long estudianteDni;
        public Long carreraId;
        public Date fechaInscripcion;
        public Boolean estaGraduado;
    }

    @GetMapping
    public List<EstudianteCarreraDTO> getAllEstudianteCarrera() {
        return estudianteCarreraService.getAllEstudianteCarrera();
    }

    @GetMapping("/{estudianteDni}/{carreraId}")
    public EstudianteCarreraDTO getEstudianteCarreraById(@PathVariable Long estudianteDni, @PathVariable Long carreraId) {
        //EstudianteCarreraPK pk = new EstudianteCarreraPK(estudianteDni, carreraId);
        EstudianteCarreraDTO estudianteCarrera = estudianteCarreraService.getEstudianteCarreraById(estudianteDni, carreraId);
        return estudianteCarrera;
        //return estudianteCarrera.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //MATRICULAR UN ESTUDIANTE A UNA CARRERA (2.B)
    @PostMapping
    public ResponseEntity<EstudianteCarrera> matricularEstudiante(@RequestBody EstudianteCarreraRequest request) {
        //SE OBTIENE EL ESTUDIANTE POR SU DNI
        Optional<Estudiante> resultadoEstudiante = estudianteService.getEstudianteByDni(request.estudianteDni);
        if(!resultadoEstudiante.isPresent()) return ResponseEntity.badRequest().body(null);

        //SE OBTIENE LA CARRERA POR SU ID
        Optional<Carrera> resultadoCarrera = carreraService.getCarreraById(request.carreraId);
        if(!resultadoCarrera.isPresent()) return ResponseEntity.badRequest().body(null);

        Estudiante estudiante = resultadoEstudiante.get();
        Carrera carrera = resultadoCarrera.get();

        EstudianteCarreraPK estudianteCarreraPK = new EstudianteCarreraPK(request.estudianteDni, request.carreraId);

        EstudianteCarrera estudianteCarrera = new EstudianteCarrera(
                estudianteCarreraPK,
                estudiante,
                carrera,
                request.fechaInscripcion,
                request.estaGraduado);

        EstudianteCarrera ec = estudianteCarreraService.saveEstudianteCarrera(estudianteCarrera);
        return ResponseEntity.ok(ec);
    }

    //BORRAR UNA RELACIÓN ESTUDIANTE-CARRERA
    @DeleteMapping("/{estudianteId}/{carreraId}")
    public void deleteEstudianteCarrera(@PathVariable long estudianteId, @PathVariable Long carreraId){
        EstudianteCarreraPK pk = new EstudianteCarreraPK(estudianteId, carreraId);
        estudianteCarreraService.deleteEstudianteCarrera(pk);
    }

    //GENERAR REPORTE DE CARRERAS (2.H)
    @GetMapping("/reporte")
    public ResponseEntity<List<EstudianteCarreraDTO>> generarReporte() {
        List<EstudianteCarreraDTO> reporte = estudianteCarreraService.generarReporte();
        return ResponseEntity.ok(reporte);
    }

}
