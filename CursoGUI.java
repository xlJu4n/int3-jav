import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CursoGUI extends JFrame {
    private List<Curso> cursos;
    private List<Profesor> profesores;

    private JLabel labelNombreEstudiante, labelApellidoEstudiante, labelCedulaEstudiante;
    private JTextField entryNombreEstudiante, entryApellidoEstudiante, entryCedulaEstudiante;
    private JButton buttonInscribirEstudiante, buttonMostrarEstudiantes, buttonMostrarHorarios, buttonMostrarProfesores, buttonListarCursos;
    private JTextArea cursosTextArea;

    public CursoGUI() {
        super("Gestión de Cursos");
        cursos = new ArrayList<>();
        profesores = new ArrayList<>();

        inicializarDatos();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(204, 209, 209));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // interfaz xd
        labelNombreEstudiante = new JLabel("Nombre estudiante:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(labelNombreEstudiante, gbc);

        entryNombreEstudiante = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(entryNombreEstudiante, gbc);

        labelApellidoEstudiante = new JLabel("Apellido estudiante:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(labelApellidoEstudiante, gbc);

        entryApellidoEstudiante = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(entryApellidoEstudiante, gbc);

        labelCedulaEstudiante = new JLabel("Documento estudiante:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(labelCedulaEstudiante, gbc);

        entryCedulaEstudiante = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(entryCedulaEstudiante, gbc);

        buttonInscribirEstudiante = new JButton("Inscribir estudiante");
        buttonInscribirEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inscribirEstudiante();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(buttonInscribirEstudiante, gbc);
        gbc.gridwidth = 1;

        buttonMostrarEstudiantes = new JButton("Mostrar estudiantes inscritos");
        buttonMostrarEstudiantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarEstudiantesInscritos();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(buttonMostrarEstudiantes, gbc);
        gbc.gridwidth = 1;

        buttonMostrarHorarios = new JButton("Mostrar horarios de cursos");
        buttonMostrarHorarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarHorariosCursos();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panel.add(buttonMostrarHorarios, gbc);
        gbc.gridwidth = 1;

        buttonMostrarProfesores = new JButton("Mostrar profesores");
        buttonMostrarProfesores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarProfesores();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        panel.add(buttonMostrarProfesores, gbc);
        gbc.gridwidth = 1;

        cursosTextArea = new JTextArea(15, 30);
        cursosTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(cursosTextArea);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 7;
        panel.add(scrollPane, gbc);
        gbc.gridheight = 1;

        buttonListarCursos = new JButton("Listar cursos");
        buttonListarCursos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarCursos();
            }
        });
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        panel.add(buttonListarCursos, gbc);

        add(panel, BorderLayout.CENTER);
    }

    // datos :P
    private void inicializarDatos() {
        // Creación de horarios para los profesores
        List<Horario> horariosProfesor1 = Arrays.asList(new Horario("Lunes", "07:00", "09:00"), new Horario("Miércoles", "14:00", "16:00"));
        List<Horario> horariosProfesor2 = Arrays.asList(new Horario("Jueves", "06:00", "08:00"), new Horario("Viernes", "12:00", "14:00"));
        List<Horario> horariosProfesor3 = Arrays.asList(new Horario("Martes", "10:00", "12:00"), new Horario("Jueves", "10:00", "12:00"));

        Profesor profesor1 = new Profesor("Federico", "Velez", "1234567890", horariosProfesor1);
        Profesor profesor2 = new Profesor("Dayana", "Contreras", "0987654321", horariosProfesor2);
        Profesor profesor3 = new Profesor("Luisa", "Gimenez", "1357924680", horariosProfesor3);

        profesores.add(profesor1);
        profesores.add(profesor2);
        profesores.add(profesor3);

        List<Asignatura> asignaturasCurso1 = Arrays.asList(new Asignatura("Programación Básica", 4), new Asignatura("Interfaces Gráficas", 3));
        List<Asignatura> asignaturasCurso2 = Arrays.asList(new Asignatura("Inglés", 5), new Asignatura("Francés", 5));
        List<Asignatura> asignaturasCurso3 = Arrays.asList(new Asignatura("Electromagnetismo", 4), new Asignatura("Mecánica", 4));

        Horario horarioCurso1 = new Horario("Lunes", "07:00", "09:00");
        Horario horarioCurso2 = new Horario("Jueves", "06:00", "08:00");
        Horario horarioCurso3 = new Horario("Martes", "10:00", "12:00");

        Curso curso1 = new Curso("Programación", profesor1, asignaturasCurso1, horarioCurso1);
        Curso curso2 = new Curso("Idiomas", profesor2, asignaturasCurso2, horarioCurso2);
        Curso curso3 = new Curso("Física", profesor3, asignaturasCurso3, horarioCurso3);

        cursos.add(curso1);
        cursos.add(curso2);
        cursos.add(curso3);
    }

    private void inscribirEstudiante() {
        String nombre = entryNombreEstudiante.getText();
        String apellido = entryApellidoEstudiante.getText();
        String cedula = entryCedulaEstudiante.getText();

        Curso cursoSeleccionado = cursos.get(0);

        Estudiante estudiante = new Estudiante(nombre, apellido, cedula);
        cursoSeleccionado.getEstudiantes().add(estudiante);

        JOptionPane.showMessageDialog(this, nombre + " " + apellido + " se ha inscrito en el curso " + cursoSeleccionado.getNombre());

        entryNombreEstudiante.setText("");
        entryApellidoEstudiante.setText("");
        entryCedulaEstudiante.setText("");
    }

    private void mostrarEstudiantesInscritos() {
        Curso cursoSeleccionado = cursos.get(0);

        StringBuilder estudiantesText = new StringBuilder();
        for (Estudiante estudiante : cursoSeleccionado.getEstudiantes()) {
            estudiantesText.append(estudiante.getNombre()).append(" ").append(estudiante.getApellido()).append("\n");
        }

        cursosTextArea.setText("Estudiantes inscritos en el curso " + cursoSeleccionado.getNombre() + ":\n" + estudiantesText.toString());
    }

    private void mostrarHorariosCursos() {
        StringBuilder horariosText = new StringBuilder();
        for (Curso curso : cursos) {
            horariosText.append(curso.getNombre()).append(" - ").append(curso.getHorario().getDia()).append(" ")
                    .append(curso.getHorario().getHoraInicio()).append("-").append(curso.getHorario().getHoraFin()).append("\n");
        }

        JOptionPane.showMessageDialog(this, "Horarios de cursos disponibles:\n" + horariosText.toString());
    }

    private void mostrarProfesores() {
        StringBuilder profesoresText = new StringBuilder();
        for (Profesor profesor : profesores) {
            profesoresText.append(profesor.getNombre()).append(" - Horarios: ");
            for (Horario horario : profesor.getHorarios()) {
                profesoresText.append(horario.getDia()).append(" ").append(horario.getHoraInicio()).append("-")
                        .append(horario.getHoraFin()).append(", ");
            }
            if (profesor.getHorarios().size() > 0) {
                profesoresText.setLength(profesoresText.length() - 2);
            }
            profesoresText.append("\n");
        }

        JOptionPane.showMessageDialog(this, "Profesores disponibles:\n" + profesoresText.toString());
    }

    private void listarCursos() {
        // Limpiar lista de cursos
        cursosTextArea.setText("");

        for (Curso curso : cursos) {
            cursosTextArea.append(curso.getNombre() + " - " + curso.getProfesor().getNombre() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CursoGUI cursoGUI = new CursoGUI();
                cursoGUI.setVisible(true);
            }
        });
    }
}
