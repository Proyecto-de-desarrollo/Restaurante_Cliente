package org.example.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.api.ApiMesas;
import org.example.api.ApiUser;
import org.example.dto.LoginResponseDTO;
import org.example.model.Mesa;
import org.example.model.Usuario;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class MesaService {
    private String BASE_URL = "http://localhost:8080";
    private ApiMesas apiService;

    public MesaService() {
        this.setBaseURL();
    }

    private void setBaseURL() {
        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        this.apiService = retrofit.create(ApiMesas.class);
    }

    public List<Mesa> getMesasByUser(LoginResponseDTO loginResponseDTO) {
        try {
            String token = "Bearer " + loginResponseDTO.getToken();
            Response<List<Mesa>> call = apiService.getMesasByUser(token, loginResponseDTO.getUsuario().getId()).execute();
            if (!call.isSuccessful()) {
                throw new RuntimeException("Error: " + call.errorBody().string());
            }
            return call.body();
        } catch (IOException e) {
            throw new RuntimeException("Error de conexión");
        }
    }

    public void ocuparMesa(LoginResponseDTO loginResponseDTO, int numeroMesa) {
        try {
            String token = "Bearer " + loginResponseDTO.getToken();
            Response<Void> call = apiService.ocuparMesa(token, numeroMesa, loginResponseDTO.getUsuario().getId()).execute();
            if (!call.isSuccessful()) {
                throw new RuntimeException("Error: " + call.errorBody().string());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error de conexión");
        }
    }

    public void desocuparMesa(LoginResponseDTO loginResponseDTO, int numeroMesa) {
        try {
            String token = "Bearer " + loginResponseDTO.getToken();
            Response<Void> call = apiService.desocuparMesa(token, numeroMesa, loginResponseDTO.getUsuario().getId()).execute();
            if (!call.isSuccessful()) {
                throw new RuntimeException("Error: " + call.errorBody().string());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error de conexión");
        }
    }
}
