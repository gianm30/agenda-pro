package com.gian.carrasco.agenda.pro.api.rest.dominio.excepciones;

public class NoHayIdMarcaExcepcion extends RuntimeException {
    public NoHayIdMarcaExcepcion() {
        super("No existe id marca");
    }
}