package com.gian.carrasco.agenda.pro.api.rest.dominio.puerto.salida;

import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Categoria;

import java.util.Optional;

public interface CategoriaRepositorio {
    Optional<Categoria> buscarPorId(Integer id);
}