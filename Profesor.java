import java.util.List;

public class Profesor {
    private String nombre;
    private String apellido;
    private String cedula;
    private List<Horario> horarios;

    public Profesor(String nombre, String apellido, String cedula, List<Horario> horarios) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.horarios = horarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
}
