package com.gian.carrasco.agenda.pro.api.rest.dominio.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IntUtil {
    public static boolean esMayorACero(Integer id) {
        return Optional.ofNullable(id).filter(x -> x > 0).isPresent();
    }
}