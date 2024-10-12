package content.controllers;
import content.DTO.EstudianteDTO;
import entities.Estudiante;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import content.services.EstudianteService;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    private final EstudianteService estudianteService;

    //OBTENER TODOS LOS ESTUDIANTES ORDENADOS POR SU APELLIDO (2.C)
    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> getEstudiantes() {
        List<EstudianteDTO> resultado = estudianteService.getEstudiantes();
        return ResponseEntity.ok().body(resultado);
    }

    //OBTENER TODOS LOS ESTUDIANTES POR GÉNERO (2.E)
    @GetMapping("/genero/{genero}")
    public Iterable<Estudiante> getEstudiantesPorGenero(@PathVariable String genero) { return estudianteService.getEstudiantesPorGenero(genero.toUpperCase()); }


    //OBTENER TODOS LOS ESTUDIANTES INSCRIPTOS A UNA CARRERA (FILTRADO POR CIUDAD) (2.G)
    @GetMapping("/{idCarrera}/{ciudad}")
    public Iterable<Estudiante> getEstudiantesInscriptosEnCarrera(@PathVariable int idCarrera, @PathVariable String ciudad) { return estudianteService.getEstudiantesInscriptosEnCarrera(idCarrera, ciudad); }


    //OBTENER UN ESTUDIANTE POR ID
    @GetMapping("/{dni}")
    public ResponseEntity<Estudiante> getEstudianteByDni(@PathVariable Long dni) {
        Optional<Estudiante> resultado = estudianteService.getEstudianteByDni(dni);
        return resultado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //OBTENER ESTUDIANTE POR LU (2.D)
    @GetMapping("/lu/{lu}")
    public ResponseEntity<EstudianteDTO> getEstudianteByLU(@PathVariable Long lu) {
        EstudianteDTO resultado = estudianteService.getEstudianteByLU(lu);
        return ResponseEntity.ok(resultado);
    }

    //CREAR NUEVO ESTUDIANTE (2.A)
    @PostMapping
    public Estudiante addEstudiante(@RequestBody Estudiante nuevoEstudiante) { return estudianteService.addEstudiante(nuevoEstudiante); }

    //BORRAR UN ESTUDIANTE POR ID
    @DeleteMapping("/{id}")
    public void deleteEstudiante(@PathVariable Long id) { estudianteService.deleteEstudiante(id); }



    /*
    @ApiOperation(value = "Get listo of Estudiantes by name ", response = Iterable.class)
    @ApiResponse(value = {
            @ApiResponse(code = 200, message = "Seccess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })

    @GetMapping("/Byname/{name}")
    public Iterable<Estudiante> getEstudainteByName(@PathVariable String name){
        return repository.FindAllByName(name);
    }

    @PostMapping("/")
    public Estudiante newEstudiante(@RequestBody Estudiante estudiante){
        return repository.save(estudiante);
    }

    @ApiOperation(value = "get specific estudent in the system ", response = Estudiante.class, tags = "getEstudiante")
    @RequestMapping(value = "/getEstudainte/{name}")
    public Estudiante getEstudiante(@PathVariable(value = "name") String name){
        return repository.FindAllByName(name).get(0);
    }
    @GetMapping("/{id}")
    Optional<Estudiante> one(@PathVariable long id){
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    Estudiante replaceEstudiante(@RequestBody Estudiante newEstudiante, @PathVariable Long id){
        return repository.findById(id).map(estudiante -> {
            estudiante.setDni(newEstudiante.getDni());
            estudiante.setNombre(newEstudiante.getNombre());
            estudiante.setApellido(newEstudiante.getApellido());
            estudiante.setEdad(newEstudiante.getEdad());
            estudiante.setGenero(newEstudiante.getGenero());
            estudiante.setCiudad(newEstudiante.getCiudad());
            estudiante.setLu(newEstudiante.getNumeroLibreta());
            return repository.save(estudiante);
                })
                .orElseGet(() -> {
                    newEstudiante.setDni(id);
                    return repository.save(newEstudiante);
                });
    }

    @DeleteMapping("/{id}")
    void deleteEstudiante(@PathVariable long id){
        repository.deleteById(id);
    }
    */
}