package controllers;
import DTO.CarreraDTO;
import entities.Carrera;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.CarreraService;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
@RequestMapping("/carrera")
public class CarreraController {

    private final CarreraService carreraService;

    //OBTENER TODAS LAS CARRERAS
    @GetMapping
    public List<Carrera> getCarreras() { return carreraService.getCarreras(); }

    //OBTENER UNA CARRERA POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Carrera> getCarreraById(@PathVariable Long id) {
        Optional<Carrera> resultado = carreraService.getCarreraById(id);
        return resultado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //CREAR NUEVA CARRERA
    @PostMapping
    public Carrera addCarrera(@RequestBody Carrera nuevaCarrera) { return carreraService.addCarrera(nuevaCarrera); }

    //BORRAR UNA CARRERA POR ID
    @DeleteMapping("/{id}")
    public void deleteCarrera(@PathVariable Long id) { carreraService.deleteCarrera(id); }

    //OBTENER SOLO CARRERAS CON ESTUDIANTES INSCRIPTOS
    public ResponseEntity<List<CarreraDTO>> obtenerCarrerasConInscriptos() {
        List<CarreraDTO> resultado = carreraService.obtenerCarrerasConInscriptos();
        return ResponseEntity.ok(resultado);
    }

}
