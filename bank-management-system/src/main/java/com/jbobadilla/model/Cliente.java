package com.jbobadilla.model;

import java.util.ArrayList;
import java.util.List;

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

    private List<Cuenta> cuentas = new ArrayList<Cuenta>();

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
    public void addCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
        cuenta.setCliente(this);
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void delCuenta(String nroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNroCuenta().equals(nroCuenta)) {
                cuentas.remove(cuenta);
                break;
            }
        }

    }

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



    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}