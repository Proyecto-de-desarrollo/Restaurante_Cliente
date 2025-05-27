package org.example.api;

import org.example.model.Mesa;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ApiMesas {
    @GET("/api/mesas/user/{userId}")
    Call<List<Mesa>>getMesasByUser(@Header ("Authorization") String token,
                                   @Path("userId") Integer userId);
    @POST("/api/mesas/ocupar")
    Call<Void>ocuparMesa(@Header ("Authorization") String token,
                          @Query("numeroMesa") int numeroMesa,
                         @Query("userId") Integer userId);
    @POST("/api/mesas/desocupar")
    Call<Void>desocuparMesa(@Header ("Authorization") String token,
                         @Query("numeroMesa") int numeroMesa,
                         @Query("userId") Integer userId);
}
