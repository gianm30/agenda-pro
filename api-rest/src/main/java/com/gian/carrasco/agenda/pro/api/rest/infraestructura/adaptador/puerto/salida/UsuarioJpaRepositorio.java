package com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.puerto.salida;

import com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.entidad.UsuarioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioJpaRepositorio extends
        JpaRepository<UsuarioEntidad, Integer> {
    Optional<UsuarioEntidad> findByNombre(String usuario);
}