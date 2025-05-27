package org.example.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.api.ApiUser;
import org.example.dto.LoginRequestDTO;
import org.example.dto.LoginResponseDTO;
import org.example.model.Usuario;
import org.example.view.Login;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsuarioService {
    private String BASE_URL = "https://restaurante-backend-fqb5.onrender.com/";
    private ApiUser apiService;

    public UsuarioService() {
        this.setBaseURL();
    }

    private void setBaseURL() {
        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        this.apiService = retrofit.create(ApiUser.class);
    }

    public Usuario add(String nombre, String email, String telefono, String contrasena) {
        try {
            Usuario user = new Usuario(nombre, email, telefono, contrasena);
            Response<Usuario> response = apiService.add(user).execute();

            if (!response.isSuccessful()) {
                throw new RuntimeException("Error: " + response.errorBody().string());
            }
            return response.body();
        }catch (IOException ex){
            throw new RuntimeException("Error de conexión");
        }
    }

    public LoginResponseDTO login(String email, String contrasena) {
        try {
            LoginRequestDTO loginRequestDTO = new LoginRequestDTO(email, contrasena);
            Response<LoginResponseDTO> response = apiService.login(loginRequestDTO).execute();
            if (!response.isSuccessful()) {
                throw new RuntimeException("Error: " + response.errorBody().string());
            }
            return response.body();
        }catch (IOException ex){
            throw new RuntimeException("Error de conexión");
        }
    }


}
