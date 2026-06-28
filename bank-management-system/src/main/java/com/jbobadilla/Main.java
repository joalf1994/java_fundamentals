package com.jbobadilla;

import com.jbobadilla.model.Cliente;
import com.jbobadilla.model.Cuenta;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1, "12345678", "Juan", "Pérez", "jp@gmail.com");
        Cuenta cuenta = new Cuenta("123456789", 1000.0);
        Cuenta cuenta2 = new Cuenta("987654321", 100.0);

        cliente.addCuenta(cuenta);
        cliente.addCuenta(cuenta2);

        System.out.println(cliente.getCuentas());
        cuenta.depositar(500.0);
        cuenta.retirar(200.0);
        cuenta.transferir(cuenta2, 200.0);
        cuenta2.retirar(50.0);

        System.out.println(cuenta.getTransacciones());
        System.out.println(cuenta2.getTransacciones());
        System.out.println(cliente.getCuentas());
    }
}