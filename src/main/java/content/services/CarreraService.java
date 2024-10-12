package content.services;
import content.DTO.CarreraDTO;
import content.entities.Carrera;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import content.repositories.CarreraRepository;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CarreraService {

    private final CarreraRepository carreraRepository;

    //OBTENER TODAS LAS CARRERAS
    @Transactional(readOnly = true)
    public List<Carrera> getCarreras() { return carreraRepository.findAll(); }

    //OBTENER UNA CARERRA POR ID
    @Transactional(readOnly = true)
    public Optional<Carrera> getCarreraById(Long id) { return carreraRepository.findById(id); }

    //CREAR NUEVA CARRERA
    @Transactional
    public Carrera addCarrera(Carrera carrera) { return carreraRepository.save(carrera); }

    //BORRAR UNA CARRERA POR ID
    @Transactional
    public void deleteCarrera(Long id) { carreraRepository.deleteById(id); }

    //OBTENER SOLO CARRERAS CON ESTUDIANTES INSCRIPTOS
    @Transactional(readOnly = true)
    public List<CarreraDTO> obtenerCarrerasConInscriptos() { return carreraRepository.obtenerCarrerasConInscriptos(); }

}
