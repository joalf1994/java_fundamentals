import java.util.ArrayList;
import java.util.List;

/**
 * Class Curso
 * <p>
 * Contiene los datos de un curso
 * @author joalf
 * @version 1.0
 * @Date: 16/06/2026 22:57
 */

public class Curso {
    private static int cont = 0;

    private int id;
    private String codigo;
    private String nombre;
    private int creditos;

    private Profesor profesor;
    private List<Matricula> matriculas = new ArrayList<Matricula>();

    public Curso() {}

    public Curso(String codigo, String nombre, int creditos) {
        cont++;
        this.id = cont;
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return String.format(
                "Asignatura {" +
                        "id: %d, " +
                        "codigo: %s, " +
                        "nombre: %s, " +
                        "creditos: %d, " +
                        '}',
                id, codigo, nombre, creditos
        );
    }

    public void addMatricula(Matricula matricula) {
        System.out.println("Agregando matricula...");
        matriculas.add(matricula);
        matricula.setCurso(this);
    }


    public void reporteNotas(){
        for (Matricula matricula : matriculas) {
            System.out.println(matricula.toString());
        }
    }
}