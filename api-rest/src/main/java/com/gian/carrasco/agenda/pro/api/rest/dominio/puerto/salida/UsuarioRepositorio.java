package com.gian.carrasco.agenda.pro.api.rest.dominio.puerto.salida;

import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Usuario;
import com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.entidad.UsuarioEntidad;

import java.util.Optional;

public interface UsuarioRepositorio {
    Optional<Usuario> buscarPorNombre(String nombre);
}