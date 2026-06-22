import exception.LibroNoDisponibleException;
import model.Autor;
import model.Libro;
import model.Usuario;

import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("=============================================");
        System.out.println("==== Bienvenido al sistema de biblioteca ====");
        System.out.println("=============================================");

        System.out.println("> Creando Autores y Libros");
        Autor llosa = new Autor(1, "10101010", "Mario", "Vargas LLosa");;
        Autor kafka = new Autor(2, "20202020", "Frank", "Kafka");

        Libro v1 = new Libro(1, "V101", "Los jefes", "Peisa", 1959, 5);
        Libro v2 = new Libro(2, "V102", "La ciudad y los perros", "Peisa", 1963, 5);
        Libro v3 = new Libro(3, "V103", "La casa verde", "Peisa", 1966, 5);
        Libro v4 = new Libro(4, "V104", "Los cachorros", "Peisa", 1967, 5);
        Libro v5 = new Libro(5, "V105", "Conversación en la catedral", "Peisa", 1969, 5);
        Libro v6 = new Libro(6, "V106", "Pantaleón y las visitadoras", "Peisa", 1973, 5);

        Libro k1 = new Libro(1, "K201", "La metamorfosis", "Peisa", 1915, 10);
        Libro k2 = new Libro(2, "K202", "El proceso", "Peisa", 1925, 10);
        Libro k3 = new Libro(3, "K203", "El castillo", "Peisa", 1926, 10);
        Libro k4 = new Libro(4, "K204", "América ", "Peisa", 1927, 10);

        System.out.println("> Agregando libros a los autores");
        llosa.addLibro(v1);
        llosa.addLibro(v2);
        llosa.addLibro(v3);
        llosa.addLibro(v4);
        llosa.addLibro(v5);
        llosa.addLibro(v6);

        kafka.addLibro(k1);
        kafka.addLibro(k2);
        kafka.addLibro(k3);
        kafka.addLibro(k4);

        List<Autor> autores = List.of(llosa, kafka);

        Usuario usuario = new Usuario(1, "12345678", "Juan", "Perez");
        usuario.solicitarPrestamo("V101", autores);
        usuario.solicitarPrestamo("V102", autores);
        usuario.solicitarPrestamo("K203", autores);
        usuario.solicitarPrestamo("K204", autores);
        usuario.solicitarPrestamo("K204", autores);
        System.out.println(v1.ejemplaresEnPrestamo());

        System.out.println("\n> Imprimiendo Autores");
        autores.forEach(System.out::println);
        System.out.println("\n> Imprimiendo Libros");
        autores.forEach(a -> System.out.println(a.getLibros()));

        System.out.println("\n> Imprimiendo ejemplares de cada libro");

        Iterator<Autor> itAutor = autores.iterator();
        while (itAutor.hasNext()) {
            Autor autor = itAutor.next();
            Iterator<Libro> itLibro = autor.getLibros().iterator();
            while (itLibro.hasNext()) {
                Libro libro = itLibro.next();
                System.out.println("-> Libro [" + libro.getTitulo() + " - " + autor.getNombreCompleto() +"]: " +libro.getEjemplares());
            }
        }
        System.out.println("\n> Imprimiendo Usuarios y sus prestamos");
        System.out.println(usuario);
        System.out.println(usuario.getPrestamos());


        System.out.println("\n> Devolviendo libro");
        usuario.devolverLibro("V102");

        System.out.println("\n> Imprimiendo Usuarios y sus prestamos");
        System.out.println(usuario);
        System.out.println(usuario.getPrestamos());

        System.out.println("\n> Ejemplares disponibles:");
        Iterator<Autor> itAutor1 = autores.iterator();
        while (itAutor1.hasNext()) {
            Autor autor = itAutor1.next();
            Iterator<Libro> itLibro1 = autor.getLibros().iterator();
            while (itLibro1.hasNext()) {
                Libro libro = itLibro1.next();
                System.out.println("-> Libro [" + libro.getTitulo() + " - " + autor.getNombreCompleto() + " - cant " +libro.ejemplaresDisponibles().size() + "]: " +libro.ejemplaresDisponibles());
            }
        }

        System.out.println("\n> Ejemplares Prestados:");
        Iterator<Autor> itAutor2 = autores.iterator();
        while (itAutor2.hasNext()) {
            Autor autor = itAutor2.next();
            Iterator<Libro> itLibro2 = autor.getLibros().iterator();
            while (itLibro2.hasNext()) {
                Libro libro = itLibro2.next();
                System.out.println("-> Libro [" + libro.getTitulo() + " - " + autor.getNombreCompleto() + " - cant " + libro.ejemplaresEnPrestamo().size() + "]: " +libro.ejemplaresEnPrestamo());
            }
        }



    }
}
