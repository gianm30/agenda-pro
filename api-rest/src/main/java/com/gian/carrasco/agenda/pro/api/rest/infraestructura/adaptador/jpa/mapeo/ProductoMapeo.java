package com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.mapeo;

import com.gian.carrasco.agenda.pro.api.rest.dominio.constantes.Constantes;
import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Producto;
import com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.entidad.ProductoEntidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = Constantes.PROVEEDOR_MAPEO)
public interface ProductoMapeo extends MapeoBase<Producto, ProductoEntidad> {
}