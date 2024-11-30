package com.gian.carrasco.agenda.pro.api.rest.aplicacion.puerto.entrada;

import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Estadistica;

import java.util.Optional;

public interface EstadisticaCasoUso {
    Optional<Estadistica> buscarPorId(Integer id);
}