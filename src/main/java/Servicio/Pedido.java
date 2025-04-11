package Servicio;

public class Pedido {
    private static String plato;
    private static String bebida;
    private static String postre;

    public static void setPlato(String p) {
        plato = p;
    }

    public static String getPlato() {
        return plato;
    }

    public static void setBebida(String b) {
        bebida = b;
    }

    public static String getBebida() {
        return bebida;
    }

    public static void setPostre(String p) {
        postre = p;
    }

    public static String getPostre() {
        return postre;
    }

    public static void resetear() {
        plato = null;
        bebida = null;
        postre = null;
    }
}