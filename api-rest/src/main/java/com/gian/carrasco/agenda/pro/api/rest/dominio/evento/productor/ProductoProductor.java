package com.gian.carrasco.agenda.pro.api.rest.dominio.evento.productor;

import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Producto;

public interface ProductoProductor {
    void producirCreacion(Producto producto);

    void producirEliminacion(Producto producto);
}