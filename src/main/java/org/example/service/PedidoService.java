package org.example.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.api.ApiMesas;
import org.example.api.ApiPedido;
import org.example.dto.LoginResponseDTO;
import org.example.dto.PedidoDTO;
import org.example.model.Pedido;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class PedidoService {
    private String BASE_URL = "https://restaurante-backend-fqb5.onrender.com/";
    private ApiPedido apiService;

    public PedidoService() {
        this.setBaseURL();
    }

    private void setBaseURL() {
        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        this.apiService = retrofit.create(ApiPedido.class);
    }

    public Pedido save(LoginResponseDTO loginResponseDTO, PedidoDTO pedido) {
        try{
            String token = "Bearer " + loginResponseDTO.getToken();
            Response<Pedido> response = this.apiService.add(token, pedido).execute();
            if (!response.isSuccessful()) {
                throw new RuntimeException("Error: " + response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new RuntimeException("Error de conexion");
        }
    }

    public List<Pedido> getByUser(LoginResponseDTO loginResponseDTO) {
        try{
            String token = "Bearer " + loginResponseDTO.getToken();
            Response<List<Pedido>> response = this.apiService.getPedidosByUser(token, loginResponseDTO.getUsuario().getId()).execute();
            if (!response.isSuccessful()) {
                throw new RuntimeException("Error: " + response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new RuntimeException("Error de conexion");
        }
    }
}
