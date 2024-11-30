package com.gian.carrasco.agenda.pro.api.rest.dominio.excepciones;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AutenticacionFallidaExcepcion extends UsernameNotFoundException {
    private static final String USUARIO_NO_ENCONTRADO = "Usuario no encontrado";

    public AutenticacionFallidaExcepcion() {
        super(USUARIO_NO_ENCONTRADO);
    }

    public AutenticacionFallidaExcepcion(Throwable cause) {
        super(USUARIO_NO_ENCONTRADO, cause);
    }
}