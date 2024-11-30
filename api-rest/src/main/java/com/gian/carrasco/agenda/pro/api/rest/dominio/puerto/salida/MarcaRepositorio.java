package com.gian.carrasco.agenda.pro.api.rest.dominio.puerto.salida;

import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Marca;

import java.util.Optional;

public interface MarcaRepositorio {
    Optional<Marca> buscarPorId(Integer id);
}