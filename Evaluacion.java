public class Evaluacion {
    private Estudiante estudiante;
    private Asignatura asignatura;
    private double nota;

    public Evaluacion(Estudiante estudiante, Asignatura asignatura, double nota) {
        this.estudiante = estudiante;
        this.asignatura = asignatura;
        this.nota = nota;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
