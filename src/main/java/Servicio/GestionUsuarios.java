package Servicio;
import java.util.HashMap;
import java.util.Map;

public class GestionUsuarios {
    private static Map<String, String> usuarios = new HashMap<>();

    static {
        usuarios.put("admin", "1234"); 
        usuarios.put("usuario1", "contraseña1");
        usuarios.put("usuario2", "contraseña2");
    }

    public static boolean validarUsuario(String usuario, String contraseña) {
        return usuarios.containsKey(usuario) && usuarios.get(usuario).equals(contraseña);
    }
    
    public static boolean registrarUsuario(String usuario, String contraseña) {
        if (usuarios.containsKey(usuario)) {
            return false; 
        }
        usuarios.put(usuario, contraseña);
        return true; 
    }
}
