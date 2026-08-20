package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Ejemplar
 * <p>
 *
 * @author joalf
 * @version 1.0
 * @Date: 18/06/2026 07:34
 */

public class Ejemplar {
    private int id;
    private String codigo;
    private Estado estado;

    private Libro libro;
    private List<Prestamo> prestamos = new ArrayList<Prestamo>();

    public Ejemplar(int id, String codigo, Estado estado) {
        this.id = id;
        this.codigo = codigo;
        this.estado = estado;
    }
    public Ejemplar() {}

    public void addPrestamo(Prestamo prestamo) {
        System.out.println("Agregando prestamo " + prestamo.getFechaPrestamo() + " - " + prestamo.getFechaDevolucion());
        prestamos.add(prestamo);
        prestamo.setEjemplar(this);
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Ejemplar{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", estado=" + estado +
                '}';
    }
}