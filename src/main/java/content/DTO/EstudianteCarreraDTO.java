package content.DTO;

import java.util.Date;

public class EstudianteCarreraDTO {

    private Long dni;
    private String nombre;
    private String cNombre;
    private Date fecha;
    private Long inscriptos;
    private boolean egresado;

    public EstudianteCarreraDTO() {
        super();
    }

    public EstudianteCarreraDTO(Long dni, String nombre, String cNombre, Date fecha, boolean egresado) {
        this.dni = dni;
        this.nombre = nombre;
        this.cNombre = cNombre;
        this.fecha = fecha;
        this.egresado = egresado;
    }


    public EstudianteCarreraDTO(String cNombre, Long inscriptos) {
        this.cNombre = cNombre;
        this.inscriptos = inscriptos;
    }

    public Long getInscriptos() {
        return inscriptos;
    }

    public Long getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getcNombre() {
        return cNombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public boolean isEgresado() {
        return egresado;
    }

    @Override
    public String toString() {
            return "EstudianteCarreraDto{" +
                    "nombre='" + nombre + ' ' +
                    ", nombre carrera=" + cNombre +
                    ", fecha=" + fecha +
                    ", egresado=" + egresado +
                    ", cant Inscriptos=" + inscriptos +
                    '}' + "\n";
    }
}