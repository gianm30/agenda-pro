package com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.puerto.salida;

import com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.entidad.CategoriaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaJpaRepositorio
        extends JpaRepository<CategoriaEntidad, Integer> {
}