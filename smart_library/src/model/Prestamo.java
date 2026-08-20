package model;

import java.time.LocalDate;

/**
 * Class Prestamo
 * <p>
 *
 * @author joalf
 * @version 1.0
 * @Date: 18/06/2026 07:35
 */

public class Prestamo {
    private static int contador = 0;

    private int id;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    private Ejemplar ejemplar;
    private Usuario usuario;

    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        contador++;
        this.id = contador;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Prestamo() {}

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }
    public Ejemplar getEjemplar() {
        return ejemplar;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", ejemplar=" + ejemplar +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }
}