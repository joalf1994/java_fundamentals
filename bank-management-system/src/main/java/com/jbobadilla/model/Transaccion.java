package com.jbobadilla.model;

import java.time.LocalDate;

/**
 * Class Transaccion
 * <p>
 * Description: Describe la clase Transaccion
 * @author jbobadilla
 * @version 1.0
 * @Date: 25/06/2026 23:51
 */

public class Transaccion {
    private int id;
    private LocalDate fecha;
    private double monto;
    private TipoTransaccion tipoTransaccion;

    // Constructor
    public Transaccion(int id, LocalDate fecha, double monto, TipoTransaccion tipoTransaccion) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.tipoTransaccion = tipoTransaccion;
    }

    public Transaccion() {}

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }
}
