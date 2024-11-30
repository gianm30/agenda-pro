package com.gian.carrasco.agenda.pro.api.rest.dominio.excepciones;

public class NoExisteCategoriaExcepcion extends RuntimeException {
    public NoExisteCategoriaExcepcion() {
        super("No existe categoría");
    }
}