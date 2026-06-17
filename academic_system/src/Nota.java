/**
 * Class Nota
 * <p>
 * Contiene una nota y las referencias de un curso y un estudiante
 * @author joalf
 * @version 1.0
 * @Date: 16/06/2026 22:58
 */

public class Nota {
    private int id;
    private Double valor;

    public Nota(int id, Double valor) {
        this.id = id;
        this.valor = valor;
    }

    public Nota() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getNota() {
        return valor;
    }

    public void setNota(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format(
                "nota: %.2f", valor
        );
    }
}