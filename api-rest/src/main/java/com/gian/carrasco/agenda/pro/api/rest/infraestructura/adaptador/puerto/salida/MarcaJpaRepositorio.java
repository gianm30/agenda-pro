package com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.puerto.salida;

import com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.entidad.MarcaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaJpaRepositorio
        extends JpaRepository<MarcaEntidad, Integer> {
}