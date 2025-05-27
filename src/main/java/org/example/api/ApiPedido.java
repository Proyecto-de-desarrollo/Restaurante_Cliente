package org.example.api;

import org.example.dto.PedidoDTO;
import org.example.model.Pedido;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ApiPedido {

    @GET("/api/pedidos/user/{userId}")
    Call<List<Pedido>> getPedidosByUser(@Header("Authorization") String token, @Path("userId") Integer userId);

    @POST("/api/pedidos")
    Call<Pedido> add(@Header("Authorization") String token, @Body PedidoDTO pedido);
}
