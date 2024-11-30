package com.gian.carrasco.agenda.pro.api.rest.aplicacion.servicios;

import com.gian.carrasco.agenda.pro.api.rest.aplicacion.puerto.entrada.EstadisticaCasoUso;
import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Estadistica;
import com.gian.carrasco.agenda.pro.api.rest.dominio.puerto.salida.EstadisticaRepositorio;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class EstadisticaServicio implements EstadisticaCasoUso {
    private final EstadisticaRepositorio repositorio;

    @Override
    public Optional<Estadistica> buscarPorId(Integer id) {
        return repositorio.buscarPorId(id);
    }
}