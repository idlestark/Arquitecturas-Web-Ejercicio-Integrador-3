package content.entities;
import jakarta.persistence.*;


@Embeddable
public class EstudianteCarreraPK implements java.io.Serializable {

    private static final long serialVersionUID = -2173029278696333769L;

    private Long dni;

    private Long idCarrera;

    public EstudianteCarreraPK() {
        super();
    }

    public EstudianteCarreraPK(Long dni, Long idCarrera) {
        this.dni = dni;
        this.idCarrera = idCarrera;
    }


    public Long getDni() {
        return dni;
    }

    public Long getIdCarrera() {
        return idCarrera;
    }
}