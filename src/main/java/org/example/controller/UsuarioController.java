package org.example.controller;

import org.example.dto.LoginResponseDTO;
import org.example.model.Usuario;
import org.example.service.UsuarioService;

public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController() {
        this.usuarioService = new UsuarioService();
    }

    public LoginResponseDTO login(String username, String password) {
        return this.usuarioService.login(username, password);
    }

    public Usuario add(String nombre, String email, String telefono, String contrasena) {
        return this.usuarioService.add(nombre, email, telefono, contrasena);
    }

}
