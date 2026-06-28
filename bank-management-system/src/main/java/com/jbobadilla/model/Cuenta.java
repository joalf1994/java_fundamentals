package com.jbobadilla.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    private static int countCuenta = 0;

    private Cliente cliente;
    private List<Transaccion> transacciones = new ArrayList<Transaccion>();

    // Constructor
    public Cuenta(String nroCuenta, double saldo) {
        countCuenta++;
        this.id = countCuenta;
        this.nroCuenta = nroCuenta;
        this.saldo = saldo;
        this.fechaCreacion = LocalDate.now();
    }

    public Cuenta() {}

    // Métodos adicionales
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            // crea una nueva transacción de tipo DEPOSITO y la agrega a la lista de transacciones
            Transaccion transaccion = new Transaccion(monto, TipoTransaccion.DEPOSITO);
            transacciones.add(transaccion);

            // actualiza el saldo de la cuenta
            saldo += monto;
        } else {
            throw new IllegalArgumentException("El monto debe ser mayor que 0");
        }
    }

    public void retirar(double monto) {
        if (monto <= saldo) {
            // Crea una nueva transacción de tipo RETIRO y la agrega a la lista de transacciones
            Transaccion transaccion = new Transaccion(monto, TipoTransaccion.RETIRO);
            transacciones.add(transaccion);
            // actualiza el saldo de la cuenta
            saldo -= monto;
        } else
            throw new IllegalArgumentException("El monto a retirar es mayor que el saldo disponible");
    }

    public void transferir(Cuenta cuentaDestino, double monto) {
        retirar(monto);
        cuentaDestino.depositar(monto);
    }

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

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", nroCuenta='" + nroCuenta + '\'' +
                ", saldo=" + saldo +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}