import java.util.*;

class lectura_sensor {
    int id;
    double valor;
    String type; // Tipo
    long ts; // Time stamp

    lectura_sensor(int id, double valor, String type, long ts) {
        this.id = id;
        this.valor = valor;
        this.type = type;
        this.ts = ts;
    }
}

public class Main {
    public static void main(String[] args) {
        long ahora = System.currentTimeMillis();

        List<lectura_sensor> lista = Arrays.asList(
            new lectura_sensor(1, 10.5, "a", ahora - 1000 * 60 * 60),
            new lectura_sensor(2, 20.0, "b", ahora - 1000 * 60 * 60 * 2),
            new lectura_sensor(3, 15.0, "y", ahora - 1000L * 60 * 60 * 30),
            new lectura_sensor(3, 15.0, "a", ahora - 1000L * 60 * 60 * 30)
        );

        List<lectura_sensor> filtro = lista.stream()
            .filter(x -> x.type.equals("a"))
            .toList();

        double promedio = lista.stream()
            .filter(x -> x.ts >= ahora - 1000L * 60 * 60 * 24)
            .mapToDouble(x -> x.valor)
            .average()
            .orElse(0.0);

        lectura_sensor maximo = lista.stream()
            .max(Comparator.comparingDouble(x -> x.valor))
            .orElse(null);

        System.out.println("Cantidad de valores: " + filtro.size());
        System.out.println("Valor Promedio: " + promedio);
        System.out.println("Valor maximo: " + (maximo != null ? maximo.valor : null));
    }
}