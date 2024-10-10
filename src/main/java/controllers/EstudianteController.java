package controllers;
import DTO.EstudianteDTO;
import entities.Estudiante;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.EstudianteService;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    //OBTENER TODOS LOS ESTUDIANTES
    @GetMapping("/")
    public Iterable<Estudiante> getEstudaintes(){
        return estudianteService.getEstudiantes();
    }

    //OBTENER UN ESTUDIANTE POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getEstudianteByDni(@PathVariable Long dni) {
        Optional<Estudiante> resultado = estudianteService.getEstudianteByDni(dni);
        return resultado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //CREAR NUEVO ESTUDIANTE
    @PostMapping
    public Estudiante addEstudiante(@RequestBody Estudiante nuevoEstudiante) { return estudianteService.addEstudiante(nuevoEstudiante); }

    //BORRAR UN ESTUDIANTE POR ID
    @DeleteMapping("/{id}")
    public void deleteEstudiante(@PathVariable Long id) { estudianteService.deleteEstudiante(id); }

    //OBTENER TODOS LOS ESTUDIANTES ORDENADOS POR SU APELLIDO
    @GetMapping("/getEstudiantesApellido")
    public ResponseEntity<List<EstudianteDTO>> getEstudiantesApellido() {
        List<EstudianteDTO> resultado = estudianteService.getEstudiantesApellido();
        return ResponseEntity.ok().body(resultado);
    }


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