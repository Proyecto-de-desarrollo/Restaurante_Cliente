package org.example.controller;

import org.example.dto.LoginResponseDTO;
import org.example.model.Mesa;
import org.example.service.MesaService;

import java.util.List;

public class MesaController {
    private MesaService mesaService;

    public MesaController(){
        this.mesaService = new MesaService();
    }

    public List<Mesa> getMesasByUser(LoginResponseDTO token) { return this.mesaService.getMesasByUser(token);}

    public void ocuparMesa(LoginResponseDTO token, int numeroMesa) { this.mesaService.ocuparMesa(token, numeroMesa);}

    public void desocuparMesa(LoginResponseDTO token, int numeroMesa) { this.mesaService.desocuparMesa(token, numeroMesa);}
}
