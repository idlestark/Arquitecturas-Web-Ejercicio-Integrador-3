package content.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Carrera {

    @Id
    private long idCarrera;

    @Column
    private String nombre;

    @OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EstudianteCarrera> estudiantes;

    public Carrera() {super();}

    public Carrera (long idCarrera, String nombre) {
        super();
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.estudiantes = new ArrayList<EstudianteCarrera>();
    }

    public long getIdCarrera() {return this.idCarrera;}

    public String getNombre() {return this.nombre;}

    public List<EstudianteCarrera> getEstudiantes() {return this.estudiantes;}

}
