package model;

import exception.LibroNoDisponibleException;
import exception.LibroNoEncontradoException;

import java.time.LocalDate;
import java.util.*;

/**
 * Class Usuario
 * <p>
 * Description: Clase que representa a un usuario o cliente en el sistema
 * @author joalf
 * @version 1.0
 * @Date: 17/06/2026 22:48
 */

public class Usuario {
    private int id;
    private String dni;
    private String nombre;
    private String apellido;

    private List<Prestamo> prestamos = new ArrayList<>();

    // Constructor
    public Usuario(int id, String dni, String nombre, String apellido) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Usuario() {}

    // solicitar préstamo de libro
    public void solicitarPrestamo(String isbn, List<Autor> autores) throws LibroNoDisponibleException {
        System.out.println("El usuario " + nombre + " " + apellido + " solicita el libro con ISBN: " + isbn);
        boolean encontrado = false;
        Iterator<Autor> itAutor = autores.iterator();
        // Iterar sobre los autores
        while (itAutor.hasNext() && !encontrado) {
            Autor autor = itAutor.next();
            Iterator<Libro> itLibro = autor.getLibros().iterator();
            // Iterar sobre los libros del autor
            while (itLibro.hasNext()) {
                Libro libro = itLibro.next();
                if (libro.getIsbn().equals(isbn)) {
                    if (libro.getEjemplaresDisponibles() > 0) {
                        addPrestamo(libro, LocalDate.now(), LocalDate.now().plusDays(7));
                        encontrado = true;
                        break;

                    } else {
                        throw new LibroNoDisponibleException("No hay ejemplares disponibles");
                    }
                }
            }
        }
        if (!encontrado) {
            System.out.println("Libro no encontrado.");
        }
    }

    public void addPrestamo(Libro libro, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        Ejemplar ejemplar = libro.ejemplaresDisponibles().getFirst();

        Prestamo prestamo = new Prestamo(fechaPrestamo, fechaDevolucion);
        prestamo.setEjemplar(ejemplar);
        prestamo.setUsuario(this);
        // agregar prestamo a la lista
        prestamos.add(prestamo);

        // actualizar estado del ejemplar
        libro.actualizarStock(Estado.PRESTADO, ejemplar.getCodigo());

        // agregar prestamo al ejemplar
        ejemplar.addPrestamo(prestamo);
    }


    // devolver libro
    public void devolverLibro(String isbn) throws LibroNoEncontradoException {
        System.out.println("El usuario " + nombre + " " + apellido + " devuelve el libro con ISBN: " + isbn);
        boolean encontrado = false;


        Iterator<Prestamo> itPrestamo = prestamos.iterator();
        while (itPrestamo.hasNext() && !encontrado) {
            Prestamo prestamo = itPrestamo.next();
            if (prestamo.getEjemplar().getLibro().getIsbn().equals(isbn)) {
                if (prestamo.getEjemplar().getEstado() == Estado.PRESTADO) {
                    prestamo.setFechaDevolucion(LocalDate.now());
                    prestamo.getEjemplar().getLibro().actualizarStock(Estado.DISPONIBLE, prestamo.getEjemplar().getCodigo());
                    encontrado = true;
                    prestamos.remove(prestamo);
                    System.out.println("Libro devuelto exitosamente.");
                    break;
                } else {
                    System.out.println("El libro ya ha sido devuelto.");
                    break;
                }

            }

        }
        if (!encontrado) {
            throw new LibroNoEncontradoException("Libro no encontrado.");
        }
    }


    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }
    public String getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {}

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}