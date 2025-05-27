package org.example.model;
public class Pedido {
    private Integer id;
    private Usuario usuario;
    private Mesa mesa;
    private String descripcion;

    public Pedido() {}

    public Pedido(Usuario usuario, Mesa mesa, String descripcion) {
        this.usuario = usuario;
        this.mesa = mesa;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

