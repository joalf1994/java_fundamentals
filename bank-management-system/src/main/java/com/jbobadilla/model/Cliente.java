package com.jbobadilla.model;

import com.jbobadilla.exception.CuentaNoExisteException;
import com.jbobadilla.generic.Repository;
import com.jbobadilla.generic.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class cliente
 * <p>
 * Description: Describe la clase cliente
 * @author jbobadilla
 * @version 1.0
 * @Date: 25/06/2026 23:43
 */

public class Cliente implements Repository<Cuenta>, SearchResult<Cuenta> {

    private static final Logger log = LoggerFactory.getLogger(Cliente.class);
    private int id;
    private String dni;
    private String nombre;
    private String apellido;
    private String email;

    private List<Cuenta> cuentas = new ArrayList<Cuenta>();
    private Banco banco;

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
    // Agrega una nueva cuenta al cliente
    @Override
    public void save(Cuenta cuenta) {
        cuentas.add(cuenta);
        cuenta.setCliente(this);
    }

    // Busca una cuenta por su número de cuenta
    @Override
    public Cuenta findById(String nroCuenta) {
        Optional<Cuenta> cuenta = cuentas.stream()
                .filter(auxCuenta -> auxCuenta.getNroCuenta().equals(nroCuenta))
                .findFirst();
        if (cuenta.isPresent()) {
            return cuenta.get();
        } else {
            throw new CuentaNoExisteException("Cuenta no encontrada");
        }
    }

    @Override
    public List<Cuenta> findAll() {
        return cuentas;
    }

    @Override
    public void delete(String nroCuenta) {
        boolean cuentaEncontrada = false;
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNroCuenta().equals(nroCuenta)) {
                cuentas.remove(cuenta);
                cuentaEncontrada = true;
                break;
            }
        }
        if (!cuentaEncontrada) {
            throw new CuentaNoExisteException("Cuenta no encontrada");
        }
    }

    @Override
    public Cuenta searchresult(String code) {
        boolean cuentaEncontrada = false;
        Cuenta auxCuenta = null;
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNroCuenta().equals(code)) {
                cuentaEncontrada = true;
                break;
            }
        }
        if (cuentaEncontrada)
            return auxCuenta;
        else
            throw new CuentaNoExisteException("Cuenta no encontrada");
    }

    // Método para ordennar las cuentas por saldo, utilizando lambda
    public void orderBySaldo() {
        List<Cuenta> cuentasOrdenadas = new ArrayList<Cuenta>(this.cuentas);
        cuentasOrdenadas.sort((c1, c2) -> Double.compare(c2.getSaldo(), c1.getSaldo()));
        log.info("Cuentas ordenadas por saldo: " + cuentasOrdenadas);
    }

    // Obtener cuentas con mayor saldo
    public void obtenerCuentasConMayorSaldo(double saldo) {
        List<Cuenta> cuentasConMayorSaldo = new ArrayList<>();
        cuentasConMayorSaldo = cuentas.stream()
                .filter(cuenta -> cuenta.getSaldo() > saldo)
                .toList();
        log.info("Cuentas con saldo mayor a " + saldo + ": " + cuentasConMayorSaldo);
    }

    // Getters y Setters
    public Banco getBanco() {
        return banco;
    }
    public void setBanco(Banco banco) {
        this.banco = banco;
    }
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

    public List<Cuenta> getCuentas() {
        return cuentas;
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