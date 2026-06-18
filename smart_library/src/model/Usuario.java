package model;

/**
 * Class Usuario
 * <p>
 * Description: Clase que representa a un usuario o cliente en el sistema
 * @author joalf
 * @version 1.0
 * @Date: 17/06/2026 22:48
 */

public class Usuario {
    private int id;
    private String dni;
    private String nombre;
    private String apellido;

    // Constructor
    public Usuario(int id, String dni, String nombre, String apellido) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Usuario() {}

    // solicitar préstamo de libro


    // devolver libro


    // Getters y Setters
    public int getId() {
        return id;
    }
    public String getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {}
}