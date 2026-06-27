package com.jbobadilla.model;

/**
 * Class cliente
 * <p>
 * Description: Describe la clase cliente
 * @author jbobadilla
 * @version 1.0
 * @Date: 25/06/2026 23:43
 */

public class Cliente {

    private int id;
    private String dni;
    private String nombre;
    private String apellido;
    private String email;

    // Constructor
    public Cliente(int id, String dni, String nombre, String apellido, String email) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public Cliente() {}

    // Métodos adicionales


    // Getters y Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}