package com.gian.carrasco.agenda.pro.api.rest.dominio.excepciones;

public class NoHayIdCategoriaExcepcion extends RuntimeException {
    public NoHayIdCategoriaExcepcion() {
        super("No existe id categoría");
    }
}