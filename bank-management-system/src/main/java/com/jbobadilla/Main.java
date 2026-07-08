package com.jbobadilla;

import com.jbobadilla.model.Banco;
import com.jbobadilla.model.Cliente;
import com.jbobadilla.model.Cuenta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Banco banco = new Banco(1, "Banco de Prueba");

        //Creamos los clientes
        Cliente juan = new Cliente(1, "12345678", "Juan", "Perez", "jp@gmail.com");
        Cliente pedro =  new Cliente(2, "22222222", "Pedro", "Pascal", "pp@gmail.com");
        Cliente tom = new Cliente(3, "33333333", "Tom", "Hardy", "th@gmail.com");

        banco.save(juan);
        banco.save(pedro);
        banco.save(tom);

        Cuenta c1 = new Cuenta("123456789", 1000.0);
        Cuenta c2 = new Cuenta("987654321", 250.0);
        Cuenta c3 = new Cuenta("456789012", 200.0);
        Cuenta c4 = new Cuenta("098765432", 500.0);
        Cuenta c5 = new Cuenta("543210987", 150.0);
        Cuenta c6 = new Cuenta("654321098", 300.0);

        juan.save(c1);
        juan.save(c2);
        pedro.save(c3);
        pedro.save(c4);
        pedro.save(c5);
        tom.save(c6);

        // transacciones
        c1.depositar(500.0);
        c1.retirar(100.0);
        c1.transferir(c2, 50.0);

        c2.retirar(100.0);
        c2.depositar(800);
        c2.retirar(100.0);
        c2.retirar(200.0);
        c2.transferir(c3, 100.0);

        c3.retirar(100.0);
        c3.transferir(c4, 100.0);

        c4.depositar(1100.0);
        c4.retirar(350.0);

        c5.retirar(100.0);
        c5.transferir(c6, 20.0);

        c6.retirar(120.0);
        c6.depositar(350);

        banco.orderByNombre();
        banco.orderByApellido();

        banco.getTopClientes(2);

        juan.obtenerCuentasConMayorSaldo(600.0);

        log.info(banco.getClientes().toString());
        log.info(juan.getCuentas().toString());
        log.info(tom.getCuentas().toString());
        log.info(pedro.getCuentas().toString());
        pedro.orderBySaldo();



    }
}