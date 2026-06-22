# Java Smart Library

Sistema de gestión de biblioteca desarrollado en Java. 
Permite el control eficiente de libros, usuarios y préstamos, con un enfoque en la gestión de stock de ejemplares físicos.
## Tecnologías
- Java 21
- Git

## Conceptos implementados
- Programación Orientada a Objetos (POO)
- Collections (Listas, Sets, Mapas)
- Manejo de Excepciones
- Control de Stock de Ejemplares

## Funcionalidades
- Registro de autores.
- Registro de libros.
- Registro de usuarios.
- Prestamo de libro.
- Devolución de libro.
- Control de stock de ejemplares (Disponibles, Prestados, Dañados).
- Reporte de autor, libro, usuario y ejemplares.
- Reportes de ejemplares disponibles, prestados y dañados.
- Lógica para el Control de Stock (Ejemplares Disponibles = Total de Ejemplares - (Ejemplares en Préstamo + Ejemplares Dañados))

## Casos de Uso
1. Registro de un libro nuevo:
   - Crear el registro de Autor, Libro y asignas el número total de copias.
   - El sistema genera automáticamente los registros individuales en Ejemplar, (ej. si ingresas 5 copias de _Cien años de soledad_, se crean 5 ejemplares con IDs únicos). 
2. Al realizar un préstamo:
   - El sistema verifica si el libro tiene Ejemplares Disponibles > 0.
   - Se crea un registro en Préstamo.
   - El estado del Ejemplar físico cambia a "Prestado".
   - El sistema resta automáticamente 1 al contador de Ejemplares Disponibles de ese Libro.
3. Al realizar una devolución:
   - El sistema busca el registro de Préstamo y marca la fecha de entrega.
   - El estado del Ejemplar físico vuelve a "Disponible".
   - El sistema suma 1 al contador de Ejemplares Disponibles del Libro.
