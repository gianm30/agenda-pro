package com.gian.carrasco.agenda.pro.api.rest.presentacion.rest.servicio;

import com.gian.carrasco.agenda.pro.api.rest.presentacion.rest.dto.autenticacion.AutenticacionDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;

@Service
public class JwtServicio {
    private static final String CLAVE_SECRETA =
            "muySeguraClaveSecretaParaJWTDebeSerMuyLarga1234567890";
    private static final int CONVERSION_A_MINUTOS = 1000;
    private static final int EXPIRACION_EN_MS = 300_000;

    private Key getLlave() {
        return Keys.hmacShaKeyFor(CLAVE_SECRETA.getBytes());
    }

    public AutenticacionDto generarToken(String usuario) {
        var inicio = new Date();
        var expiracion = new Date(System.currentTimeMillis() + EXPIRACION_EN_MS);

        String token = Jwts.builder()
                .setSubject(usuario)
                .setIssuedAt(inicio)
                .setExpiration(expiracion)
                .signWith(getLlave(), SignatureAlgorithm.HS256)
                .compact();

        return AutenticacionDto.builder()
                .token(token)
                .inicio(getTiempo(inicio))
                .expiracion(getTiempo(expiracion))
                .duracion(EXPIRACION_EN_MS / CONVERSION_A_MINUTOS)
                .build();
    }

    public String obtenerUsuario(String token) {
        return Jwts.parser()
                .setSigningKey(getLlave())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean esTokenValido(String token, String usuario) {
        return obtenerUsuario(token).equals(usuario) && estaVigente(token);
    }

    private boolean estaVigente(String token) {
        return !Jwts.parser()
                .setSigningKey(getLlave())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }

    private String getTiempo(Date fecha) {
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);

        var aa = convertirEn2Digitos(c.get(Calendar.YEAR));
        var mm = convertirEn2Digitos(c.get(Calendar.MONTH) + 1);
        var dd = convertirEn2Digitos(c.get(Calendar.DATE));
        var h = convertirEn2Digitos(c.get(Calendar.HOUR));
        var m = convertirEn2Digitos(c.get(Calendar.MINUTE));
        var s = convertirEn2Digitos(c.get(Calendar.SECOND));

        return String.format("%s-%s-%s %s:%s:%s", aa, mm, dd, h, m, s);
    }

    private String convertirEn2Digitos(int numero) {
        if(numero >= 0 && numero <= 9)
            return "0" + numero;
        return String.valueOf(numero);
    }
}