package com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.puerto.salida;

import com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.entidad.EstadisticaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadisticaJpaRepositorio
        extends JpaRepository<EstadisticaEntidad, Integer> {
}