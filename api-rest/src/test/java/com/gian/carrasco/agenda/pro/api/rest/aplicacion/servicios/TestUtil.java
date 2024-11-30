package com.gian.carrasco.agenda.pro.api.rest.aplicacion.servicios;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.IntStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestUtil {
    public static final int POSICION_INICIAL = 0;

    public static <T> List<T> generar(int elementos, Class<T> tipo) {
        if(elementos <= 0)
            return List.of();
        return IntStream.rangeClosed(1, elementos)
                .mapToObj(x -> {
                    try {
                        return tipo.getDeclaredConstructor().newInstance();
                    } catch(Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();
    }
}