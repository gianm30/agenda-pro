package com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.puerto.salida.impl;

import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Marca;
import com.gian.carrasco.agenda.pro.api.rest.dominio.puerto.salida.MarcaRepositorio;
import com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.mapeo.MarcaMapeo;
import com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.puerto.salida.MarcaJpaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MarcaRepositorioImpl implements MarcaRepositorio {
    private final MarcaJpaRepositorio repositorio;
    private final MarcaMapeo mapeo;

    @Override
    public Optional<Marca> buscarPorId(Integer id) {
        return repositorio.findById(id).map(mapeo::enModelo);
    }
}