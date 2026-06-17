import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Class Estudiante
 * <p>
 * Contiene los datos de un estudiante
 * @author joalf
 * @version 1.0
 * @Date: 16/06/2026 22:56
 */

public class Estudiante extends Persona{
    private int codMatricula;

    private List<Matricula> matriculas = new ArrayList<Matricula>();

    public Estudiante(String dni, String nombre, String apellido, String email, int codMatricula) {
        super(UUID.randomUUID().toString().substring(24), dni, nombre, apellido);
        this.codMatricula = codMatricula;
    }

    public Estudiante() {
    }

    public int getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(int codMatricula) {
        this.codMatricula = codMatricula;
    }

    @Override
    public void verNotas(String codCurso) {
        boolean encontrado = false;
        Matricula matricula = null;

        for (Matricula m : matriculas) {
            if (m.getCurso().getCodigo().equals(codCurso)) {
                encontrado = true;
                matricula = m;
                break;
            }
        }

        if (encontrado) {
            System.out.println("Estudiante: " + getNombreCompleto());
            System.out.println("Notas del curso: " + matricula.getCurso().getNombre());
            for (Nota nota : matricula.getNotas()) {
                System.out.println(nota);
            }
        } else {
            System.out.println("No se encontró el curso con código: " + codCurso);
        }
    }

    public void addMatricula(Matricula matricula){
        System.out.println("Matriculando al estudiante " + this.nombre + " " + this.apellido);
        this.matriculas.add(matricula);
        matricula.setEstudiante(this);
    }

    // ver matriculas
    public void reporteNotas(){
        System.out.println("Matriculas del estudiante: " + this.nombre + " " + this.apellido);
        for (Matricula matricula : matriculas) {
            System.out.println(matricula);
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Estudiante {" +
                        "id: %s, " +
                        "dni: %s, " +
                        "nombre: %s, " +
                        "apellido: %s, " +
                        "cod matricula: %s, " +
                        "matriculas: %s, " +
                        "}",
                id, dni, nombre, apellido, codMatricula, matriculas
        );
    }

}
