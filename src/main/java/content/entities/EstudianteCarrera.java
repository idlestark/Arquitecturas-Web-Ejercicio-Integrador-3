package content.entities;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class EstudianteCarrera {

    @EmbeddedId
    private EstudianteCarreraPK id;

    @ManyToOne
    @MapsId("dni")
    private Estudiante estudiante;

    @ManyToOne
    @MapsId("idCarrera")
    private Carrera carrera;

    @Column
    private Date fechaInscripto;

    @Column
    private Boolean egresado;

    public EstudianteCarrera (EstudianteCarreraPK id, Estudiante estudiante, Carrera carrera, Date fechaInscripto, Boolean egresado) {
        super();
        this.id = id;
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.fechaInscripto = fechaInscripto;
        this.egresado = egresado;
    }

    public EstudianteCarrera() {
        super();
    }

    public EstudianteCarreraPK getId() {
        return id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public Date getFechaInscripto() {
        return fechaInscripto;
    }

    public Boolean isEgresado() {
        return egresado;
    }
}