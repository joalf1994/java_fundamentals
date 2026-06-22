package model;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class Libro
 * <p>
 * Descripción: Contiene los datos de un libro
 * @author joalf
 * @version 1.0
 * @Date: 18/06/2026 06:21
 */

public class Libro {

    private int id;
    private String isbn;
    private String titulo;
    private String editorial;
    private int anio;
    private int totalEjemplares;
    private int ejemplaresDisponibles;

    private Autor autor;
    private List<Ejemplar> ejemplares = new ArrayList<>();

    // Constructor
    public Libro() {}

    public Libro(int id, String isbn, String titulo, String editorial, int anio, int totalEjemplares) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.editorial = editorial;
        this.anio = anio;
        this.totalEjemplares = totalEjemplares;

        addEjemplar();
    }

    public List<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    // Agregar ejemplares
    public void addEjemplar() {
        for (int i = 0; i < totalEjemplares; i++) {
            Ejemplar ejemplar = new Ejemplar(i+1, isbn + (i+1), Estado.DISPONIBLE);
            ejemplares.add(ejemplar);
            ejemplar.setLibro(this);
        }
        actualizarStock(Estado.DISPONIBLE, isbn );
    }

    // actualizar estado de libro
    public void actualizarStock(Estado estado, String codigo) {
        // cambiar estado del ejemplar
        Iterator<Ejemplar> itEjemplar = ejemplares.iterator();
        while (itEjemplar.hasNext()) {
            Ejemplar ejemplar = itEjemplar.next();
            if (ejemplar.getCodigo().equals(codigo)) {
                ejemplar.setEstado(estado);
                break;
            }
        }

        // actualizar stock disponible
        setEjemplaresDisponibles();
    }

    public List<Ejemplar> ejemplaresEnPrestamo() {
        return ejemplares.stream()
                .filter(p -> p.getEstado() == Estado.PRESTADO).toList();
    }

    public List<Ejemplar> ejemplaresAReparar() {
        return ejemplares.stream()
                .filter(p -> p.getEstado() == Estado.EN_REPARACION).toList();
    }

    public List<Ejemplar> ejemplaresDisponibles() {
        return ejemplares.stream()
                .filter(p -> p.getEstado() == Estado.DISPONIBLE).toList();
    }



    // Getters y Setters
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getAnio() {
        return anio;
    }

    public int getTotalEjemplares() {
        return totalEjemplares;
    }

    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setEjemplaresDisponibles() {
        this.ejemplaresDisponibles = totalEjemplares - (ejemplaresEnPrestamo().size() + ejemplaresAReparar().size());
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autor='" + autor.getNombre() + " " + autor.getApellido() + '\'' +
                ", id=" + id + '\'' +
                ", isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", editorial='" + editorial + '\'' +
                ", anio=" + anio +
                ", totalEjemplares=" + totalEjemplares +
                ", ejemplaresDisponibles=" + ejemplaresDisponibles +
                '}';
    }
}