package model;

import java.util.HashSet;
import java.util.Set;

/**
 * Class Autor
 * <p>
 * Descripión: Contiene los datos de un autor de un libro
 * @author joalf
 * @version 1.0
 * @Date: 18/06/2026 06:17
 */

public class Autor {

    private int id;
    private String dni;
    private String nombre;
    private String apellido;

    private Set<Libro> libros = new HashSet<Libro>();

    // Constructor
    public Autor() {}

    public Autor(int id, String dni, String nombre, String apellido) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Agregar libro
    public void addLibro(Libro libro) {
        libros.add(libro);
        libro.setAutor(this);
    }

    public Set<Libro> getLibros() {
        return libros;
    }

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

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}