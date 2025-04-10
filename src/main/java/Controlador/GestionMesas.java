package Controlador;
import java.util.HashMap;
import java.util.Map;

public class GestionMesas {
    private static final Map<Integer, Boolean> estadosMesas = new HashMap<>();

    static {
        for (int i = 1; i <= 10; i++) {
            estadosMesas.putIfAbsent(i, false); 
        }
    }

    public static boolean isMesaOcupada(int numeroMesa) {
        return estadosMesas.getOrDefault(numeroMesa, false);
    }

    public static void setMesaOcupada(int numeroMesa, boolean ocupada) {
        estadosMesas.put(numeroMesa, ocupada);
    }

    public static Map<Integer, Boolean> getEstadosMesas() {
        return estadosMesas; 
    }
}
