import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

/**
 * Class Profesor
 * <p>
 * Contiene los datos de un profesor
 * @author joalf
 * @version 1.0
 * @Date: 16/06/2026 22:55
 */

public class Profesor extends Persona {
    private String especialidad;

    private Set<Curso> cursos = new HashSet<Curso>();

    public Profesor() {
    }

    public Profesor(String dni, String nombre, String apellido, String email, String especialidad) {
        super(UUID.randomUUID().toString().substring(24), dni, nombre, apellido);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    // agregar cursos - polimorfismo
    public void addCurso(Curso curso) {
        System.out.println("Asignando curso " + curso.getNombre() + " al profesor " + this.nombre + " " + this.apellido);
        cursos.add(curso);
        curso.setProfesor(this);
    }

    public void addCurso(String codigo, String nombre, int creditos) {
        Curso curso = new Curso(codigo, nombre, creditos);
        System.out.println("Asignando curso " + curso.getNombre() + " al  profesor " + this.nombre + " " + this.apellido);
        cursos.add(curso);
        curso.setProfesor(this);
    }

    @Override
    public void verNotas(String codCurso) {
        boolean encontrado = false;
        Curso curso = null;

        Iterator<Curso> iterator  = cursos.iterator();
        while (iterator.hasNext() && !encontrado) {
            curso = iterator.next();
            if (curso.getCodigo().equals(codCurso)) {
                System.out.println("Curso: " + curso.getNombre() + "\nProfesor: " + getNombreCompleto());
                encontrado = true;
                break;
            }


        }
        if (encontrado)
            curso.reporteNotas();
        else
            System.out.println("Curso no encontrado " + codCurso);
    }

    @Override
    public String toString() {
        return String.format(
                "Profesor {" +
                        "id: %s, " +
                        "dni: %s, " +
                        "nombre: %s, " +
                        "apellido: %s, " +
                        "especialidad: %s, " +
                        "cursos: %s, " +
                        "}",
                id, dni, nombre, apellido, especialidad, cursos
        );
    }

}