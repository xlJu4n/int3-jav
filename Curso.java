import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombre;
    private Profesor profesor;
    private List<Asignatura> asignaturas;
    private Horario horario;
    private List<Estudiante> estudiantes;

    public Curso(String nombre, Profesor profesor, List<Asignatura> asignaturas, Horario horario) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.asignaturas = asignaturas;
        this.horario = horario;
        this.estudiantes = new ArrayList<>();
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public Horario getHorario() {
        return horario;
    }

    public void inscribirEstudiante(Estudiante estudiante) {
        this.estudiantes.add(estudiante);
    }
}

