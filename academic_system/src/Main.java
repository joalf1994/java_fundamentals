import java.util.List;

/**
 * Clase Main
 * <p>
 * En esta clase se crea un registro de estudiantes, profesores, cursos y matriculas.
 * Se asignan estudiantes a cursos, profesores a cursos y se asignan notas a las matriculas.
 * Luego se visualizan los datos de los cursos, profesores, estudiantes y las notas asignadas a cada estudiante por curso.
 * @author joalf
 * @version 1.0
 * @Date: 12/06/2026 01:16
 */

public class Main {
    public static void main(String[] args) {

        //cursos
        Curso math = new Curso("MAT101", "Matemáticas", 3);
        Curso hist = new Curso("His101", "Historia", 4);

        //profesor
        Profesor castillo = new Profesor("48415555", "Carlos", "Castillo", "cc@gmail.com", "Matemáticas");
        Profesor gutierrez = new Profesor("85421369", "Jorge", "Guitierrez", "jg@gmail.com", "Historia");

        // estudiante
        Estudiante e1 = new Estudiante("123456789", "Juan", "Perez", "juan@gmail.com", 101010 );
        Estudiante e2 = new Estudiante( "12345678", "Jose", "Garcia", "maria@gmail.com", 101011);
        Estudiante e3 = new Estudiante("78451236", "Paola", "Huaman", "sph@gmail.com", 101012);
        Estudiante e4 = new Estudiante("58461236", "Paty", "Pereira", "pp@gmail.com", 101013);

        Nota nota1 = new Nota(1, 10.0);
        Nota nota2 = new Nota(2, 9.0);
        Nota nota3 = new Nota(3, 8.0);
        Nota nota4 = new Nota(4, 7.6);
        Nota nota5 = new Nota(5, 8.2);

        // asignar matricula a estudiantes y cursos
        Matricula m1 = new Matricula();
        Matricula m2 = new Matricula();
        Matricula m3 = new Matricula();
        Matricula m4 = new Matricula();
        Matricula m5 = new Matricula();

        math.addMatricula(m1);
        e1.addMatricula(m1);

        math.addMatricula(m2);
        e2.addMatricula(m2);

        hist.addMatricula(m3);
        e3.addMatricula(m3);

        hist.addMatricula(m4);
        e4.addMatricula(m4);

        // asignar cursos a profesores
        castillo.addCurso(math);
        gutierrez.addCurso(hist);

        // asignar notas a matriculas
        m1.addNota(nota1);
        m1.addNota(nota2);
        m1.addNota(nota3);

        m2.addNota(nota3);
        m2.addNota(nota4);
        m2.addNota(nota5);

        m3.addNota(nota4);
        m3.addNota(nota5);

        m4.addNotas(List.of(nota1, nota2));

        m5.addNotas(List.of(nota1, nota4, nota5));
        System.out.println("\n-------- VISUALIZACIÓN DE DATOS --------");

        // visualizar cursos
        System.out.println("Cursos:");
        System.out.println(math.toString());
        System.out.println(hist.toString());
        System.out.println();

        // visualizar profesores
        System.out.println("Profesores:");
        System.out.println(castillo.toString());
        System.out.println(gutierrez.toString());
        System.out.println();

        // visualizar Estudiantes
        System.out.println("Estudiantes:");
        System.out.println(e1.toString());
        System.out.println(e2.toString());
        System.out.println(e3.toString());
        System.out.println(e4.toString());
        System.out.println();

        // profesor ve notas de un curso
        System.out.println("Notas de los profesores:");
        castillo.verNotas(math.getCodigo());
        System.out.println();

        gutierrez.verNotas(hist.getCodigo());
        System.out.println();

        // estudiante ve notas de un curso
        System.out.println("Notas de los estudiantes:");
        e1.verNotas(math.getCodigo());
        System.out.println();
        e2.verNotas(math.getCodigo());
        System.out.println();
        e3.verNotas(hist.getCodigo());
        System.out.println();
        e4.verNotas(hist.getCodigo());
    }
}