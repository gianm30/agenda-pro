package com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.puerto.salida.impl;

import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Estadistica;
import com.gian.carrasco.agenda.pro.api.rest.dominio.puerto.salida.EstadisticaRepositorio;
import com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.entidad.EstadisticaEntidad;
import com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.mapeo.EstadisticaMapeo;
import com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.puerto.salida.EstadisticaJpaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstadisticaRepositorioImpl implements EstadisticaRepositorio {
    private final EstadisticaJpaRepositorio repositorio;
    private final EstadisticaMapeo mapeo;

    @Override
    public Optional<Estadistica> buscarPorId(Integer id) {
        return repositorio.findById(id).map(mapeo::enModelo);
    }

    @Override
    public Optional<Estadistica> incrementarEnUno(Integer id) {
        var bd = repositorio.findById(id);
        if(bd.isEmpty())
            return Optional.of(repositorio.save(EstadisticaEntidad.builder()
                            .id(id)
                            .cantidad(1)
                            .build()))
                    .map(mapeo::enModelo);
        else {
            var entidad = bd.get();
            entidad.setCantidad(entidad.getCantidad() + 1);
            return Optional.of(repositorio.save(entidad))
                    .map(mapeo::enModelo);
        }
    }

    @Override
    public Optional<Estadistica> reducirEnUno(Integer id) {
        var bd = repositorio.findById(id);
        if(bd.isEmpty())
            return Optional.empty();
        var entidad = bd.get();
        entidad.setCantidad(entidad.getCantidad() - 1);
        return Optional.of(repositorio.save(entidad))
                .map(mapeo::enModelo);
    }
}