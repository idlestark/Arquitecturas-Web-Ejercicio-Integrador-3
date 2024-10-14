package content.DTO;
import lombok.Getter;

import java.util.Date;
public class EstudianteCarreraDTO {

    private Long dni;
    private String nombre;
    private String cNombre;
    @Getter
    private Date fecha;
    private boolean egresados;

    public EstudianteCarreraDTO() {super();}

    public EstudianteCarreraDTO(Long dni, String nombre, String cNombre, Date fecha, boolean egresado) {
        this.dni = dni;
        this.nombre = nombre;
        this.cNombre = cNombre;
        this.fecha = fecha;
        this.egresados = egresado;
    }

    public String getNombre(){ return nombre; }

    public boolean getEgresados() {
            return egresados;
    }

    @Override
    public String toString() {
            return "EstudianteCarreraDto{" +
                    "nombre='" + nombre + '\'' +
                    ", nombre carrera=" + cNombre +
                    ", fecha=" + fecha +
                    ", egresados=" + egresados +
                    '}' + "\n";
    }

}
