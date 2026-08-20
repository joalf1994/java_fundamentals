package com.jbobadilla.model;

import com.jbobadilla.exception.ClienteNoExisteException;
import com.jbobadilla.generic.Repository;
import com.jbobadilla.generic.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Class Banco
 * <p>
 * Description: Describe la clase Banco y contiene a los clientes
 * @author joalf
 * @version 1.0
 * @Date: 3/07/2026 23:46
 */

public class Banco implements Repository<Cliente>, SearchResult<Cliente> {
    private static final Logger log = LoggerFactory.getLogger(Banco.class);
    private int id;
    private String nombre;

    private List<Cliente> clientes = new ArrayList<Cliente>();

    // Constructor
    public Banco(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Métodos adicionales
    // Agrega un nuevo cliente al banco
    @Override
    public void save(Cliente cliente) {
        clientes.add(cliente);
        cliente.setBanco(this); // Asigna el banco al cliente
    }

    // Busca un cliente por su ID
    @Override
    public Cliente findById(String dni) {
        Optional<Cliente> cliente = clientes.stream()
                .filter(auxCliente -> auxCliente.getDni() == dni)
                .findFirst();
        if (cliente.isPresent()) {
            return cliente.get();
        } else  {
            throw new ClienteNoExisteException("Cliente no encontrado");
        }
    }

    // Devuelve una lista de todos los clientes
    @Override
    public List<Cliente> findAll() {
        return clientes;
    }

    // Elimina un cliente del banco
    @Override
    public void delete(String dni) {
        boolean clienteEncontrado = false;
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                clientes.remove(cliente);
                clienteEncontrado = true;
                break;
            }
        }
        if (!clienteEncontrado) {
            throw new ClienteNoExisteException("Cliente no encontrado");
        }
    }

    @Override
    public Cliente searchresult(String code) {
        boolean clienteEncontrado = false;
        Cliente auxCliente = null;
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(code)) {
                clienteEncontrado = true;
                break;
            }
        }
        if (clienteEncontrado) {
            return auxCliente;
        } else
            throw new ClienteNoExisteException("Cliente no encontrado");
    }

    // Métodos para ordenar los clientes por nombre o apellido (utilizando lambda)
    public void orderByNombre() {
        List<Cliente> clientes = new ArrayList<Cliente>(this.clientes);
        clientes.sort((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));
        log.info("Clientes ordenados por nombre: " + clientes);
    }

    public void orderByApellido() {
        List<Cliente> clientes = new ArrayList<Cliente>(this.clientes);
        clientes.sort((p1, p2) -> p1.getApellido().compareTo(p2.getApellido()));
        log.info("Clientes ordenados por apellido: " + clientes);
    }

    // Obtener clientes con mas 2 cuentas
    public void getTopClientes(int cantidad) {
        Set<Cliente> clientesConMasCuentas = new HashSet<>(clientes);
        Iterator<Cliente> iterator = clientesConMasCuentas.iterator();
        log.info("Cliente con más de 2 cuentas: ");
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getCuentas().size() > cantidad) {
                log.info(String.valueOf(cliente));
            }
        }
    }



    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", clientes=" + clientes +
                '}';
    }
}