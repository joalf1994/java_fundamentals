package com.jbobadilla.model;

import java.time.LocalDate;

/**
 * Class Cuenta
 * <p>
 * Description: Describe la clase Cuenta
 * @author jbobadilla
 * @version 1.0
 * @Date: 25/06/2026 23:51
 */

public class Cuenta {
    private int id;
    private String nroCuenta;
    private double saldo;
    private LocalDate fechaCreacion;

    // Constructor
    public Cuenta(int id, String nroCuenta, double saldo, LocalDate fechaCreacion) {
        this.id = id;
        this.nroCuenta = nroCuenta;
        this.saldo = saldo;
        this.fechaCreacion = fechaCreacion;
    }

    public Cuenta() {}

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}