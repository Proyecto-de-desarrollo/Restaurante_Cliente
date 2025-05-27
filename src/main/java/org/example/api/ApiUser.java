package org.example.api;

import org.example.dto.LoginRequestDTO;
import org.example.dto.LoginResponseDTO;
import org.example.model.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiUser {
    @POST("/api/usuarios/login")
    Call<LoginResponseDTO> login(@Body LoginRequestDTO loginRequestDTO);

    @POST("/api/usuarios")
    Call<Usuario> add (@Body Usuario usuario);
}
