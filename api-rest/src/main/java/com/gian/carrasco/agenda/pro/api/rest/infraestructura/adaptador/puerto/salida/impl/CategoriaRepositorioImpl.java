package com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.puerto.salida.impl;

import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Categoria;
import com.gian.carrasco.agenda.pro.api.rest.dominio.puerto.salida.CategoriaRepositorio;
import com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.mapeo.CategoriaMapeo;
import com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.puerto.salida.CategoriaJpaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoriaRepositorioImpl implements CategoriaRepositorio {
    private final CategoriaJpaRepositorio repositorio;
    private final CategoriaMapeo mapeo;

    @Override
    public Optional<Categoria> buscarPorId(Integer id) {
        return repositorio.findById(id).map(mapeo::enModelo);
    }
}