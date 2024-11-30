package com.gian.carrasco.agenda.pro.api.rest.dominio.puerto.salida;

import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Estadistica;

import java.util.Optional;

public interface EstadisticaRepositorio {
    Optional<Estadistica> buscarPorId(Integer id);

    Optional<Estadistica> incrementarEnUno(Integer id);

    Optional<Estadistica> reducirEnUno(Integer id);
}