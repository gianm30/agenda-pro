package com.gian.carrasco.agenda.pro.api.rest.dominio.evento;

import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Producto;

public class ProductoCreadoEvento {
    private final Producto producto;

    public ProductoCreadoEvento(Producto producto) {
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }
}