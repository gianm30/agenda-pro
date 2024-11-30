package com.gian.carrasco.agenda.pro.api.rest.infraestructura.config;

import com.gian.carrasco.agenda.pro.api.rest.aplicacion.servicios.EstadisticaServicio;
import com.gian.carrasco.agenda.pro.api.rest.aplicacion.servicios.ProductoServicio;
import com.gian.carrasco.agenda.pro.api.rest.aplicacion.servicios.UsuarioServicio;
import com.gian.carrasco.agenda.pro.api.rest.dominio.evento.productor.ProductoProductor;
import com.gian.carrasco.agenda.pro.api.rest.dominio.puerto.salida.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracion {
    @Bean
    ProductoServicio productoServicio(ProductoRepositorio producto,
                                      CategoriaRepositorio categoria,
                                      MarcaRepositorio marca,
                                      ProductoProductor publicador) {
        return new ProductoServicio(producto, categoria, marca, publicador);
    }

    @Bean
    EstadisticaServicio estadisticaServicio(EstadisticaRepositorio repositorio) {
        return new EstadisticaServicio(repositorio);
    }

    @Bean
    UsuarioServicio usuarioServicio(UsuarioRepositorio repositorio) {
        return  new UsuarioServicio(repositorio);
    }
}