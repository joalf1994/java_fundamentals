package com.jbobadilla.model;

import java.time.LocalDateTime;

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
    private LocalDateTime fecha;
    private double monto;
    private TipoTransaccion tipoTransaccion;

    private static int countTransac = 0;


    // Constructor
    public Transaccion(LocalDateTime fecha, double monto, TipoTransaccion tipoTransaccion) {
        this(monto, tipoTransaccion);
        this.fecha = fecha;
    }

    public Transaccion(double monto, TipoTransaccion tipoTransaccion) {
        countTransac++;
        this.id = countTransac;
        this.fecha = LocalDateTime.now();
        this.monto = monto;
        this.tipoTransaccion = tipoTransaccion;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
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

    @Override
    public String toString() {
        return "Transaccion{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", monto=" + monto +
                ", tipoTransaccion=" + tipoTransaccion +
                '}';
    }
}
