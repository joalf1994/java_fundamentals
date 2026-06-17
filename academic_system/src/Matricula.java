import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Matricula
 * <p>
 * Contiene los datos de una matricula entre un estudiante y un curso
 * @author joalf
 * @version 1.0
 * @Date: 16/06/2026 22:57
 */

public class Matricula {
    private static int cont = 0;

    private int id;
    private LocalDate fechaMatricula;

    private Estudiante estudiante;
    private Curso curso;
    private List<Nota> notas = new ArrayList<Nota>();

    public Matricula() {
        cont++;
        this.id = cont;
        this.fechaMatricula = LocalDate.now();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDate fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }


    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void addNota(Nota nota){
        System.out.println("Agregando nota...");
        notas.add(nota);
    }

    public void addNotas(List<Nota> notas){
        System.out.println("Agregando notas...");
        this.notas.addAll(notas);
    }

    public List<Nota> getNotas() {
        return notas;
    }

    @Override
    public String toString() {
        return String.format(
                "Matricula {" +
                        "id: %d, " +
                        "fechaMatricula: %s, " +
                        "estudiante: %s, " +
                        "curso: %s, " +
                        "notas: %s, " +
                        '}',
                id, fechaMatricula, estudiante.getNombreCompleto(), curso.getNombre(), notas
        );
    }
}