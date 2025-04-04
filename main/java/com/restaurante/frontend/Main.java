package com.restaurante.frontend;

import com.restaurante.frontend.servicios.Sesion;
import com.restaurante.frontend.vistas.VentanaInicio;

public class Main {
    public static void main(String[] args) {
        Sesion sesion = new Sesion();
        new VentanaInicio(sesion);
    }
}
