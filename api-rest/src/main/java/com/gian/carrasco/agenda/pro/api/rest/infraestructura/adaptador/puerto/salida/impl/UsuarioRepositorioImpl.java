package com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.puerto.salida.impl;

import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Usuario;
import com.gian.carrasco.agenda.pro.api.rest.dominio.puerto.salida.UsuarioRepositorio;
import com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.entidad.UsuarioEntidad;
import com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.mapeo.UsuarioMapeo;
import com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.puerto.salida.UsuarioJpaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UsuarioRepositorioImpl implements UsuarioRepositorio {
    private final UsuarioJpaRepositorio repositorio;
    private final UsuarioMapeo mapeo;

    @Override
    public Optional<Usuario> buscarPorNombre(String nombre) {
        return repositorio.findByNombre(nombre).map(mapeo::enModelo);
    }
}