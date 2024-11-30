package com.gian.carrasco.agenda.pro.api.rest.dominio.excepciones;

public class NoExisteMarcaExcepcion extends RuntimeException {
    public NoExisteMarcaExcepcion() {
        super("No existe marca");
    }
}