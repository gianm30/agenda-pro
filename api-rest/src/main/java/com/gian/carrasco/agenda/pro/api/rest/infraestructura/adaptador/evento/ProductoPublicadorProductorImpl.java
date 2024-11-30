package com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.evento;

import com.gian.carrasco.agenda.pro.api.rest.dominio.evento.productor.ProductoProductor;
import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Producto;
import com.gian.carrasco.agenda.pro.api.rest.dominio.puerto.salida.EstadisticaRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductoPublicadorProductorImpl implements ProductoProductor {
    private final EstadisticaRepositorio repositorio;

    @SneakyThrows
    @Async
    @Override
    public void producirCreacion(Producto producto) {
        repositorio.incrementarEnUno(producto.getCategoria().getId());
    }

    @SneakyThrows
    @Async
    @Override
    public void producirEliminacion(Producto producto) {
        repositorio.reducirEnUno(producto.getCategoria().getId());
    }
}