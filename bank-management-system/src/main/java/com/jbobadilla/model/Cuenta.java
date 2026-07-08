package com.jbobadilla.model;

import com.jbobadilla.exception.MontoInvalidoException;
import com.jbobadilla.exception.SaldoInsuficienteException;
import com.jbobadilla.exception.TransaccionNoExisteException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class Cuenta
 * <p>
 * Description: Describe la clase Cuenta
 * @author jbobadilla
 * @version 1.0
 * @Date: 25/06/2026 23:51
 */

public class Cuenta {
    private static final Logger log = LoggerFactory.getLogger(Cuenta.class);
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
            throw new MontoInvalidoException("El monto a depositar debe ser mayor a 0");
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
            throw new SaldoInsuficienteException("No hay saldo suficiente");
    }

    public void transferir(Cuenta cuentaDestino, double monto) {
        retirar(monto);
        cuentaDestino.depositar(monto);
    }

    // Obtener depositos
    public List<Transaccion> obtenerDepositos() {
        return transacciones.stream()
                .filter(auxTransaccion -> auxTransaccion.getTipoTransaccion() == TipoTransaccion.DEPOSITO)
                .toList();
    }

    // Obeneter Retiros
    public List<Transaccion> obtenerRetiros() {
        return transacciones.stream()
                .filter(auxTransaccion -> auxTransaccion.getTipoTransaccion() == TipoTransaccion.RETIRO)
                .toList();
    }

    // Obtener Transferencias
    public List<Transaccion> obtenerTransferencias() {
        return transacciones.stream()
                .filter(auxTransaccion -> auxTransaccion.getTipoTransaccion() == TipoTransaccion.TRANSFERENCIA)
                .toList();
    }

    public void buscarTransacciones(int idTransaccion) {
        Optional<Transaccion> transaccion = transacciones.stream()
                .filter(auxTransaccion -> auxTransaccion.getId() == idTransaccion)
                .findFirst();
        if (transaccion.isPresent()) {
            log.info("Transacción encontrada: " + transaccion.get());
        } else {
            throw new TransaccionNoExisteException("La transacción no existe");
        }
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