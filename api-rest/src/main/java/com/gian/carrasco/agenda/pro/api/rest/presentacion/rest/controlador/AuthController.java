package com.gian.carrasco.agenda.pro.api.rest.presentacion.rest.controlador;

import com.gian.carrasco.agenda.pro.api.rest.presentacion.rest.dto.autenticacion.AutenticacionDto;
import com.gian.carrasco.agenda.pro.api.rest.presentacion.rest.servicio.JwtServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtServicio jwtServicio;

    @PostMapping("/login")
    public ResponseEntity<AutenticacionDto> login(
            @RequestParam String usuario, @RequestParam String clave) {
        var datos = new UsernamePasswordAuthenticationToken(usuario, clave);
        var auth = authenticationManager.authenticate(datos);
        return ResponseEntity.ok(jwtServicio.generarToken(auth.getName()));
    }
}