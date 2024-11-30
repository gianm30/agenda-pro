package com.gian.carrasco.agenda.pro.api.rest.infraestructura.config;

import com.gian.carrasco.agenda.pro.api.rest.aplicacion.servicios.UsuarioServicio;
import com.gian.carrasco.agenda.pro.api.rest.presentacion.rest.servicio.JwtServicio;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtAutenticacionFiltro extends OncePerRequestFilter {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER = "Bearer ";
    private static final int INDICE_TOKEN = BEARER.length();

    private final JwtServicio jwtServicio;
    private final UsuarioServicio usuarioServicio;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        var autorizacion = Optional.of(request)
                .map(x -> x.getHeader(AUTHORIZATION_HEADER))
                .filter(this::esBearer);

        if(autorizacion.isEmpty()) {
            filterChain.doFilter(request, response);
            return;
        }

        var jwt = autorizacion.get().substring(INDICE_TOKEN);
        var usuario = jwtServicio.obtenerUsuario(jwt);
        var sesion = SecurityContextHolder.getContext().getAuthentication();

        if(usuario != null && sesion == null) {
            var userDetails = usuarioServicio.loadUserByUsername(usuario);
            if(jwtServicio.esTokenValido(jwt, userDetails.getUsername()))
                crearSesion(userDetails, request);
        }

        filterChain.doFilter(request, response);
    }

    private boolean esBearer(String s) {
        return s.startsWith(BEARER);
    }

    private void crearSesion(UserDetails x, HttpServletRequest request) {
        var auth = x.getAuthorities();
        var tkn = new UsernamePasswordAuthenticationToken(x, null, auth);
        tkn.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(tkn);
    }
}