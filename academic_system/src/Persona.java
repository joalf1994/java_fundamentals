/**
 * Class Persona
 * <p>
 * Contiene los datos de una persona
 * @author joalf
 * @version 1.0
 * @Date: 16/06/2026 22:54
 */

public abstract class Persona {
    protected String id;
    protected String dni;
    protected String nombre;
    protected String apellido;

    public Persona(String id, String dni, String nombre, String apellido) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Persona() {
    }

    public abstract void verNotas(String codCurso);

    public String getNombreCompleto(){
        return this.nombre + " " + this.apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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
}