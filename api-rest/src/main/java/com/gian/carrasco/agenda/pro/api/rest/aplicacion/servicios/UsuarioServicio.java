package com.gian.carrasco.agenda.pro.api.rest.aplicacion.servicios;

import com.gian.carrasco.agenda.pro.api.rest.dominio.excepciones.AutenticacionFallidaExcepcion;
import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Usuario;
import com.gian.carrasco.agenda.pro.api.rest.dominio.puerto.salida.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@RequiredArgsConstructor
public class UsuarioServicio implements UserDetailsService {
    private final UsuarioRepositorio repositorio;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) {
        Usuario usuario = repositorio.buscarPorNombre(nombreUsuario)
                .filter(Usuario::getActivo)
                .orElseThrow(AutenticacionFallidaExcepcion::new);

        return org.springframework.security.core.userdetails.User
                .withUsername(usuario.getNombre())
                .password(usuario.getClave())
                .roles(usuario.getRol())
                .build();
    }
}