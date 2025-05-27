package org.example.model;
public class Mesa {
    private Integer id;
    private int numero;
    private int capacidad;
    private boolean ocupada;
    private Usuario user;

    public Mesa() {}

    public Mesa(Integer id, int numero, int capacidad, Usuario user) {
        this.id = id;
        this.numero = numero;
        this.capacidad = capacidad;
        this.user = user;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "id=" + id +
                ", numero=" + numero +
                ", capacidad=" + capacidad +
                ", user=" + user +
                '}';
    }
}
